import { Component, OnInit } from '@angular/core';
import { NewShop } from "../classes/new-shop";
import {ShopsService} from "../shops.service";
import {catchError} from "rxjs";

@Component({
  selector: 'app-new-shop',
  templateUrl: './new-shop.component.html',
  styleUrls: ['./new-shop.component.scss']
})
export class NewShopComponent implements OnInit {

  name: string = "";
  address: string = "";
  phone: string = "";
  email: string = "";
  opens: string = "";
  closes: string = "";

  constructor(private shopService: ShopsService) { }

  ngOnInit(): void {
  }

  addNewShop() {
    let newShop = new NewShop();
    newShop.name = this.name;
    newShop.address = this.address;
    newShop.email = this.email;
    newShop.phone = this.phone;
    newShop.opens = this.opens;
    newShop.closes = this.closes;

    console.log(newShop);

    this.shopService.addShop(newShop).pipe(catchError(err => {

      return err;
    })).subscribe(data => {

    });
  }

}
