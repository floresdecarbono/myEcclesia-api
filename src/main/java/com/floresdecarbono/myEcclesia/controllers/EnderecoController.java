package com.floresdecarbono.myEcclesia.controllers;

import com.floresdecarbono.myEcclesia.entities.Endereco;
import com.floresdecarbono.myEcclesia.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping
    ResponseEntity<List<Endereco>> findAll() {
        var list = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<Endereco> findOne(@PathVariable UUID id) {
        var obj = service.findOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

}
