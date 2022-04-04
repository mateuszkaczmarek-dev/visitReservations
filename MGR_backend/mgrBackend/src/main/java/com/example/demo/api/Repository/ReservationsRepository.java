package com.example.demo.api.Repository;

import java.util.List;

import com.example.demo.api.Model.Reservations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservations, Long>{
    
    List<Reservations> findByPesel(String pesel);
    Reservations findByDay(String day);
    Reservations findByTime(String time);
    Reservations findByDoctorName(String doctorName);
    Reservations findBySpecialization(String specialization);
}
