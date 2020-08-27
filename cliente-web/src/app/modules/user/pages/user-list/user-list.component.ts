import {Component} from '@angular/core';
import {UserService} from '../../user.service';

@Component({
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent {

  constructor(
    public userService: UserService,
  ) {
  }

}
