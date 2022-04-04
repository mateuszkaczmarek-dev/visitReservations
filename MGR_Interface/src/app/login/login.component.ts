import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestapiService } from '../Service/restapi.service';
import { AppComponent } from '../app.component';
import { Users } from '../Models/Users';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router, private restApiService: RestapiService) { }
  

  user = new Users();
  
  msg = '';
  invalidLogin = false

  ngOnInit(): void {
    
  }
  
  public login(username: string, password: string) {
    this.user.username = username;
    this.user.password = password;
    this.restApiService.loginUserFromRemote(this.user).subscribe(
      data => {console.log("response recieved"),
      
      this.user = data;
      sessionStorage.setItem('username',this.user.username);
      sessionStorage.setItem('Role',btoa(this.user.role));
      if(this.user.role === 'USER')
      {
        this.router.navigate(['/USER']);
      }
      else if(this.user.role === 'ADMIN')
      {
        this.router.navigate(['/ADMIN']);
      }
      else
        this.router.navigate(['/DOCTOR']);
    },
      error => {
      console.log("exception occured");
      this.msg = "Złe dane logowania";
      Response.toString(); 
      }
      
    )
  }

  
 
}
  
  

  


