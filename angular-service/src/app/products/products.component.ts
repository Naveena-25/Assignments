import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  message :string;
  search;
  products;
  constructor(private productService : ProductService ,
     private router:Router
    ) {
   
    this.getProducts();
  }
  getProducts(){
    return this.productService.getData().subscribe(response => {
      console.log(response);
      this.products = response.products;
    }, error => {
      console.log(error);
    })
  }
  deleteProduct(product){
    this.productService.deleteData(product).subscribe(response =>{
      console.log(response);
      if(response.error){
        this.message = 'Failed To Delete The Product';        
      }else{
        this.message = 'Product Deleted Successfully';
      }
      setTimeout(() => {
        this.message = null;
      }, 5000);      

      this.getProducts();
    });
  }
  ngOnInit(): void {
  }
  selectProduct(product){
    this.router.navigate(['/editProduct'], { queryParams : product});
  }

}
