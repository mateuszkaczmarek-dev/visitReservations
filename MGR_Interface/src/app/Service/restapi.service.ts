import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Users } from '../Models/Users';
import { UsersData } from '../Models/UsersData';
import { DoctorsData } from '../Models/DoctorsData';
import { Reservation } from '../Models/Reservation';


@Injectable({
  providedIn: 'root'
})
export class RestapiService {

  constructor(private http: HttpClient) { }

  public register(user: Users): Observable<any> {
    return this.http.post<any>("http://localhost:8080/addAcc",user);
  }

  getAllUsers(): Observable<Users[]> {
    return this.http.get<Users[]>("http://localhost:8080/allAcc");
 }

 public loginUserFromRemote(user: Users): Observable<any> {
   return this.http.post<any>('http://localhost:8080/login',user);
 }

 public getUserByEmail(email:string){
  return this.http.get("http://localhost:8080/findAcc/" + email);
}

public deleteUser(id:number){
  return this.http.delete("http://localhost:8080/deleteAcc/" + id);
}

//USER PERSONAL DATA 

public addUserPersonalData(userData: UsersData): Observable<any> {
  return this.http.post<any>("http://localhost:8080/addUserPersonalData",userData);
}
getAllUsersPersonalData(): Observable<UsersData[]> {
  return this.http.get<UsersData[]>("http://localhost:8080/allUsersPersonalData");
}

//DOCTOR PERSONAL DATA
public addDoctorPersonalData(doctorData: DoctorsData): Observable<any> {
  return this.http.post<any>("http://localhost:8080/addDoctorPersonalData",doctorData);
}
getAllDoctorPersonalData(): Observable<DoctorsData[]> {
  return this.http.get<DoctorsData[]>("http://localhost:8080/allDoctorsPersonalData");
}

//RESERVATION SERVICE
public addReservation(reservation: Reservation): Observable<any> {
  return this.http.post<any>("http://localhost:8080/addReservation",reservation);
}

getAllReservations(): Observable<Reservation[]> {
  return this.http.get<Reservation[]>("http://localhost:8080/allDoctorsPersonalData");
}


public deleteReservation(id:number){
  return this.http.delete("http://localhost:8080/deleteReservation/" + id);
}


}
