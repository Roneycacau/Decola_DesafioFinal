import { Injectable } from '@angular/core';
import { TicketApiModel } from '../../models/ticket-api-model';
import { Store } from 'src/app/core/models/store';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TicketService extends Store<TicketApiModel[]>{

  constructor(private http: HttpClient) {
    super([]);
  }

  public load(): void {
    this.http.get<TicketApiModel[]>('https://ticketstore-1581086817350.azurewebsites.net/tickets').subscribe(
      {
        next: (data) => { this.setState(data); },
        error: (err) => { }
      }
    )
  }

  public add(ticket: TicketApiModel): Observable<any> {
    return this.http.post('https://ticketstore-1581086817350.azurewebsites.net/tickets', ticket);
  }

  public getBySession(sessionId: number):Observable<TicketApiModel[]>{
    return this.http.get<TicketApiModel[]>('https://ticketstore-1581086817350.azurewebsites.net/tickets/ticketsSession?sessionId=' + sessionId);
    //está certo
  }

  public getByUser(userId: number):Observable<TicketApiModel[]>{
    //return this.http.get<TicketApiModel[]>('https://ticketstore-1581086817350.azurewebsites.net/tickets/ticketsUser?userId=' + userId);
    return this.http.get<TicketApiModel[]>('https://ticketstore-1581086817350.azurewebsites.net/tickets/ticketsUser?userId=' + userId);
  }


}