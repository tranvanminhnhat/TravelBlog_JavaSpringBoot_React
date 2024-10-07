package com.travel.shahara.models.serviceInputDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserServiceInputDto {
    private Integer id;
    private String username;
    private String password;
}
