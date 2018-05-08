import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "../login/login.component";
import {UserComponent} from "../user/user.component";
import {NewUserComponent} from "../new-user/new-user.component";
import {UserDetailsComponent} from "../user-details/user-details.component";

const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'user', component: UserComponent},
  {path: 'new-user', component: NewUserComponent},
  {path: 'details/:id', component: UserDetailsComponent,},
  {path: 'edit-user/:id', component: NewUserComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, {onSameUrlNavigation:"reload"})
],
exports: [
  RouterModule
],
  declarations
:
[]
})

export class AppRoutingModule {
}
