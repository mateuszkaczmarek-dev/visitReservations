import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RejestracjaComponent } from './rejestracja/rejestracja.component';
import { RestapiService } from './Service/restapi.service';
import { UserInterfejsComponent } from './interfejsUzytkownika/user-interfejs/user-interfejs.component';
import { AdminInterfejsComponent } from './interfejsAdmina/admin-interfejs/admin-interfejs.component';
import { DoctorInterfejsComponent } from './interfejsLekarza/doctor-interfejs/doctor-interfejs.component';
import { StartingPageComponent } from './stronaStartowa/starting-page/starting-page.component';
import { UserDataComponent } from './interfejsUzytkownika/user-interfejs/userData/user-data/user-data.component';
import { DoctorDataComponent } from './interfejsLekarza/doctor-interfejs/doctorData/doctor-data/doctor-data.component';
import { UserReservationComponent } from './interfejsUzytkownika/user-interfejs/userReservation/user-reservation/user-reservation.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatInputModule} from '@angular/material/input';
import { MatNativeDateModule } from '@angular/material/core';
import { MatFormFieldModule } from '@angular/material/form-field'
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MAT_DATE_FORMATS } from '@angular/material/core';
import { MatMomentDateModule } from "@angular/material-moment-adapter";

const MY_FORMATS = {
  parse: {
    dateInput: 'DD MMMM YYYY',
  },
  display: {
    dateInput: 'DD MMMM YYYY',
    monthYearLabel: 'MMMM YYYY',
    dateA11yLabel: 'LL',
    monthYearA11yLabel: 'MMMM YYYY',
  },
};

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RejestracjaComponent,
    UserInterfejsComponent,
    AdminInterfejsComponent,
    DoctorInterfejsComponent,
    StartingPageComponent,
    UserDataComponent,
    DoctorDataComponent,
    UserReservationComponent,
    
    
  ],

  
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    MatDatepickerModule,
    MatInputModule,
    MatNativeDateModule,
    MatFormFieldModule,
    BrowserAnimationsModule,
    MatMomentDateModule
  ],
  providers: [RestapiService,{ provide: MAT_DATE_FORMATS, useValue: MY_FORMATS }],
  bootstrap: [AppComponent]
})
export class AppModule { }
