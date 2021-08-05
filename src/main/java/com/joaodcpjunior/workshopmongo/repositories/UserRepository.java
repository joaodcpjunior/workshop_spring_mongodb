package com.joaodcpjunior.workshopmongo.repositories;

import com.joaodcpjunior.workshopmongo.entities.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
    
}
