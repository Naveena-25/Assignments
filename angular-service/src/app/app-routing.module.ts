import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AddProductsComponent } from './add-products/add-products.component';
import { ProductsComponent } from './products/products.component';
import { EditProductComponent } from './edit-product/edit-product.component';
import { PostsComponent } from './posts/posts.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AuthGuard } from './auth.guard';


const routes: Routes = [
  {
     path :'products',component:ProductsComponent,
     data : {roles: ['admin'],canActivate:[AuthGuard]}, 
  },
  {
     path :'add-products',component:AddProductsComponent,
     data : {roles: ['admin'],canActivate:[AuthGuard]},
  },
  { path :'editProduct',component:EditProductComponent,
  data : {roles: ['admin'],canActivate:[AuthGuard]},
},
  { path: 'posts', component:PostsComponent,
   data : {roles: ['admin','users'],canActivate:[AuthGuard]},
  },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path:'',redirectTo:'/posts',pathMatch:'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
