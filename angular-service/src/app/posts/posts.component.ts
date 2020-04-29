import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {

    constructor(private http:HttpClient) { }
  
    getPosts(){
      this.http.get('/getPosts').subscribe(data=>{
        console.log(data);
      });
    }
  
    ngOnInit(): void {
    }

}
