package com.example.demo.api.Service;



import java.util.List;

import com.example.demo.api.Model.DoctorPersonalData;
import com.example.demo.api.Repository.DoctorPersonalDataRespository;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class DoctorPersonalDataService {

   private final DoctorPersonalDataRespository repository;

   @Autowired
    public DoctorPersonalDataService(DoctorPersonalDataRespository repository){
        this.repository = repository;
    }

    public List<DoctorPersonalData> findDoctorPersonalData() {
        return repository.findAll();
    }

    public DoctorPersonalData addDoctorPersonalData(DoctorPersonalData doctorPersonalData) {
        return repository.save(doctorPersonalData);
    }

    public void deleteDoctorPersonalData(Long id){
        repository.deleteById(id);
    }

    public DoctorPersonalData updateDoctorPersonalData(DoctorPersonalData doctorPersonalData){
        return repository.save(doctorPersonalData);
    }

    public DoctorPersonalData fetchDoctorByUsername(String username)
    {
        return repository.findUserByUsername(username);
    }

    public DoctorPersonalData fetchDoctorByPwz (String pwz)
    {
        return repository.findByPwz(pwz);
    }
    
}
