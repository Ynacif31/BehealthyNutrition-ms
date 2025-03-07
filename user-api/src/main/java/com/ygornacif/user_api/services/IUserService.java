package com.ygornacif.user_api.services;

import com.ygornacif.user_api.dto.UserDto;

public interface IUserService {

    void createUser(UserDto userDto);

    UserDto fetchUserByEmail(String email);

    boolean updateUser(UserDto userDto);

    boolean deleteUser(String email);
}
