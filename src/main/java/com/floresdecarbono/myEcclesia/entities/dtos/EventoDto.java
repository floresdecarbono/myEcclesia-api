package com.floresdecarbono.myEcclesia.entities.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public record EventoDto(String nome,
                        LocalDateTime dataInicio,
                        LocalDateTime dataFinal,
                        @NotNull UUID localId,
                        @NotNull Integer tipo,
                        @NotNull Set<UUID> escaladosIds) {
}
