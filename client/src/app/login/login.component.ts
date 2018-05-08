import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../services/auth.service";
import {TokenStorage} from "../token.storage";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email: string;
  password: string;

  constructor(private router: Router,
              private authService: AuthService,
              private token: TokenStorage) {
  }

  ngOnInit() {
  }

  login(): void {
    this.authService.attempAuth(this.email, this.password)
      .subscribe(
        data => {
          if (data.status == 200) {
            this.token.saveToken(data.headers.get('Authorization'));
            this.router.navigate(['user']);
          }
        },
        err => {
          alert("Invalid credential");
        });

  }
}
