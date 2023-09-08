import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {NewShop} from "./classes/new-shop";

@Injectable({
  providedIn: 'root'
})
export class ShopsService {

  constructor(private httpClient: HttpClient) { }

  public getShops(page: number, pageSize: number): Observable<any> {
    return this.httpClient.get('http://localhost:8081/api/shops?page=' + page + "&pageSize=" + pageSize);
  }

  public addShop(shop: NewShop): Observable<any> {
    return this.httpClient.put('http://localhost:8081/api/shops', shop);
  }

  public removeShop(id: number): Observable<any> {
    return this.httpClient.delete('http://localhost:8081/api/shops/' + id);
  }

  public modifyShop(id: number, shop: NewShop): Observable<any> {
    return this.httpClient.post('http://localhost:8081/api/shops/' + id, shop);
  }

  public getShop(id: number): Observable<any> {
    return this.httpClient.get('http://localhost:8081/api/shops/' + id);
  }
}
