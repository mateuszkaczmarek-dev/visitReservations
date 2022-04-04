package com.example.demo.api.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Reservations")
public class Reservations implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long Id;

    @Column(name="Pesel")
    private String pesel;

    @Column(name="Name")
    private String name;

    @Column(name="Surname")
    private String surname;

    @Column(name="Day")
    private String day;
    
    @Column(name="Time")
    private String time;

    @Column(name="DoctorName")
    private String doctorName;

    @Column(name="Specialization")
    private String specialization;

    @Column(name="Username")
    private String username;

    public Reservations(){}

    public Reservations(String pesel, String name, String surname, String day, String time, String doctorName, String specialization, String username)
    {
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
        this.day = day;
        this.time = time;
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.username = username;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
         this.name = name;
    }

    public String getSurname(){
       return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time){
        this.time = time;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpecialization(){
        return specialization;
    }

    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }






}
