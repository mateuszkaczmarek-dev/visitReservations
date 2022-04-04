package com.example.demo.api.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DoctorPersonalData")
public class DoctorPersonalData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long Id;

    @Column(name="Name")
    private String name;

    @Column(name="Surname")
    private String surname;

    @Column(name="Specialization")
    private String specialization;

    @Column(name="Pwz")
    private String pwz;

    @Column(name="Username")
    private String username;


    public DoctorPersonalData() {}

    public DoctorPersonalData(String name , String surname,
    String specialization,String pwz, String username) {
        
        
        this.name = name;
        this.surname = surname;
        this.specialization = specialization;
        this.pwz = pwz;
        this.username = username;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
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

    public String getSpecialization(){
        return specialization;
    }

    public String setSpecialization(String specialization){
        return this.specialization = specialization;
    }

    public String getPwz() {
        return pwz;
    }

    public String setPwz(String pwz) {
        return this.pwz = pwz;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
         this.username = username;
    }


    @Override
    public String toString() {
        return "Konta {" +
                "id=" + Id +
                "name=" + name +
                "surname=" + surname + 
                "specialization" + specialization +
                "pwz" + pwz +
                "username=" + username +
                "}"; 
    }
}
