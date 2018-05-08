import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {TokenStorage} from "./token.storage";
import 'rxjs/add/observable/throw'
import 'rxjs/add/operator/catch';
import {Injectable} from "@angular/core";

@Injectable()
export class MyHttpInterceptor implements HttpInterceptor {

  constructor(private token: TokenStorage) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    console.log("intercepted request...");

    let authReq = req;
    if (this.token.getToken() != null) {
      authReq = req.clone({headers: req.headers.append('Authorization', 'Bearer ' + this.token.getToken())});
    }

    console.log("Sending request with new header now...");

    return next.handle(authReq)
      .catch((error, caught) => {
        console.log("Error Occurred");
        console.log(error);
        console.log(caught);
        return Observable.throw(error);
      }) as any;
  }

}
