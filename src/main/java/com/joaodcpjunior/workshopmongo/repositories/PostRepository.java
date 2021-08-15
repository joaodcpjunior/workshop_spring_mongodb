package com.joaodcpjunior.workshopmongo.repositories;

import java.util.List;

import com.joaodcpjunior.workshopmongo.entities.Post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
    
    List<Post> findByTitleContainingIgnoreCase(String text);
}
