import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './modules/auth/pages/login/login.component';
import {AdminLayoutComponent} from './core/layouts/admin-layout/admin-layout.component';
import {AuthGuard} from './modules/auth/guards/auth.guard';
import {DashboardComponent} from './modules/dashboard/dashboard.component';
import {PageNotFoundComponent} from './shared/pages/page-not-found/page-not-found.component';
import {RegisterComponent} from './modules/auth/pages/register/register.component';
import {UserListComponent} from './modules/user/pages/user-list/user-list.component';
import {OrderComponent} from './modules/order/order.component';

const routes: Routes = [

  {path: '', redirectTo: 'dashboard', pathMatch: 'full'},

  {
    path: 'auth/login',
    component: LoginComponent
  },
  {
    path: 'auth/register',
    component: RegisterComponent
  },

  {
    path: '',
    component: AdminLayoutComponent,
    canActivate: [AuthGuard], // Checking to see if you are logged in.
    children: [
      {path: 'dashboard', component: DashboardComponent},
      {path: 'user-list', component: UserListComponent},
      {path: 'order-list', component: OrderComponent},
    ]
  },

  {path: '**', component: PageNotFoundComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
