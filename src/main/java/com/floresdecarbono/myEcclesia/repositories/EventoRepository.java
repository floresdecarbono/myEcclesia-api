package com.floresdecarbono.myEcclesia.repositories;

import com.floresdecarbono.myEcclesia.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventoRepository extends JpaRepository<Evento, UUID> {


}
