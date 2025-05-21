package com.floresdecarbono.myEcclesia.services;

import com.floresdecarbono.myEcclesia.entities.Departamento;
import com.floresdecarbono.myEcclesia.entities.dtos.DepartamentoDto;
import com.floresdecarbono.myEcclesia.exceptions.ResourceNotFoundException;
import com.floresdecarbono.myEcclesia.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepartamentoService implements GenericService<Departamento, DepartamentoDto, UUID> {

    @Autowired
    private DepartamentoRepository repository;

    @Override
    public List<Departamento> findAll() {
        return repository.findAll();
    }

    @Override
    public Departamento findOne(UUID id) {
        var obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public Departamento insert(DepartamentoDto model) {
        var obj = new Departamento();
        updateData(model, obj);
        return repository.save(obj);
    }

    @Override
    public Departamento update(UUID id, DepartamentoDto model) {
        var obj = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        updateData(model, obj);
        return repository.save(obj);
    }

    @Override
    public void delete(UUID id) {
        if (!repository.existsById(id)) throw new ResourceNotFoundException(id);
        repository.deleteById(id);
    }

    @Override
    public void updateData(DepartamentoDto source, Departamento destination) {
        destination.setNome(source.nome());
        destination.setLider(source.lider());
    }

}
