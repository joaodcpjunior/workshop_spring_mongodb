package com.joaodcpjunior.workshopmongo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.joaodcpjunior.workshopmongo.dtos.UserDto;
import com.joaodcpjunior.workshopmongo.entities.User;
import com.joaodcpjunior.workshopmongo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {
    
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(){
        List<User> list = service.findAll();
        List<UserDto> listDto = list.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
}
