package com.ygornacif.user_api.services.impl;

import com.ygornacif.user_api.dto.UserDto;
import com.ygornacif.user_api.entities.User;
import com.ygornacif.user_api.exceptions.UserAlreadyExistsException;
import com.ygornacif.user_api.mappers.UserMapper;
import com.ygornacif.user_api.repositories.RoleRepository;
import com.ygornacif.user_api.repositories.UserRepository;
import com.ygornacif.user_api.services.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void createUser(UserDto userDto) {
        validateUser(userDto);
        User user = UserMapper.toEntity(userDto);

        userDto.getRoles().forEach(roleDto -> {
            roleRepository.findById(roleDto.getId()).ifPresent(user::addRole);
        });
        userRepository.save(user);
    }

    private void validateUser(UserDto userDto) {
        Optional<User> user = userRepository.findByEmail(userDto.getEmail());
        if (user.isPresent()) {
            throw new UserAlreadyExistsException("User with email " + userDto.getEmail() + " already exists.");
        }
    }
}
