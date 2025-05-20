package com.floresdecarbono.myEcclesia.entities.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDto(@NotBlank String username, @NotBlank String cpf, @NotBlank String email, @NotBlank String password, @NotNull Integer cargo) {}
