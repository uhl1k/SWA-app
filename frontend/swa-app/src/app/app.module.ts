import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BooksComponent } from './books/books.component';
import { AuthorsComponent } from './authors/authors.component';
import { ShopsComponent } from './shops/shops.component';
import {HttpClientModule} from "@angular/common/http";
import { NewShopComponent } from './new-shop/new-shop.component';
import {FormsModule} from "@angular/forms";
import { ModifyShopComponent } from './modify-shop/modify-shop.component';

@NgModule({
  declarations: [
    AppComponent,
    BooksComponent,
    AuthorsComponent,
    ShopsComponent,
    NewShopComponent,
    ModifyShopComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
