import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestapiService } from '../../../../Service/restapi.service';
import { UsersData } from '../../../../Models/UsersData';
import { Validators } from '@angular/forms';

@Component({
  selector: 'app-user-data',
  templateUrl: './user-data.component.html',
  styleUrls: ['./user-data.component.scss']
})
export class UserDataComponent implements OnInit {
  userData = new UsersData;
  userDataTable:any;
  msg = '';
  ////--------------------------////
  _pesel!:string;
  _name!:string;
  _surname!:string;
  _adress!:string;
  _date!:string;
  _phone!:string;
  _isblocked = false;
  
  constructor(private router: Router, private restApiService: RestapiService) { }

  ngOnInit(): void {
    let resp=this.restApiService.getAllUsersPersonalData();
    resp.subscribe((data)=>{this.userDataTable=data
    for(const user of this.userDataTable)
    {
      
      if(user.username === sessionStorage.getItem('username'))
        {
          this._pesel = user.pesel;
          this._name = user.name;
          this._surname = user.surname;
          this._adress = user.adress;
          this._date = user.date;
          this._phone = user.phone;
          this._isblocked = true;
        }
      else
      {
        this._isblocked = false;
      }
    }
    console.log(this._isblocked);
    });
    if(sessionStorage.getItem('username') !== null && sessionStorage.getItem('Role') === 'VVNFUg==')
    {
      this.router.navigate(['/USER/personalData']);
    }
    else
      this.router.navigate(['/home']);
  }

  AddUserPersonalData(){
    
    if((this.userData.pesel === undefined || this.userData.pesel === null) ||
        (this.userData.name === undefined || this.userData.name === null) ||
        (this.userData.surname === undefined || this.userData.surname === null) ||
        (this.userData.adress === undefined || this.userData.adress === null) ||
        (this.userData.date === undefined || this.userData.date === null)) 
    {
          console.log("No data");
          this.msg="Uzupełnij wszystkie pola";
    }
    else
    {
      this.userData.username = sessionStorage.getItem('username');
      this.restApiService.addUserPersonalData(this.userData).subscribe(
      data=>
      {
          console.log("response recievied");
          this.msg="Dane zostaly poprawnie dodane";
      },
      error => 
      {
        console.log("exception occured");
        this.msg="Dane już istnieją, spróbuj ponownie";
        
      } 
    )
    }
  }

}

