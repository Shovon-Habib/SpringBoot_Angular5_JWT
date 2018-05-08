import {Component, OnInit} from '@angular/core';
import {User} from "../model/user";
import {Router} from "@angular/router";
import {UserService} from "../services/user.service";
import {TokenStorage} from "../token.storage";


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})

export class UserComponent implements OnInit {

  users: User[];

  constructor(private router: Router,
              private userService: UserService,
              private token: TokenStorage) {
    if (!this.token.checkToken()) {
      this.router.navigate(['login']);
    }
  }

  ngOnInit() {
    this.userService.getUsers().subscribe(
      data => {
        this.users = data;
      }
    )
  }

  getDetails(user: User): void {
    this.router.navigate(["/details/" + user.id]);
  }

  delete(user: User): void {
    this.userService.deleteUser(user.id)
      .subscribe(data => {
        alert(data.message);
        window.location.reload();
      })
  }

  edit(user: User): void {
    this.router.navigate(["edit-user/" + user.id]);
  }
}
