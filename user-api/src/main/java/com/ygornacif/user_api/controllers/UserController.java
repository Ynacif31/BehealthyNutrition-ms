package com.ygornacif.user_api.controllers;

import com.ygornacif.user_api.constants.ApiConstants;
import com.ygornacif.user_api.constants.UserConstants;
import com.ygornacif.user_api.dto.ResponseDto;
import com.ygornacif.user_api.dto.UserDto;
import com.ygornacif.user_api.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(ApiConstants.STATUS_201, UserConstants.MESSAGE_201));
    }
}
