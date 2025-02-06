package com.ygornacif.user_api.services.impl;

import com.ygornacif.user_api.dto.UserDto;
import com.ygornacif.user_api.entities.Role;
import com.ygornacif.user_api.entities.User;
import com.ygornacif.user_api.exceptions.UserAlreadyExistsException;
import com.ygornacif.user_api.mappers.UserMapper;
import com.ygornacif.user_api.repositories.RoleRepository;
import com.ygornacif.user_api.repositories.UserRepository;
import com.ygornacif.user_api.services.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.RoleNotFoundException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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

        User user = UserMapper.MapToEntity(userDto, new User());
        Set<Role> roles = userDto.getRoles().stream()
                .map(roleDto -> {
                            try {
                                return roleRepository.findById(roleDto.getId()).orElseThrow(() -> new RoleNotFoundException("Role with id " + roleDto.getId() + " not found"));
                            } catch (RoleNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                        }
                )
                .collect(Collectors.toSet());

        user.setRoles(roles);
        userRepository.save(user);
    }

    private void validateUser(UserDto userDto) {
        Optional<User> user = userRepository.findByEmail(userDto.getEmail());
        if (user.isPresent()) {
            throw new UserAlreadyExistsException("User with email " + userDto.getEmail() + " already exists.");
        }
    }
}
