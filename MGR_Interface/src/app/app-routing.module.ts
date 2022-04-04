import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RejestracjaComponent } from './rejestracja/rejestracja.component';
import { UserInterfejsComponent } from './interfejsUzytkownika/user-interfejs/user-interfejs.component';
import { AdminInterfejsComponent } from './interfejsAdmina/admin-interfejs/admin-interfejs.component';
import { DoctorInterfejsComponent } from './interfejsLekarza/doctor-interfejs/doctor-interfejs.component';
import { StartingPageComponent } from './stronaStartowa/starting-page/starting-page.component';
import { UserDataComponent } from './interfejsUzytkownika/user-interfejs/userData/user-data/user-data.component';
import { DoctorDataComponent } from './interfejsLekarza/doctor-interfejs/doctorData/doctor-data/doctor-data.component';
import { UserReservationComponent } from './interfejsUzytkownika/user-interfejs/userReservation/user-reservation/user-reservation.component';

const routes: Routes = [
{ path: 'login', component: LoginComponent },
{ path: 'register', component: RejestracjaComponent },
{ path: 'USER', component: UserInterfejsComponent },
{ path: 'ADMIN', component: AdminInterfejsComponent },
{ path: 'DOCTOR', component: DoctorInterfejsComponent },
{ path: 'home', component: StartingPageComponent },
{ path: 'USER/personalData', component: UserDataComponent },
{ path: 'DOCTOR/personalData', component: DoctorDataComponent},
{ path: 'USER/userReservation', component: UserReservationComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
