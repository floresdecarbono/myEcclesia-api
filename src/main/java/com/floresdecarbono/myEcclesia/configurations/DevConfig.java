package com.floresdecarbono.myEcclesia.configurations;

import com.floresdecarbono.myEcclesia.repositories.DepartamentoRepository;
import com.floresdecarbono.myEcclesia.repositories.EnderecoRepository;
import com.floresdecarbono.myEcclesia.repositories.EventoRepository;
import com.floresdecarbono.myEcclesia.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

    }
}
