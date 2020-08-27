import {Component, OnInit} from '@angular/core';
import {UserService} from '../user/user.service';
import {IOrder} from '../user/user.models';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent implements OnInit {

  orders: IOrder[];

  constructor(
    private userService: UserService,
  ) {
  }

  ngOnInit(): void {
    this.userService.getOrders().toPromise().then(res => this.orders = res);
  }

}
