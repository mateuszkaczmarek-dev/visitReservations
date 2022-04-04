package com.example.demo.api.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Users")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long Id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name="role")
    private String role;


    public Users() {}

    public Users(String username , String password , String email , String role) {
        
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
         this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
         this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
         this.email = email;
    }

    public String getRole(){
        return role;
    }

    public void setRole(String role) {
         this.role = role;
    }

    @Override
    public String toString() {
        return "Konta {" +
                "id=" + Id +
                "username=" + username +
                "password=" + password +
                "email=" + email +
                "role=" + role + 
                "}"; 
    }

}
