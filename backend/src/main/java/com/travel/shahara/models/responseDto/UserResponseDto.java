package com.travel.shahara.models.responseDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponseDto {
    /**
     * Username
     */
    private String username;
}
