package com.travel.shahara.models.formDto;

import com.travel.shahara.validators.users.Password;
import com.travel.shahara.validators.users.Username;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserRegistrationForm {
    /**
     * User ID
     */
    private Integer id;

    /**
     * Username
     */
    @Username
    private String username;

    /**
     * Password
     */
    @Password
    private String password;
}
