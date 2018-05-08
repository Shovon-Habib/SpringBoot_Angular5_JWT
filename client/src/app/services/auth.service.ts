import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class AuthService {

  private baseUrl = 'http://localhost:8082/';

  constructor(private http: HttpClient) {
  }

  attempAuth(email: string, password: string): Observable<any> {
    const credentials = {email: email, password: password};
    console.log('attempAuth ::');
    return this.http.post(this.baseUrl + 'login', credentials, {observe: 'response'});
  }

}
