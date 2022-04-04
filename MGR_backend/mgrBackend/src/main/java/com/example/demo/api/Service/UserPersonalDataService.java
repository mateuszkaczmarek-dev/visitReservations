package com.example.demo.api.Service;
import java.util.List;

import com.example.demo.api.Model.UsersPersonalData;
import com.example.demo.api.Repository.UserPersonalDataRepository;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class UserPersonalDataService {
    
    private final UserPersonalDataRepository repository;

    @Autowired
    public UserPersonalDataService(UserPersonalDataRepository repository) {
        this.repository = repository;
    }

    public List<UsersPersonalData> findUsersPersonalData() {
        return repository.findAll();
    }

    public UsersPersonalData addUsersPersonalData(UsersPersonalData konto) {
        return repository.save(konto);
    }

    public void deleteUsersPersonalData(Long id){
        repository.deleteById(id);
    }

    public UsersPersonalData updateUsersPersonalData(UsersPersonalData konto){
        return repository.save(konto);
    }


    public UsersPersonalData fetchUserByUsername(String username)
    {
        return repository.findUserByUsername(username);
    }
    public UsersPersonalData fetchUserByPesel(String pesel)
    {
        return repository.findUserByPesel(pesel);
    }
}
