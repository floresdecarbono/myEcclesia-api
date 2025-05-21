package com.floresdecarbono.myEcclesia.controllers;

import com.floresdecarbono.myEcclesia.entities.Departamento;
import com.floresdecarbono.myEcclesia.entities.dtos.DepartamentoDto;
import com.floresdecarbono.myEcclesia.services.DepartamentoService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService service;

    @GetMapping
    ResponseEntity<List<Departamento>> findAll() {
        var list = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<Departamento> findOne(@PathVariable @NotBlank UUID id) {
        var obj = service.findOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

    @PostMapping
    ResponseEntity<Departamento> insert(@RequestBody DepartamentoDto model) {
        var obj = service.insert(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<Departamento> update(@PathVariable UUID id, @RequestBody DepartamentoDto model) {
        var obj = service.update(id, model);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
