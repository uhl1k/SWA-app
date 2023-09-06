import { Component, OnInit } from '@angular/core';
import { NewShop } from "../classes/new-shop";
import {ShopsService} from "../shops.service";
import {catchError} from "rxjs";
import {Router} from "@angular/router";

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

  invalidData: boolean = false;
  backendError: boolean = false;

  communicating: boolean = false;

  constructor(private shopService: ShopsService, private router: Router) { }

  ngOnInit(): void {
  }

  goBack() {
    this.router.navigate(["/shops"]);
  }

  addNewShop() {
    this.invalidData = false;
    this.backendError = false;
    this.communicating = true;

    let newShop = new NewShop();
    newShop.name = this.name;
    newShop.address = this.address;
    newShop.email = this.email;
    newShop.phone = this.phone;
    newShop.opens = this.opens;
    newShop.closes = this.closes;

    console.log(newShop);

    this.shopService.addShop(newShop).pipe(catchError(err => {
      console.log(err);
      switch (err.status) {
        case 400:
          this.invalidData = true;
          break;
        case 503:
          this.backendError = true;
          break;
        default:
          this.backendError = true;
          break;
      }

      this.communicating = false;
      return err;
    })).subscribe(data => {
      this.router.navigate(["/shops"]);
    });
  }

}
