package com.floresdecarbono.myEcclesia.services;

import com.floresdecarbono.myEcclesia.entities.Evento;
import com.floresdecarbono.myEcclesia.entities.dtos.EventoDto;
import com.floresdecarbono.myEcclesia.entities.enums.TipoEvento;
import com.floresdecarbono.myEcclesia.exceptions.ResourceNotFoundException;
import com.floresdecarbono.myEcclesia.repositories.EnderecoRepository;
import com.floresdecarbono.myEcclesia.repositories.EventoRepository;
import com.floresdecarbono.myEcclesia.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EventoService implements GenericService<Evento, EventoDto, UUID> {

    private final EventoRepository eventoRepository;

    private final EnderecoRepository enderecoRepository;

    private final UserRepository userRepository;

    public EventoService(EventoRepository eventoRepository, EnderecoRepository enderecoRepository, UserRepository userRepository) {
        this.eventoRepository = eventoRepository;
        this.enderecoRepository = enderecoRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Evento> findAll() {
        return eventoRepository.findAll();
    }

    @Override
    public Evento findOne(UUID id) {
        var obj = eventoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return obj;
    }

    @Override
    public Evento insert(EventoDto model) {
        var obj = new Evento();
        updateData(model, obj);
        return eventoRepository.save(obj);
    }

    @Override
    public Evento update(UUID id, EventoDto model) {
        var obj = eventoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        updateData(model, obj);
        return eventoRepository.save(obj);
    }

    @Override
    public void delete(UUID id) {
        if (!eventoRepository.existsById(id)) throw new ResourceNotFoundException(id);
        eventoRepository.deleteById(id);
    }

    @Override
    public void updateData(EventoDto source, Evento destination) {
        destination.setNome(source.nome());
        destination.setDataInicio(source.dataInicio());
        destination.setDataFinal(source.dataFinal());
        destination.setLocal(enderecoRepository.findById(source.localId())
                .orElseThrow(() -> new ResourceNotFoundException(source.localId())));
        destination.setTipo(TipoEvento.valueOf(source.tipo()));
        destination.setEscalados(new HashSet<>(
                userRepository.findAllById(source.escaladosIds()
                        .stream().filter(id -> id != null)
                        .collect(Collectors.toSet()))));
    }
}
