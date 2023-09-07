import { Component, OnInit } from '@angular/core';
import {ShopsService} from "../shops.service";
import {ActivatedRoute, Router} from "@angular/router";
import {NewShop} from "../classes/new-shop";
import {catchError} from "rxjs";

@Component({
  selector: 'app-modify-shop',
  templateUrl: './modify-shop.component.html',
  styleUrls: ['./modify-shop.component.scss']
})
export class ModifyShopComponent implements OnInit {

  name: string = "";
  address: string = "";
  phone: string = "";
  email: string = "";
  opens: string = "";
  closes: string = "";

  invalidData: boolean = false;
  backendError: boolean = false;

  loading: boolean = false;

  communicating: boolean = false;

  constructor(private shopService: ShopsService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.loading = true;

    this.shopService.getShop(Number(this.route.snapshot.paramMap.get('id'))).pipe(catchError(err => {
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

      this.loading = false;
      return err;
    })).subscribe(data => {
      this.name = data.name;
      this.address = data.address;
      this.email = data.email;
      this.phone = data.phone;
      this.opens = data.opens;
      this.closes = data.closes;

      this.loading = false;
    });
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

    this.shopService.modifyShop(Number(this.route.snapshot.paramMap.get('id')), newShop).pipe(catchError(err => {
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
