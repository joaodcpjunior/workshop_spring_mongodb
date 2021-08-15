package com.joaodcpjunior.workshopmongo.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.joaodcpjunior.workshopmongo.dtos.UserDto;
import com.joaodcpjunior.workshopmongo.entities.User;
import com.joaodcpjunior.workshopmongo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDto(obj));  
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDto objDto) {
        User obj = service.fromDto(objDto);
        service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();//passando a localizaçãom do novo recurso criado pelo cabeçalho da resposta, boa prática
		return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();  
    }

}
