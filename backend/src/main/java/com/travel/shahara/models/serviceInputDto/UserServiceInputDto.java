package com.travel.shahara.models.serviceInputDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserServiceInputDto {
    /**
     * User ID
     */
    private Integer id;

    /**
     * Username
     */
    private String username;

    /**
     * Password
     */
    private String password;
}
