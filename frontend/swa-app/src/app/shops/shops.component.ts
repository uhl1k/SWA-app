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

  constructor(private shopsService: ShopsService) { }

  ngOnInit(): void {
    this.loading = true;
    this.shopsService.getShops(this.page, 50).pipe(catchError(err => {
      this.loading = false;
      this.error = true;
      return err;
    })).subscribe(data => {
      console.log(data);
      this.shops = data;
      this.loading = false;
    })
  }

}
