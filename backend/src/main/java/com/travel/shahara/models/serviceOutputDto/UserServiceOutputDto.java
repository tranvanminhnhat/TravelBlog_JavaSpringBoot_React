package com.travel.shahara.models.serviceOutputDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserServiceOutputDto {
    /**
     * Username
     */
    private String username;
}
