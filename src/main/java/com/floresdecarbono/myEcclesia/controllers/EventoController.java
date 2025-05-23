package com.floresdecarbono.myEcclesia.controllers;

import com.floresdecarbono.myEcclesia.entities.Evento;
import com.floresdecarbono.myEcclesia.entities.dtos.EventoDto;
import com.floresdecarbono.myEcclesia.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/eventos")
public class EventoController {

    @Autowired
    private EventoService service;

    @GetMapping
    ResponseEntity<List<Evento>> findAll() {
        var list = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<Evento> findOne(@PathVariable UUID id) {
        var obj = service.findOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

    @PostMapping
    ResponseEntity<Evento> insert(@RequestBody EventoDto model) {
        var obj = service.insert(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<Evento> update(@PathVariable UUID id, EventoDto model) {
        var obj = service.update(id, model);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
