import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { NgForm } from '@angular/forms';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-add-products',
  templateUrl: './add-products.component.html',
  styleUrls: ['./add-products.component.css']
})
export class AddProductsComponent implements OnInit {
  message:string;

  mySubscription:Subscription;

  constructor(private productService:ProductService) { }
 
  postProduct(form:NgForm){
    this.productService.postData(form.value).subscribe(response => {
      console.log(response);
      form.reset();
      if(!response.error) {
        this.message="Product Added Successfully";
      }
    }, error => {
      console.log(error);
    });
  }
  ngOnInit() {
  }

}
