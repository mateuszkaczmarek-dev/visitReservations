import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from 'src/app/app.component';
import { Users } from 'src/app/Models/Users';
import { LoginComponent } from '../../login/login.component';
import { RestapiService } from '../../Service/restapi.service';

@Component({
  selector: 'app-admin-interfejs',
  templateUrl: './admin-interfejs.component.html',
  styleUrls: ['./admin-interfejs.component.scss']
})
export class AdminInterfejsComponent implements OnInit {
  
  constructor(private router:Router, private restApiService: RestapiService) {}
  user:any;
  email:any;
  ngOnInit(): void {
    
    let resp=this.restApiService.getAllUsers();
    resp.subscribe((data)=>this.user=data);
    if(sessionStorage.getItem('username') !== null && sessionStorage.getItem('Role') === 'QURNSU4=')
    {
      this.router.navigate(['/ADMIN']);
    }
    else
      this.router.navigate(['/home']);
    

    
    
  }

  public deleteUserById(id:number)
  {
    let resp= this.restApiService.deleteUser(id);
    resp.subscribe((data)=>this.user=data);
    location.reload();
  }
   
  public findUserByEmailId()
  {
    let resp= this.restApiService.getUserByEmail(this.email);
    resp.subscribe((data)=>this.user=data);
  }
   
}
