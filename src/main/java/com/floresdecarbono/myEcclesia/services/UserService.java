package com.floresdecarbono.myEcclesia.services;

import com.floresdecarbono.myEcclesia.entities.User;
import com.floresdecarbono.myEcclesia.entities.dtos.UserDto;
import com.floresdecarbono.myEcclesia.entities.enums.Cargo;
import com.floresdecarbono.myEcclesia.exceptions.ResourceNotFoundException;
import com.floresdecarbono.myEcclesia.repositories.UserRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findOne(UUID id) {
        var user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(@Valid UserDto model) {
        var user = new User();
        updateData(model, user);

        return repository.save(user);
    }

    public User update(UUID id, @Valid UserDto model) {
        var user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        updateData(model, user);
        return repository.save(user);
    }

    public void delete(UUID id) {
        if (!repository.existsById(id)) throw new ResourceNotFoundException(id);
        repository.deleteById(id);
    }

    private void updateData(@Valid UserDto source, @NotNull User destination) {
        destination.setUsername(source.username());
        destination.setCpf(source.cpf());
        destination.setEmail(source.email());
        destination.setPassword(source.password());
        destination.setCargo(Cargo.valueOf(source.cargo()));
    }

}
