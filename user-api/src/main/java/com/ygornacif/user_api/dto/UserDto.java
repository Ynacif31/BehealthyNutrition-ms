package com.ygornacif.user_api.dto;

import com.ygornacif.user_api.entities.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


import java.util.HashSet;
import java.util.Set;

@Data
public class UserDto {

    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private String name;

    @NotBlank(message = "Campo obrigatório")
    private String email;

    @NotBlank(message = "Campo obrigatório")
    private String phone;

    private Set<RoleDto> roles = new HashSet<>();
}
