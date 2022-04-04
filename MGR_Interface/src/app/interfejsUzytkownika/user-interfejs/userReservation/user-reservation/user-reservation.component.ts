import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestapiService } from '../../../../Service/restapi.service';
import { DoctorNameAndSurname } from 'src/app/Models/DoctorNameAndSurname';
import { Reservation } from '../../../../Models/Reservation';
import * as moment from 'moment';
import { DateFilterFn } from '@angular/material/datepicker';
import { MatMomentDateModule } from '@angular/material-moment-adapter';

@Component({
  selector: 'app-user-reservation',
  templateUrl: './user-reservation.component.html',
  styleUrls: ['./user-reservation.component.scss']
})
export class UserReservationComponent implements OnInit {
  msg = '';
  time: any [] = ['8:00-8:30','8:30-9:00','9:00-9:30','9:30-10:00','10:00-10:30','10:30-11:00',
  '11:00-11:30','11:30-12:00','12:00-12:30','12:30-13:00','13:00-13:30','13:30-14:00','14:00-14:30','14:30-15:00'];
  _spec: any [] = ['internista','pediatra','kardiolog','okulista','medycyna pracy'];

  arrDoctor: DoctorNameAndSurname[] = new Array();
   doctorDataTable:any;
  _selectedSpecialization:any;
  _nameValue!: string;
  _surnameValue!: string;
  _peselValue!: string;
  userDataTable:any;
  reservation = new Reservation;
  username: any;
  _allDate:any;
  date = moment();
  
  

 
 
 
  constructor(private router: Router,private restApiService: RestapiService) { }
  
  weekendFilter: DateFilterFn<Date | null> =  (d: Date | null) =>  { 
    if(d === null)
    {
      d = new Date();
    }
    console.log(d);
    const day = d.getDay();
    return day !== 0 && day !== 6;  
  }
    
  ngOnInit(): void {
        
    let resp=this.restApiService.getAllUsersPersonalData();
    resp.subscribe((data)=>{this.userDataTable=data 
      for(const user of this.userDataTable)
      {
        
        if(user.username === sessionStorage.getItem('username'))
          {
            this._nameValue = user.name;
            this._surnameValue = user.surname;
            this._peselValue = user.pesel;
          }
        
      }}
    );
        if(sessionStorage.getItem('username') !== null && sessionStorage.getItem('Role') === 'VVNFUg==')
        {
          this.router.navigate(['/USER/userReservation']);
          
        }
        else
          this.router.navigate(['/home']);
    }

  
  
    
    
    onSelected(){
      
      
      let resp=this.restApiService.getAllDoctorPersonalData();
      resp.subscribe((data)=>{this.doctorDataTable=data
        for(const doctor of this.doctorDataTable) 
        {
        
            if(this.reservation.specialization === doctor.specialization)
              {
                this.arrDoctor.push(new DoctorNameAndSurname(doctor.name,doctor.surname));
             
              }
          
        }
    });

      
      this.arrDoctor = [];
    }

    addRes(){
      
      //console.log(this.reservation.day);
      this.date = this._allDate;
      this.reservation.day = this.date.format('DD') + "-" + this.date.format('MM') + "-" +this.date.format('YYYY');
      
      if((this.reservation.day === undefined || this.reservation.day === '') ||
          (this.reservation.time === undefined || this.reservation.time === '') ||
          (this.reservation.doctorName === undefined || this.reservation.doctorName === '') ||
          (this.reservation.specialization === undefined || this.reservation.specialization === ''))
          {
            console.log("No data");
            this.msg="Uzupełnij wszystkie pola";
          }
      else
      {
        
        this.reservation.username = sessionStorage.getItem('username');
        this.reservation.name = this._nameValue;
        this.reservation.surname = this._surnameValue;
        this.reservation.pesel = this._peselValue;
        
        
        console.log(this.reservation);
        
        this.restApiService.addReservation(this.reservation).subscribe(
        data=>
        {
          
            console.log("response recievied");
            this.msg="Rejestracja się powiodła";
        },
        error=> {
          console.log("exception occured");
          this.msg="Nie można zarezerwować wizyty na tę godzinę";
        } 
     
        
      )
      }
}
}

