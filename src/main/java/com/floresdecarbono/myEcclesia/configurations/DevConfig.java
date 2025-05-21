package com.floresdecarbono.myEcclesia.configurations;

import com.floresdecarbono.myEcclesia.entities.Departamento;
import com.floresdecarbono.myEcclesia.entities.Endereco;
import com.floresdecarbono.myEcclesia.entities.User;
import com.floresdecarbono.myEcclesia.entities.enums.Cargo;
import com.floresdecarbono.myEcclesia.repositories.DepartamentoRepository;
import com.floresdecarbono.myEcclesia.repositories.EnderecoRepository;
import com.floresdecarbono.myEcclesia.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.UUID;

@Configuration
@Profile("dev")
public class DevConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

    }
}
