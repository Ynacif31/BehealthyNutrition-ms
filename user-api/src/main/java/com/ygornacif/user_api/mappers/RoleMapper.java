package com.ygornacif.user_api.mappers;

import com.ygornacif.user_api.dto.RoleDto;
import com.ygornacif.user_api.entities.Role;

public class RoleMapper {

    public static Role toEntity(RoleDto roleDto) {
        Role role = new Role();
        role.setId(roleDto.getId());
        role.setAuthority(roleDto.getAuthority());
        return role;
    }

    public static RoleDto toDto(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setAuthority(role.getAuthority());
        return roleDto;
    }
}
