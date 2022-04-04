import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginComponent } from './login/login.component';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'MGR_Interface';
  userFromSession:any;
  logoutValue = 0;
  username:any;
  getRole:any;
  tempRole:any;
  
  constructor(private router: Router) {}

  ngOnInit(): void {
  }

  public logout() {
    
    sessionStorage.clear();
    this.router.navigate(['/login']);
   
  }

  check() {
    
    this.userFromSession = sessionStorage.getItem('username');
    if (this.userFromSession !== null) 
    {
      this.logoutValue = 1; //wyloguj
      this.username = this.userFromSession;
      this.getRole = sessionStorage.getItem('Role');
      this.tempRole = atob(this.getRole);
    } 
    if(this.userFromSession === null)
    {
      this.logoutValue = 0;//zaloguj
    }
    
    return this.logoutValue;
  }
}
