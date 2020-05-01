import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

myUrl='http://localhost:8080/users';
  constructor(private http: HttpClient) { }

  register(userDetails) {
    return this.http.post<any>('${this.myUrl}/register',userDetails);
  }
  login(userDetails){
    return this.http.post<any>('${this.myUrl}/login',userDetails);
  }
}