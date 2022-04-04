package com.example.demo.api.Service;

import java.util.List;

import com.example.demo.api.Model.Reservations;
import com.example.demo.api.Repository.ReservationsRepository;

import org.springframework.beans.factory.annotation.Autowired;




@org.springframework.stereotype.Service

public class ReservationService {

    private final ReservationsRepository repository;

@Autowired
public ReservationService(ReservationsRepository repository){
    this.repository = repository;
}  

public List<Reservations> findReservation() {
    return repository.findAll();
}

public Reservations addReservation(Reservations reservation) {
    return repository.save(reservation);
}

public Reservations fetchReservationByDay(String day){
        return repository.findByDay(day);
}

public Reservations fetchReservationByTime(String time){
    return repository.findByTime(time);
}

public Reservations fetchReservationByDoctorName(String doctorName){
    return repository.findByDoctorName(doctorName);
}

public void deleteReservation(Long id){
    repository.deleteById(id);
}

}
