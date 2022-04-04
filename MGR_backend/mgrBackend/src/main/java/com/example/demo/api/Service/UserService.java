package com.example.demo.api.Service;
import com.example.demo.api.Model.Users;
import com.example.demo.api.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@org.springframework.stereotype.Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<Users> findKonto() {
        return repository.findAll();
    }

    public Users addKonto(Users konto) {
        return repository.save(konto);
    }

    public void deleteKonto(Long id){
        repository.deleteById(id);
    }

    public Users updateKonto(Users konto){
        return repository.save(konto);
    }

    public List<Users> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Users findUserBy(String username,String password) {
        return repository.findByUsernameAndPassword(username,password);
    }

    public Users fetchUserByUsername(String username)
    {
        return repository.findUserByUsername(username);
    }
    public Users fetchUserByEmail(String email)
    {
        return repository.findUserByEmail(email);
    }

}