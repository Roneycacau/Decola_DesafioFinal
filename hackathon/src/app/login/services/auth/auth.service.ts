import { Injectable } from '@angular/core';
import { UserApiModel } from '../../models/user-api-model';
import { HttpClient } from '@angular/common/http';
import { tap, catchError, switchMap, map } from 'rxjs/operators';
import { Observable, of } from 'rxjs';

@Injectable()
export class AuthService {

  constructor(private http: HttpClient) { }
  public loggedUser: UserApiModel;
  public redirectURL: string;

  public login(email: string, password: string):Observable<UserApiModel> {
    
    return this.http.get<UserApiModel>('https://ticketstore-1581086817350.azurewebsites.net/users?email=' + email).pipe(
      map(
        (data) => {
          console.log(data);
          this.loggedUser = data ? data : null;
          if(this.loggedUser.password === password) return this.loggedUser;
          else return null;
        }),
      catchError(
        (err) => { 
          return of(this.loggedUser);
         }
      )
    );
  }

  public logout(): void {
    this.loggedUser = null;
  }
}
