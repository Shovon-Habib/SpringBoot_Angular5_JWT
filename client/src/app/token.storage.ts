import {Injectable} from '@angular/core';


const TOKEN_KEY = 'AuthToken';

@Injectable()
export class TokenStorage {

  constructor() {
  }

  signOut() {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.clear();
  }

  public saveToken(token: string) {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(): string {
    return sessionStorage.getItem(TOKEN_KEY);
  }

  public checkToken(): boolean {
    console.log(sessionStorage.getItem(TOKEN_KEY))
    return sessionStorage.getItem(TOKEN_KEY) != null;
  }
}
