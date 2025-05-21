package com.floresdecarbono.myEcclesia.controllers;

import com.floresdecarbono.myEcclesia.entities.Endereco;
import com.floresdecarbono.myEcclesia.entities.dtos.EnderecoDto;
import com.floresdecarbono.myEcclesia.services.EnderecoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    ResponseEntity<Endereco> insert(@RequestBody @Valid EnderecoDto model) {
        var obj = service.insert(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<Endereco> update(@PathVariable UUID id, @Valid EnderecoDto model) {
        var obj = service.update(id, model);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
