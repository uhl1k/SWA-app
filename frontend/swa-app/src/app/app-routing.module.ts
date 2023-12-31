import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {BooksComponent} from "./books/books.component";
import {AuthorsComponent} from "./authors/authors.component";
import {ShopsComponent} from "./shops/shops.component";
import {NewShopComponent} from "./new-shop/new-shop.component";
import {ModifyShopComponent} from "./modify-shop/modify-shop.component";

const routes: Routes = [
  { path: 'books', component: BooksComponent },
  { path: 'authors', component: AuthorsComponent },
  { path: 'shops', component: ShopsComponent },
  { path: 'new-shop', component: NewShopComponent },
  { path: 'modify-shop/:id', component: ModifyShopComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
