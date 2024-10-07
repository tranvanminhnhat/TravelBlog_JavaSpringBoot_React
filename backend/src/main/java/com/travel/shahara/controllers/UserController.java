package com.travel.shahara.controllers;

import com.travel.shahara.models.formDto.UserRegistrationForm;
import com.travel.shahara.models.responseDto.UserResponseDto;
import com.travel.shahara.models.serviceInputDto.UserServiceInputDto;
import com.travel.shahara.models.serviceOutputDto.UserServiceOutputDto;
import com.travel.shahara.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserResponseDto registerUser(@RequestBody UserRegistrationForm user){

        UserServiceInputDto inputDto = UserServiceInputDto.builder().id(user.getId()).username(user.getUsername()).password(user.getPassword()).password(user.getPassword()).build();
        UserServiceOutputDto outputDto = userService.registerUser(inputDto);

        UserResponseDto  responseDto = UserResponseDto.builder().username(outputDto.getUsername()).build();

        return responseDto;
    }
}
