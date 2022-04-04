package com.example.demo.api.Controler;

import java.util.List;

import com.example.demo.api.Model.DoctorPersonalData;
import com.example.demo.api.Model.Reservations;
import com.example.demo.api.Model.Users;
import com.example.demo.api.Model.UsersPersonalData;
import com.example.demo.api.Service.DoctorPersonalDataService;
import com.example.demo.api.Service.ReservationService;
import com.example.demo.api.Service.UserPersonalDataService;
import com.example.demo.api.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("")
@RestController
public class Controller {

    private final UserService userService;
    private final UserPersonalDataService userPersonalDataService;
    private final DoctorPersonalDataService doctorPersonalDataService;
    private final ReservationService reservationService;

    public Controller(UserService userService, UserPersonalDataService userPersonalDataService,
    DoctorPersonalDataService doctorPersonalDataService, ReservationService reservationService) {
        this.userService = userService;
        this.userPersonalDataService = userPersonalDataService;
        this.doctorPersonalDataService = doctorPersonalDataService;
        this.reservationService = reservationService;
        
    }

    @GetMapping("/allAcc")
    public ResponseEntity<List<Users>> getAllKonta () {
        List<Users> konta = userService.findKonto();
        return new ResponseEntity<>(konta,HttpStatus.OK);

    }

    @PostMapping("/login")
	public Users loginUser(@RequestBody Users user) throws Exception{
		String tempUsername = user.getUsername();
        String tempPassword = user.getPassword();
        Users userObj = null;
        if(tempUsername != null && tempPassword != null) {
            userObj = userService.findUserBy(tempUsername,tempPassword);
        }
        if (userObj == null) {
            throw new Exception("bad credentials");
        }
        return userObj;
	}

	
    @PostMapping("/addAcc")
    public ResponseEntity <Users> addKonto(@RequestBody Users user) throws Exception{
        String tempEmailId = user.getEmail();
        String tempUsername = user.getUsername();
        String tempPassword = user.getPassword();
        if((tempEmailId != null || !"".equals(tempEmailId)) || 
        (tempUsername != null || !"".equals(tempUsername)) || (tempPassword != null || !"".equals(tempPassword)))
        {
           Users newkontoUsername = userService.fetchUserByUsername(tempUsername);
           Users newkontoEmail = userService.fetchUserByEmail(tempEmailId);
            if(newkontoUsername != null || newkontoEmail != null)
            {
                throw new Exception("user with " + tempEmailId + "is already exist");
            }
            
        }

        Users newKonto = null;
        newKonto = userService.addKonto(user);
        return new ResponseEntity<>(newKonto,HttpStatus.CREATED);
    }
    //UserPersonalData table
    @GetMapping("/allUsersPersonalData")
    public ResponseEntity<List<UsersPersonalData>> getAllUserPersonalData () {
        List<UsersPersonalData> konta = userPersonalDataService.findUsersPersonalData();
        return new ResponseEntity<>(konta,HttpStatus.OK);

    }

    @PostMapping("/addUserPersonalData")
    public ResponseEntity <UsersPersonalData> addKonto(@RequestBody UsersPersonalData userPersonalData) throws Exception{
        String tempPesel = userPersonalData.getPesel();
        String tempName = userPersonalData.getName();
        String tempSurname = userPersonalData.getSurname();
        String tempAdress = userPersonalData.getAdress();
        String tempDate = userPersonalData.getDate();
        String tempUsername = userPersonalData.getUsername();
        String tempPhone = userPersonalData.getPhone();
        
        
        if((tempPesel != null || !"".equals(tempPesel)) || 
        (tempName != null || !"".equals(tempName)) || (tempSurname != null || !"".equals(tempSurname)) || (tempAdress != null || !"".equals(tempAdress))
        || (tempDate != null || !"".equals(tempDate)) || (tempUsername != null || !"".equals(tempUsername)) || (tempPhone != null || !"".equals(tempPhone)))
        {
           UsersPersonalData newPersonalDataUsername = userPersonalDataService.fetchUserByUsername(tempUsername);
           UsersPersonalData newPersonalDataPesel = userPersonalDataService.fetchUserByPesel(tempPesel);
            if(newPersonalDataUsername != null || newPersonalDataPesel != null)
            {
                throw new Exception("userData with " + tempPesel + " is already exist");
            }
            
        }
        if((tempPesel == null || "".equals(tempPesel)) || (tempName == null || "".equals(tempName)) || (tempSurname == null || "".equals(tempSurname)) || (tempAdress == null || "".equals(tempAdress))
        || (tempDate == null || "".equals(tempDate)) || (tempUsername == null || "".equals(tempUsername)) || (tempPhone == null || "".equals(tempPhone))) 
        {
            throw new Exception("userData with is empty");
        }
        UsersPersonalData newUserPersonalData = null;
        newUserPersonalData = userPersonalDataService.addUsersPersonalData(userPersonalData);
        return new ResponseEntity<>(newUserPersonalData,HttpStatus.CREATED);
    }
    //DoctorPersonalData

    @GetMapping("/allDoctorsPersonalData")
    public ResponseEntity<List<DoctorPersonalData>> getAllDoctorPersonalData () {
        List<DoctorPersonalData> konta = doctorPersonalDataService.findDoctorPersonalData();
        return new ResponseEntity<>(konta,HttpStatus.OK);

    }

    @PostMapping("/addDoctorPersonalData")
    public ResponseEntity <DoctorPersonalData> addDoctor(@RequestBody DoctorPersonalData doctorPersonalData) throws Exception{
        String tempName = doctorPersonalData.getName();
        String tempSurname = doctorPersonalData.getSurname();
        String tempSpecialization = doctorPersonalData.getSpecialization();
        String tempPwz = doctorPersonalData.getPwz();
        String tempUsername = doctorPersonalData.getUsername();
        
        
        if((tempPwz != null || !"".equals(tempPwz)) || tempSurname != null || !"".equals(tempSurname) || tempPwz != null || "".equals(tempPwz) ||
        tempSpecialization != null || "".equals(tempSpecialization) ||
        tempUsername != null || "".equals(tempUsername))
        {
           DoctorPersonalData newPersonalDataUsername = doctorPersonalDataService.fetchDoctorByUsername(tempUsername);
           DoctorPersonalData newPersonalDataPwz = doctorPersonalDataService.fetchDoctorByPwz(tempPwz);
            if(newPersonalDataUsername != null || newPersonalDataPwz != null)
            {
                throw new Exception("doctor with " + tempPwz + " is already exist");
            }
            
        }
        if((tempName == null || "".equals(tempName)) || (tempSurname == null || "".equals(tempSurname)) || 
        ((tempSpecialization == null || "".equals(tempSpecialization)) || (tempPwz == null || "".equals(tempPwz)) || (tempUsername == null || "".equals(tempUsername))))
        {
            throw new Exception("doctorData is empty" + " " + tempPwz + " " + tempName + " " + tempSurname +  " " + tempUsername + " " + tempSpecialization);
        }

        DoctorPersonalData newDoctorPersonalData = null;
        newDoctorPersonalData = doctorPersonalDataService.addDoctorPersonalData(doctorPersonalData);
        return new ResponseEntity<>(newDoctorPersonalData,HttpStatus.CREATED);
    }

    //Reservations
    @PostMapping("/addReservation")
    public ResponseEntity <Reservations> addReservation(@RequestBody Reservations reservation) throws Exception{
        String tempPesel = reservation.getPesel();
        String tempName = reservation.getName();
        String tempSurname = reservation.getSurname();
        String tempDay = reservation.getDay();
        String tempTime = reservation.getTime();
        String tempSpecialization = reservation.getSpecialization();
        String tempDoctorName = reservation.getDoctorName();
        
        
        if((tempPesel != null || !"".equals(tempPesel)) || 
        (tempName != null || !"".equals(tempName)) || (tempSurname != null || !"".equals(tempSurname)) || (tempDay != null || !"".equals(tempDay))
        || (tempTime != null || !"".equals(tempTime)) || (tempSpecialization != null || !"".equals(tempSpecialization)) || (tempDoctorName != null || !"".equals(tempDoctorName)))
        {
            Reservations newReservationDay = reservationService.fetchReservationByDay(tempDay);
            Reservations newReservationTime = reservationService.fetchReservationByTime(tempTime);
            Reservations newReservationDoctorName = reservationService.fetchReservationByDoctorName(tempDoctorName);
            if(newReservationDay != null && newReservationTime != null && newReservationDoctorName != null)
            {
                throw new Exception("Reservation is already exist");
                
            }
            
        }
        if((tempPesel == null || "".equals(tempPesel)) || (tempName == null || "".equals(tempName)) || (tempSurname == null || "".equals(tempSurname)) || (tempDay == null || "".equals(tempDay))
        || (tempTime == null || "".equals(tempTime)) || (tempSpecialization == null || "".equals(tempSpecialization)) || (tempDoctorName == null || "".equals(tempDoctorName))) 
        {
            throw new Exception("Reservation is empty");
        }
        Reservations newReservation = null;
        newReservation = reservationService.addReservation(reservation);
        return new ResponseEntity<>(newReservation,HttpStatus.CREATED);
    }

    @GetMapping("/allReservations")
    public ResponseEntity<List<Reservations>> getAllReservation () {
        List<Reservations> reservation = reservationService.findReservation();
        return new ResponseEntity<>(reservation,HttpStatus.OK);

    }
    @DeleteMapping("/deleteReservation/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //
    @PutMapping("/updateAcc")
    public ResponseEntity <Users> updateKonto(@RequestBody Users konto){
        Users updatekonto = userService.updateKonto(konto);
        return new ResponseEntity<>(updatekonto,HttpStatus.OK);
    }

    @DeleteMapping("/deleteAcc/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteKonto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findAcc/{email}")
    public ResponseEntity<List<Users>> findUser(@PathVariable String email) {
        List<Users> konto = userService.findByEmail(email);
        return new ResponseEntity<>(konto,HttpStatus.OK);
    }

    
}
