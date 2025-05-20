package com.floresdecarbono.myEcclesia.controllers;

import com.floresdecarbono.myEcclesia.entities.User;
import com.floresdecarbono.myEcclesia.entities.dtos.UserDto;
import com.floresdecarbono.myEcclesia.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    ResponseEntity<List<User>> findAll() {
        var list = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<User> findOne(@PathVariable UUID id) {
        var user = service.findOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping
    ResponseEntity<User> insert(@RequestBody @Valid UserDto model) {
        var user = service.insert(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<User> update(@PathVariable UUID id, @RequestBody @Valid UserDto model ) {
        var user = service.update(id, model);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

}
