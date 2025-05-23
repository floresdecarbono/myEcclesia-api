package com.floresdecarbono.myEcclesia.services;

import com.floresdecarbono.myEcclesia.entities.Departamento;
import com.floresdecarbono.myEcclesia.entities.dtos.DepartamentoDto;
import com.floresdecarbono.myEcclesia.exceptions.ResourceNotFoundException;
import com.floresdecarbono.myEcclesia.repositories.DepartamentoRepository;
import com.floresdecarbono.myEcclesia.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Service
public class DepartamentoService implements GenericService<Departamento, DepartamentoDto, UUID> {

    private final DepartamentoRepository departamentoRepository;

    private final UserRepository userRepository;

    public DepartamentoService(DepartamentoRepository departamentoRepository, UserRepository userRepository) {
        this.departamentoRepository = departamentoRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Departamento> findAll() {
        return departamentoRepository.findAll();
    }

    @Override
    public Departamento findOne(UUID id) {
        var obj = departamentoRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public Departamento insert(DepartamentoDto model) {
        var obj = new Departamento();
        updateData(model, obj);
        return departamentoRepository.save(obj);
    }

    @Override
    public Departamento update(UUID id, DepartamentoDto model) {
        var obj = departamentoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        updateData(model, obj);
        return departamentoRepository.save(obj);
    }

    @Override
    public void delete(UUID id) {
        if (!departamentoRepository.existsById(id)) throw new ResourceNotFoundException(id);
        departamentoRepository.deleteById(id);
    }

    @Override
    public void updateData(DepartamentoDto source, Departamento destination) {
        destination.setNome(source.nome());
        destination.setLider(userRepository.findById(source.liderId()).
                orElseThrow(() -> new ResourceNotFoundException(source.liderId())));
        destination.setMembros(new HashSet<>(
                userRepository.findAllById(source.membrosIds())));
    }

}
