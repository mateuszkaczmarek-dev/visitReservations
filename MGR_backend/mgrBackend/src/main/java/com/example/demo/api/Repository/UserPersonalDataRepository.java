package com.example.demo.api.Repository;

import java.util.List;

import com.example.demo.api.Model.UsersPersonalData;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface UserPersonalDataRepository extends JpaRepository<UsersPersonalData,Long> {
    
    List<UsersPersonalData> findByUsername(String username);
    UsersPersonalData findUserByUsername(String username);
    UsersPersonalData findUserByPesel(String pesel);

}
