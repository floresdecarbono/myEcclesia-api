package com.floresdecarbono.myEcclesia.controllers;

import com.floresdecarbono.myEcclesia.entities.User;
import com.floresdecarbono.myEcclesia.entities.assemblers.UserModelAssembler;
import com.floresdecarbono.myEcclesia.entities.dtos.UserDto;
import com.floresdecarbono.myEcclesia.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService service;
    private final UserModelAssembler assembler;

    @Autowired
    public UserController(UserService service, UserModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<User>>> findAll() {
        var list = service.findAll();
        List<EntityModel<User>> resources = list.stream().map(assembler::toModel).toList();

        CollectionModel<EntityModel<User>> collection = CollectionModel.of(resources,
                linkTo(methodOn(UserController.class).findAll()).withSelfRel());

        return ResponseEntity.status(HttpStatus.OK).body(collection);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EntityModel<User>> findOne(@PathVariable UUID id) {
        var user = service.findOne(id);
        EntityModel<User> resource = assembler.toModel(user);

        return ResponseEntity.status(HttpStatus.OK).body(resource);
    }

    @PostMapping
    public ResponseEntity<EntityModel<User>> insert(@RequestBody @Valid UserDto model) {
        var user = service.insert(model);
        EntityModel<User> resource = assembler.toModel(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(resource);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EntityModel<User>> update(@PathVariable UUID id, @RequestBody @Valid UserDto model ) {
        var user = service.update(id, model);
        EntityModel<User> resource = assembler.toModel(user);

        return ResponseEntity.status(HttpStatus.OK).body(resource);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
