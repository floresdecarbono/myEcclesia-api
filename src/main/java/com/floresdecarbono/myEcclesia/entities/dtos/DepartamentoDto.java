package com.floresdecarbono.myEcclesia.entities.dtos;

import java.util.Set;
import java.util.UUID;

public record DepartamentoDto(String nome, UUID liderId, Set<UUID> membrosIds) {
}
