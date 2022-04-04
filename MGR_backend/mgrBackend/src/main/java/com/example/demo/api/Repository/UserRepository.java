package com.example.demo.api.Repository;

import java.util.List;


import com.example.demo.api.Model.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




 @Repository
public interface UserRepository extends JpaRepository <Users, Long> {
    List<Users> findByEmail(String email);
    Users findByUsernameAndPassword(String username,String password);
    Users findUserByUsername(String username);
    Users findUserByEmail(String emial);
}
