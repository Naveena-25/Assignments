import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  error: String;
  constructor(private authService:AuthService) { }

  ngOnInit(): void {
  }
  loginUser(form:NgForm) {
    this.authService.login(form.value).subscribe(response => {
      console.log(response);
      if (response.error) {
        this.error =response.message;
        setTimeout(()=> {
          this.error = null;
        }, 5000);
      } else {
        localStorage.setItem('userDetails', JSON.stringify(response));
      }
      form.reset();
      
    });
  }

}
