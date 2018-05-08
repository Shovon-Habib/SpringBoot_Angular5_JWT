import {Component, OnInit} from '@angular/core';
import {User} from "../model/user";
import {UserService} from "../services/user.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-new-user',
  templateUrl: './new-user.component.html',
  styleUrls: ['./new-user.component.css']
})
export class NewUserComponent implements OnInit {

  user: User = new User();
  title: string;
  flag: boolean;

  constructor(private userService: UserService,
              private router: Router,
              private route: ActivatedRoute) {
    this.title = (!this.router.url.toString().includes("/edit-user/")) ? "New Registration" : "Update Details";
    this.flag = this.router.url.toString().includes("/edit-user/");
  }

  ngOnInit() {
    if (this.router.url.toString().includes("/edit-user/")) {
      let id: string;
      this.route.params.subscribe(params => {
        id = params['id'];
      });
      this.userService.getUser(id).subscribe(
        data => {
          this.user = data;
        }
      );
    }
  }

  createUser(): void {
    this.userService.createUser(this.user).subscribe(
      message => {
        alert(message.message);
        this.router.navigate(["login"]);
      }
    )
  }

  editUser(): void {
    this.userService.editUser(this.user).subscribe(
      data => {
        alert(data.message);
      }
    )
  }
}
