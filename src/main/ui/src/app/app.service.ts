import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http: HttpClient) { }

  rootURL = '/spiral';

  calculateMatrix(rows: string, columns: string) {
      const params = new HttpParams().append('rows', rows).append('cols', columns);
      return this.http.get(this.rootURL, {params});
  }

}
