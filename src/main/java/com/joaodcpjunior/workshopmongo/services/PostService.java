package com.joaodcpjunior.workshopmongo.services;

import java.util.List;

import com.joaodcpjunior.workshopmongo.entities.Post;
import com.joaodcpjunior.workshopmongo.repositories.PostRepository;
import com.joaodcpjunior.workshopmongo.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    
    @Autowired
    PostRepository repository;

    public Post findById(String id) {
        Post post = repository.findById(id).orElse(null);
        if (post == null) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return post;
    }

    public List<Post> findByTitle(String text) {
       return repository.findByTitleContainingIgnoreCase(text);
    }
}
