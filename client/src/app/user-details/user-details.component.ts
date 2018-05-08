import {Component, OnInit} from '@angular/core';
import {User} from "../model/user";
import {UserService} from "../services/user.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

  title = "User Details";
  private user: User;
  private id: string;
  private flag: boolean;

  constructor(private userService: UserService,
              private route: ActivatedRoute) {
    console.log("Constructor1")
    this.flag = false;
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = params['id'];
    })
    this.userService.getUser(this.id).subscribe(data => {
      this.user = data;
      this.flag = true;
    })
  }
}
