import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';
import {CONSTANTS} from '../../shared/utilities/Constants';
import {map} from 'rxjs/operators';
import {IUser} from '../user/user.models';

/**
 * The authentication service is used to login and logout of the application.
 * The logged in user details are stored in local storage so the user will stay
 * logged in if they refresh the browser and also between browser sessions until they logout.
 */

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private storage: Storage = localStorage;

  constructor(
    private http: HttpClient,
    private router: Router,
  ) {
  }

  public get currentUserValue(): IUser {
    return this.user;
  }

  /**
   * Posts the users credentials to the api and checks the response for a User object,
   * if there is one it means authentication was successful so the user details
   * are added to local storage.
   */
  login(username: string, password: string): Observable<any> {
    return this.http.post<any>(
      CONSTANTS.API_URL + CONSTANTS.MICROSERVICE_USERS + 'login',
      {username: username, password: password}
    )
      .pipe(
        map((user: IUser) => {
          this.storage.setItem('currentUser', JSON.stringify(user));
          return user;
        })
      );
  }

  register(user: IUser): Observable<any> {
    return this.http.post<any>(
      CONSTANTS.API_URL + CONSTANTS.MICROSERVICE_USERS + 'create',
      user
    );
  }

  logout() {
    this.clearAll();
    this.router.navigateByUrl('/auth/login');
  }

  private clearAll() {
    this.storage.clear();
  }

  private get user() {
    return JSON.parse(this.storage.getItem('currentUser'));
  }

}
