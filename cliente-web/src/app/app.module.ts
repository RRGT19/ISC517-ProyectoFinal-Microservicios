import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {PageNotFoundComponent} from './shared/pages/page-not-found/page-not-found.component';
import {LoginComponent} from './modules/auth/pages/login/login.component';
import {DashboardComponent} from './modules/dashboard/dashboard.component';
import {AdminLayoutComponent} from './core/layouts/admin-layout/admin-layout.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgbDatepickerModule, NgbModalModule} from '@ng-bootstrap/ng-bootstrap';
import {ToastNoAnimationModule} from 'ngx-toastr';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {UserListComponent} from './modules/user/pages/user-list/user-list.component';
import {ContentTypeInterceptor} from './core/interceptors/content-type.interceptor';
import {ErrorInterceptor} from './core/interceptors/error.interceptor';
import {RegisterComponent} from './modules/auth/pages/register/register.component';
import {ModalRequestServiceComponent} from './modules/dashboard/modals/modal-request-service/modal-request-service.component';
import { OrderComponent } from './modules/order/order.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    DashboardComponent,
    LoginComponent,
    PageNotFoundComponent,
    UserListComponent,
    RegisterComponent,
    ModalRequestServiceComponent,
    OrderComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    ToastNoAnimationModule.forRoot({
      timeOut: 4000,
      closeButton: true
    }),
    NgbModalModule,
    NgbDatepickerModule
  ],
  providers: [
    // {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: ContentTypeInterceptor, multi: true},
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
