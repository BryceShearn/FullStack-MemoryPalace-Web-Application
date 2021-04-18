import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Room } from '../models/room';

@Injectable({
  providedIn: 'root'
})
export class FrontEndService {

  private baseUrl = 'http://localhost:8084/';
  private url = this.baseUrl + 'api/rooms'

  constructor(
    private http: HttpClient
  ) { }

  index(): Observable<Room[]> {
    return this.http.get<Room[]>(this.url).pipe(
      catchError((err: any) => {
        console.error('front-endService.index(): error retrieving rooms: ' + err);
        return throwError(err);
      })
    );
  }

}
