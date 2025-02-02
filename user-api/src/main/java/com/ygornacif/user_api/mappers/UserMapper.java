package com.ygornacif.user_api.mappers;

import com.ygornacif.user_api.dto.RoleDto;
import com.ygornacif.user_api.dto.UserDto;
import com.ygornacif.user_api.entities.Role;
import com.ygornacif.user_api.entities.User;

import java.util.HashSet;
import java.util.Set;

public class UserMapper {

    public static User toEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());

        Set<Role> roles = new HashSet<>();
        for (RoleDto roleDto : userDto.getRoles()) {
            roles.add(RoleMapper.toEntity(roleDto));
        }
        user.setRoles(roles);

        return user;
    }
}
