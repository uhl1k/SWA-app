import { Component, OnInit } from '@angular/core';
import {Shop} from "../classes/shop";
import {ShopsService} from "../shops.service";
import {catchError} from "rxjs";

@Component({
  selector: 'app-shops',
  templateUrl: './shops.component.html',
  styleUrls: ['./shops.component.scss']
})
export class ShopsComponent implements OnInit {

  shops!: Shop[];
  loading: boolean = false;
  error: boolean = false;
  page: number = 0;
  lastPage: number = 0;

  removeFailed: boolean = false;

  constructor(private shopsService: ShopsService) { }

  ngOnInit(): void {
    this.loading = true;
    this.shopsService.getShops(this.page, 50).pipe(catchError(err => {
      this.loading = false;
      this.error = true;
      return err;
    })).subscribe(data => {
      console.log(data);
      this.shops = data.data;
      this.loading = false;
      this.lastPage = data.totalPages;
    })
  }

  remove(id: number): void {
    this.shopsService.removeShop(id).pipe(catchError(err => {
      this.removeFailed = true;
      return err;
    })).subscribe(data => {
      this.removeFailed = false;
    })
  }
}
