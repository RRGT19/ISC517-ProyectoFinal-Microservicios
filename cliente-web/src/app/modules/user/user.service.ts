import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {CONSTANTS} from '../../shared/utilities/Constants';
import {IOrder, IUser} from './user.models';
import {AuthService} from '../auth/auth.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private bsUsers: BehaviorSubject<IUser[]> = new BehaviorSubject([]);
  private readonly users$: Observable<IUser[]> = this.bsUsers.asObservable();

  constructor(
    private http: HttpClient,
    private authService: AuthService
  ) {
  }

  getAll(): Observable<IUser[]> {
    if (this.bsUsers.getValue().length === 0) {
      this.reload();
    }

    return this.users$;
  }

  reload(): void {
    this.http.get<IUser[]>(
      CONSTANTS.API_URL + CONSTANTS.MICROSERVICE_USERS + 'users'
    )
      .toPromise().then(res => this.bsUsers.next(res));
  }

  getOrders(): Observable<IOrder[]> {
    return this.http.get<IOrder[]>(
      CONSTANTS.API_URL + CONSTANTS.MICROSERVICE_EVENTS + 'events',
    );
  }

  createServiceRequest(serviceNumber: number, cost: number): Observable<any> {
    return this.http.post<any>(
      CONSTANTS.API_URL + CONSTANTS.MICROSERVICE_EVENTS + 'create',
      {
        serviceNumber: serviceNumber,
        cost: cost,
        userId: this.authService.currentUserValue.id,
        userEmail: this.authService.currentUserValue.email
      }
    );
  }

}
