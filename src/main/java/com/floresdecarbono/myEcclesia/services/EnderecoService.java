package com.floresdecarbono.myEcclesia.services;

import com.floresdecarbono.myEcclesia.entities.Endereco;
import com.floresdecarbono.myEcclesia.entities.dtos.EnderecoDto;
import com.floresdecarbono.myEcclesia.exceptions.ResourceNotFoundException;
import com.floresdecarbono.myEcclesia.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EnderecoService implements GenericService<Endereco, EnderecoDto, UUID> {

    private final EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Endereco> findAll() {
        return repository.findAll();
    }

    @Override
    public Endereco findOne(UUID id) {
        var obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public Endereco insert(EnderecoDto model) {
        var obj = new Endereco();
        updateData(model, obj);
        return repository.save(obj);
    }

    @Override
    public Endereco update(UUID id, EnderecoDto model) {
        var obj = new Endereco();
        updateData(model, obj);
        return obj;
    }

    @Override
    public void delete(UUID id) {
        if (!repository.existsById(id)) throw new ResourceNotFoundException(id);
        repository.deleteById(id);
    }

    @Override
    public void updateData(EnderecoDto source, Endereco destination) {
        destination.setCidade(source.cidade());
        destination.setBairro(source.bairro());
        destination.setRua(source.rua());
        destination.setNumero(source.numero());
        destination.setReferencia(source.referencia());
    }

}
