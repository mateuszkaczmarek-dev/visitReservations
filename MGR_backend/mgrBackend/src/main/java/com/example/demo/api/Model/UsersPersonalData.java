package com.example.demo.api.Model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "UserPersonalData")
public class UsersPersonalData implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long Id;

    @Column(name="Pesel",updatable = false, unique = true)
    private String pesel;

    @Column(name="Name")
    private String name;

    @Column(name="Surname")
    private String surname;

    @Column(name="Adress")
    private String adress;
    
    @Column(name="Phone")
    private String phone;

    @Column(name="Date")
    private String date;

    @Column(name="Username")
    private String username;


    public UsersPersonalData() {}

    public UsersPersonalData(String pesel , String name , String surname , 
    String adress,String phone, String date,String username) {
        
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.phone = phone;
        this.date = date;
        this.username = username;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getPesel(){
        return pesel;
    }

    public void setPersel(String pesel) {
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

    public void setSurname(String surname) {
         this.surname = surname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone) {
         this.phone = phone;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date) {
         this.date = date;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
         this.username = username;
    }


    @Override
    public String toString() {
        return "Konta {" +
                "id=" + Id +
                "pesel" + pesel +
                "name=" + name +
                "surname=" + surname +
                "adress=" + adress +
                "phone=" + phone +
                "date=" + date + 
                "username=" + username +
                "}"; 
    }
}