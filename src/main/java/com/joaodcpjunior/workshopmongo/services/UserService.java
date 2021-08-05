package com.joaodcpjunior.workshopmongo.services;

import java.util.List;

import com.joaodcpjunior.workshopmongo.entities.User;
import com.joaodcpjunior.workshopmongo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
}
