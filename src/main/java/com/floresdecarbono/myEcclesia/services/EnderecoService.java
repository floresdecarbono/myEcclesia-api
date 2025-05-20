package com.floresdecarbono.myEcclesia.services;

import com.floresdecarbono.myEcclesia.entities.Endereco;
import com.floresdecarbono.myEcclesia.entities.dtos.EnderecoDto;
import com.floresdecarbono.myEcclesia.exceptions.ResourceNotFoundException;
import com.floresdecarbono.myEcclesia.repositories.EnderecoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public List<Endereco> findAll() {
        return repository.findAll();
    }

    public Endereco findOne(UUID id) {
        var task = repository.findById(id);
        return task.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Endereco insert(@Valid EnderecoDto model) {
        var endereco = new Endereco();
        updateData(model, endereco);
        return endereco;
    }

    private void updateData(EnderecoDto source, Endereco destination) {
        destination.setCidade(source.cidade());
        destination.setBairro(source.bairro());
        destination.setRua(source.rua());
        destination.setNumero(source.numero());
    }

}
