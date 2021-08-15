package com.joaodcpjunior.workshopmongo.repositories;

import com.joaodcpjunior.workshopmongo.entities.Post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
    
}
