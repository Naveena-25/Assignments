import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AddProductsComponent } from './add-products/add-products.component';
import { ProductsComponent } from './products/products.component';
import { EditProductComponent } from './edit-product/edit-product.component';


const routes: Routes = [
  { path :'products',component:ProductsComponent},
  { path :'add-products',component:AddProductsComponent},
  { path :'edit-products',component:EditProductComponent},
  { path:'',redirectTo:'/products',pathMatch:'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
