package com.floresdecarbono.myEcclesia.entities.dtos;

import com.floresdecarbono.myEcclesia.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record DepartamentoDto(@NotBlank String nome, @NotNull User lider) {
}
