import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-user-interfejs',
  templateUrl: './user-interfejs.component.html',
  styleUrls: ['./user-interfejs.component.scss']
})
export class UserInterfejsComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
    if(sessionStorage.getItem('username') !== null && sessionStorage.getItem('Role') === 'VVNFUg==')
    {
      this.router.navigate(['/USER']);
    }
    else
      this.router.navigate(['/home']);
  }

 
}
