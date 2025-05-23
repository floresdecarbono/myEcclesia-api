package com.floresdecarbono.myEcclesia.entities.dtos;

import jakarta.validation.constraints.NotBlank;

public record EnderecoDto(String cidade, String bairro, String rua, String numero, String referencia) {
}
