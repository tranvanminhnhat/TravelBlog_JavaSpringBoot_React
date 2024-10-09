package com.travel.shahara.services.user;

import com.travel.shahara.entities.Users;
import com.travel.shahara.models.serviceInputDto.UserServiceInputDto;
import com.travel.shahara.models.serviceOutputDto.UserServiceOutputDto;
import com.travel.shahara.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    /**
     * Register new User
     * @param userServiceInputDto Input DTO of service
     * @return Username
     */
    public UserServiceOutputDto registerUser(UserServiceInputDto userServiceInputDto) {
        Users user = new Users();
        BeanUtils.copyProperties(userServiceInputDto, user);
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return UserServiceOutputDto.builder().username(user.getUsername()).build();
    }
}
