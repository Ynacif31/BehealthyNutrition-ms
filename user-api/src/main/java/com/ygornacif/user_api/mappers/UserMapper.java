package com.ygornacif.user_api.mappers;

import com.ygornacif.user_api.dto.RoleDto;
import com.ygornacif.user_api.dto.UserDto;
import com.ygornacif.user_api.entities.Role;
import com.ygornacif.user_api.entities.User;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserMapper {

    public static User MapToEntity(UserDto userDto, User user) {
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setPassword(userDto.getPassword());

        Set<Role> roles = new HashSet<>();
        for (RoleDto roleDto : userDto.getRoles()) {
            roles.add(RoleMapper.toEntity(roleDto));
        }
        user.setRoles(roles);

        return user;
    }

    public static UserDto MapToDto(User user, UserDto userDto) {
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setPassword(user.getPassword());

        Set<RoleDto> roles = new HashSet<>();
        for (Role role : user.getRoles()) {
            roles.add(RoleMapper.toDto(role));
        }
        userDto.setRoles(roles);

        return userDto;
    }
}
