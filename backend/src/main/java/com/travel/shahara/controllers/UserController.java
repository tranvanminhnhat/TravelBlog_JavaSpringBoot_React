package com.travel.shahara.controllers;

import com.travel.shahara.exceptions.ShaException;
import com.travel.shahara.models.formDto.UserRegistrationForm;
import com.travel.shahara.models.responseDto.UserResponseDto;
import com.travel.shahara.models.serviceInputDto.UserServiceInputDto;
import com.travel.shahara.models.serviceOutputDto.UserServiceOutputDto;
import com.travel.shahara.services.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Register new User
     * @param user Request body of API
     * @return Username
     */
    @PostMapping("/register")
    public UserResponseDto registerUser(@Validated @RequestBody UserRegistrationForm user) throws ShaException {

        UserServiceInputDto inputDto = UserServiceInputDto.builder().id(user.getId()).username(user.getUsername()).password(user.getPassword()).password(user.getPassword()).build();
        UserServiceOutputDto outputDto = userService.registerUser(inputDto);

        UserResponseDto  responseDto = UserResponseDto.builder().username(outputDto.getUsername()).build();

        return responseDto;
    }
}
