import { Pipe, PipeTransform } from '@angular/core';

interface Product {
  id :String;
  productName : String;
  productPrice: number;
  productDescription : String;
  
  imageUrl : String;
}
@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(products: Product[],search: String): Product[] {
    if (search===undefined) {
      return products;
    } else {
    return products.filter(product => {
      return product.productName.toLowerCase().includes(search.toLowerCase());
    });
  }
  }

}