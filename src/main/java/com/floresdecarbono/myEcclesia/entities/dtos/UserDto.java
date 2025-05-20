package com.floresdecarbono.myEcclesia.entities.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserDto(@NotBlank String username, @NotBlank String cpf, @NotBlank String email, @NotBlank String password) {}
