package com.ygornacif.user_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


import java.util.HashSet;
import java.util.Set;

@Data
public class UserDto {

    private Long id;

    private String name;

    @NotBlank(message = "Campo obrigatório")
    private String email;

    @NotBlank(message = "Campo obrigatório")
    private String phone;

    private String password;

    private Set<RoleDto> roles = new HashSet<>();
}
