package com.floresdecarbono.myEcclesia.entities.dtos;


import java.util.Set;
import java.util.UUID;

public record UserDto(String username,
                      String cpf,
                      String email,
                      String password,
                      Integer cargo,
                      Set<UUID> liderandosIds,
                      Set<UUID> escalasIds) {

}
