package com.floresdecarbono.myEcclesia.entities.dtos;

import jakarta.validation.constraints.NotBlank;

public record EnderecoDto(@NotBlank String cidade, @NotBlank String bairro, @NotBlank String rua, @NotBlank String numero, String referencia) {
}
