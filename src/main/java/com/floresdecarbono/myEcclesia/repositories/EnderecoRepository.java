package com.floresdecarbono.myEcclesia.repositories;

import com.floresdecarbono.myEcclesia.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {
}
