package com.floresdecarbono.myEcclesia.services;

import com.floresdecarbono.myEcclesia.entities.Departamento;
import com.floresdecarbono.myEcclesia.entities.User;
import com.floresdecarbono.myEcclesia.entities.dtos.UserDto;
import com.floresdecarbono.myEcclesia.entities.enums.Cargo;
import com.floresdecarbono.myEcclesia.exceptions.ResourceNotFoundException;
import com.floresdecarbono.myEcclesia.repositories.DepartamentoRepository;
import com.floresdecarbono.myEcclesia.repositories.EventoRepository;
import com.floresdecarbono.myEcclesia.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService implements GenericService<User, UserDto, UUID> {

    private final UserRepository userRepository;

    private final DepartamentoRepository departamentoRepository;

    private final EventoRepository eventoRepository;

    public UserService(UserRepository userRepository, DepartamentoRepository departamentoRepository, EventoRepository eventoRepository) {
        this.userRepository = userRepository;
        this.departamentoRepository = departamentoRepository;
        this.eventoRepository = eventoRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(UUID id) {
        var user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public User insert(UserDto model) {
        var user = new User();
        user.setUsername(model.username());
        user.setCpf(model.cpf());
        user.setEmail(model.email());
        user.setPassword(model.cpf());
        user.setCargo(Cargo.valueOf(model.cargo()));

        return userRepository.save(user);
    }

    @Override
    public User update(UUID id, UserDto model) {
        var user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        updateData(model, user);
        return userRepository.save(user);
    }

    @Override
    public void delete(UUID id) {
        if (!userRepository.existsById(id)) throw new ResourceNotFoundException(id);
        userRepository.deleteById(id);
    }

    @Override
    public void updateData(UserDto source, User destination) {
        destination.setUsername(source.username());
        destination.setCpf(source.cpf());
        destination.setEmail(source.email());
        destination.setPassword(source.password());
        destination.setCargo(Cargo.valueOf(source.cargo()));

        destination.setLiderandos(new HashSet<>(
                departamentoRepository.findAllById(source.liderandosIds())));
        destination.setEscalas(new HashSet<>(
                eventoRepository.findAllById(source.escalasIds())));
    }
}
