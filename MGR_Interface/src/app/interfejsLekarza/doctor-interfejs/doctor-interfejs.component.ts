import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginComponent } from 'src/app/login/login.component';

@Component({
  selector: 'app-doctor-interfejs',
  templateUrl: './doctor-interfejs.component.html',
  styleUrls: ['./doctor-interfejs.component.scss']
})
export class DoctorInterfejsComponent implements OnInit {
  
  constructor(private router: Router) { }

  ngOnInit(): void {
    if(sessionStorage.getItem('username') !== null && sessionStorage.getItem('Role') === 'RE9DVE9S')
    {
      this.router.navigate(['/DOCTOR']);
    }
    else
      this.router.navigate(['/home']);
  }

  

}
