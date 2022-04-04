import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DoctorsData } from 'src/app/Models/DoctorsData';
import { RestapiService } from '../../../../Service/restapi.service';

@Component({
  selector: 'app-doctor-data',
  templateUrl: './doctor-data.component.html',
  styleUrls: ['./doctor-data.component.scss']
})
export class DoctorDataComponent implements OnInit {
  doctorData = new DoctorsData;
  doctorDataTable:any;
  msg = '';
  ////--------------------------////
  _name!:string;
  _surname!:string;
  _specialization!:string;
  _pwz!:string;
  _isblocked = false;
  
  constructor(private router:Router, private apiService: RestapiService) {}


  ngOnInit(): void {
    let resp=this.apiService.getAllDoctorPersonalData();
      resp.subscribe((data)=>{this.doctorDataTable=data
      for(const doctor of this.doctorDataTable)
      {
        
        if(doctor.username === sessionStorage.getItem('username'))
          {
          
            this._name = doctor.name;
            this._surname = doctor.surname;
            this._specialization = doctor.specialization;
            this._pwz = doctor.pwz;
            this._isblocked = true;
          }
        else
        {
          this._isblocked = false;
        }
      }
      console.log(this._isblocked);
      });
      if(sessionStorage.getItem('username') !== null && sessionStorage.getItem('Role') === 'RE9DVE9S')
      {
        this.router.navigate(['/DOCTOR/personalData']);
      }
      else
        this.router.navigate(['/home']);
  }

  AddDoctorPersonalData(){
    
    if((this.doctorData.name === undefined || this.doctorData.name === null) ||
        (this.doctorData.surname === undefined || this.doctorData.surname === null) ||
        (this.doctorData.specialization === undefined || this.doctorData.specialization === null) ||
        (this.doctorData.pwz === undefined || this.doctorData.pwz === null)) 
    {
          console.log("No data");
          this.msg="Uzupełnij wszystkie pola";
    }
    else
    {
      this.doctorData.username = sessionStorage.getItem('username');
      this.apiService.addDoctorPersonalData(this.doctorData).subscribe(
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
    console.log(this.doctorData.name,this.doctorData.surname,this.doctorData.specialization,this.doctorData.pwz,this.doctorData.username);
  }

}
