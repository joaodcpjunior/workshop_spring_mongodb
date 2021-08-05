package com.joaodcpjunior.workshopmongo.services;

import java.util.List;

import com.joaodcpjunior.workshopmongo.entities.User;
import com.joaodcpjunior.workshopmongo.repositories.UserRepository;
import com.joaodcpjunior.workshopmongo.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id) {
        User user = repository.findById(id).orElse(null);
        if (user == null) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user;
    }
}
