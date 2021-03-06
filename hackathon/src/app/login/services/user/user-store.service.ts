import { Injectable } from '@angular/core';
import { Store } from 'src/app/core/models/store';
import { UserApiModel } from '../../models/user-api-model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()

export class UserStoreService extends Store<UserApiModel[]> {

  constructor(private http: HttpClient) {
    super([]);
  }

  public add(user: UserApiModel): Observable<any> {
    return this.http.post('https://ticketstore-1581086817350.azurewebsites.net/users', user)
  }
}
