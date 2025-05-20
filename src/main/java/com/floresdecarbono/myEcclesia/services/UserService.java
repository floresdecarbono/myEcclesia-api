package com.floresdecarbono.myEcclesia.services;

import com.floresdecarbono.myEcclesia.entities.User;
import com.floresdecarbono.myEcclesia.entities.dtos.UserDto;
import com.floresdecarbono.myEcclesia.repositories.UserRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User insert(@Valid UserDto model) {
        var user = new User();
        updateData(model, user);

        return repository.save(user);
    }

    private void updateData(@Valid UserDto source, @NotNull User destination) {
        destination.setUsername(source.username());
        destination.setCpf(source.cpf());
        destination.setEmail(source.email());
        destination.setPassword(source.password());
    }

}
