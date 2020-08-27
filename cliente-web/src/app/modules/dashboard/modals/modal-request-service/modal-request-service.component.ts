import {Component, Input} from '@angular/core';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {UserService} from '../../../user/user.service';
import {ToastService} from '../../../../shared/services/toast.service';

@Component({
  templateUrl: './modal-request-service.component.html',
  styleUrls: ['./modal-request-service.component.scss']
})
export class ModalRequestServiceComponent {

  @Input() serviceNumber: number;
  @Input() cost: number;

  constructor(
    public activeModal: NgbActiveModal,
    private userService: UserService,
    private toastService: ToastService
  ) {
  }

  /**
   * Executed When Form Is Submitted
   */
  onSubmit(): void {
    this.userService.createServiceRequest(this.serviceNumber, this.cost).toPromise().then(() => {
      this.activeModal.close();
      this.toastService.showSuccess('Solicitud enviada');
    });
  }

}
