import { Injectable } from '@angular/core';
import { Store } from "../../../core/models/store";
import { MovieApiModel } from '../../models/movie-api-model';
import { HttpClient } from '@angular/common/http';
import { Observable, of, observable } from 'rxjs';
import { tap, catchError, map } from 'rxjs/operators';

@Injectable()
export class MovieService extends Store<MovieApiModel[]>{

  constructor(private http: HttpClient) {
    super([]);
  }

  public load(): void {
    this.http.get<MovieApiModel[]>('https://ticketstore-1581086817350.azurewebsites.net/movies').subscribe(
      {
        next: (data) => { this.setState(data); },
        error: (err) => { }
      }
    )
  }

  public add(movie: MovieApiModel): Observable<any> {
    return this.http.post('https://ticketstore-1581086817350.azurewebsites.net/movies', movie);
  }

  public getById(id: number): Observable<MovieApiModel> {
    let movie: MovieApiModel;
    return this.http.get<MovieApiModel>('https://ticketstore-1581086817350.azurewebsites.net/movies/' + id).pipe(
      map(data => {
        return data;
      }),
      catchError(err => {
        return of(movie);
      })
    )
  }

}
