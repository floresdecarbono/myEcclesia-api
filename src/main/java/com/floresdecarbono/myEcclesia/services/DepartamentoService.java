package com.floresdecarbono.myEcclesia.services;

import com.floresdecarbono.myEcclesia.entities.Departamento;
import com.floresdecarbono.myEcclesia.exceptions.ResourceNotFoundException;
import com.floresdecarbono.myEcclesia.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository repository;

    public List<Departamento> findAll() {
        return repository.findAll();
    }

    public Departamento findOne(UUID id) {
        var obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

}
