import {Component} from '@angular/core';
import {TokenStorage} from "./token.storage";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Test App';
  tokenValid: boolean;

  constructor(private token: TokenStorage,
              private router: Router) {
  }

  ngOnInit(){
    this.tokenValid = this.token.checkToken();
  }

  logout(): void {
    if (this.token.checkToken()) {
      this.token.signOut();
    }
    this.router.navigate(["login"]);
  }
}
