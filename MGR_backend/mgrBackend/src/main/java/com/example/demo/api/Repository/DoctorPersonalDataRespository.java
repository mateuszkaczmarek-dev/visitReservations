package com.example.demo.api.Repository;

import java.util.List;

import com.example.demo.api.Model.DoctorPersonalData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DoctorPersonalDataRespository extends JpaRepository<DoctorPersonalData,Long> {

    List<DoctorPersonalData> findByUsername(String username);
    DoctorPersonalData findByPwz(String pwz);
    DoctorPersonalData findUserByUsername(String username);
    
}
