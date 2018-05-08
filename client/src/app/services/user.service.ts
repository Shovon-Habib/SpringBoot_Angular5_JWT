import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from 'rxjs/Observable';
import {Message} from "../model/message";
import {User} from "../model/user";

const httpOption = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class UserService {

  constructor(private http: HttpClient) {
  }

  private baseUrl = 'http://localhost:8082/';

  public getUsers(): Observable<any> {
    return this.http.get(this.baseUrl + 'user');
  }

  public createUser(user: User) {
    return this.http.post<Message>(this.baseUrl + "user/", user, httpOption);
  }

  public getUser(id: string): Observable<any> {
    return this.http.get(this.baseUrl + "user/" + id, httpOption);
  }

  public deleteUser(id: string): Observable<any> {
    httpOption.headers = httpOption.headers.append("id", id);
    return this.http.delete(this.baseUrl + 'user/', httpOption);
  }

  public editUser(user: User): Observable<any> {
    return this.http.put(this.baseUrl + "user/", user);
  }
}
