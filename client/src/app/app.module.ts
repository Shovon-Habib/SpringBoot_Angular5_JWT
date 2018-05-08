import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from "@angular/forms";
import {NgModule} from '@angular/core';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {UserComponent} from './user/user.component';
import {AppRoutingModule} from "./core/app-routing.module";
import {UserService} from "./services/user.service";
import {AuthService} from "./services/auth.service";
import {TokenStorage} from "./token.storage";
import {MyHttpInterceptor} from "./my-http-interceptor";
import { NewUserComponent } from './new-user/new-user.component';
import { UserDetailsComponent } from './user-details/user-details.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserComponent,
    NewUserComponent,
    UserDetailsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [
    UserService,
    AuthService,
    TokenStorage,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: MyHttpInterceptor,
      multi: true
    }],
  bootstrap: [AppComponent]
})
export class AppModule {
}
