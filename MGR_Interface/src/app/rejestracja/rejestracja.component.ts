import { Component, OnInit } from '@angular/core';
import { Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RestapiService } from '../Service/restapi.service';
import { Users } from '../Models/Users';

@Component({
  selector: 'app-rejestracja',
  templateUrl: './rejestracja.component.html',
  styleUrls: ['./rejestracja.component.scss']
})
export class RejestracjaComponent implements OnInit {
  
  user = new Users;
  msg = '';
  
  constructor(private service: RestapiService, private router: Router) { }

  ngOnInit(): void {
  }

  registerUser(){
    if((this.user.username === undefined || this.user.username === '') ||
        (this.user.password === undefined || this.user.password === '') ||
        (this.user.email === undefined || this.user.email === ''))
        {
          console.log("No data");
          this.msg="Uzupełnij wszystkie pola";
        }
    else
    {
      this.service.register(this.user).subscribe(
      data=>
      {
          console.log("response recievied");
          this.msg="Rejestracja się powiodła";
      },
      error=> {
        console.log("exception occured");
        this.msg="Ta nazwa użytkownika jest zajęta";
        
      } 
   
      
    )
    }
  }
}
