package com.travel.shahara.models.formDto;

import com.travel.shahara.validators.users.Username;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserRegistrationForm {
    private Integer id;
    private String username;
    private String password;
}
