import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ShopsService {

  constructor(private httpClient: HttpClient) { }

  public getShops(page: number, pageSize: number): Observable<any> {
    return this.httpClient.get('http://' + location.hostname + ':8080/api/shops?page=' + page + "&pageSize=" + pageSize);
  }
}
