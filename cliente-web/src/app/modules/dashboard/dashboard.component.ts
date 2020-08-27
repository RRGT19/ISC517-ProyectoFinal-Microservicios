import {Component, OnInit} from '@angular/core';
import {ModalRequestServiceComponent} from './modals/modal-request-service/modal-request-service.component';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  constructor(
    private modalService: NgbModal,
  ) {
  }

  ngOnInit() {
  }

  openModal(serviceNumber: number, cost: number) {
    const modalRef = this.modalService.open(ModalRequestServiceComponent);
    modalRef.componentInstance.serviceNumber = serviceNumber;
    modalRef.componentInstance.cost = cost;
  }

}
