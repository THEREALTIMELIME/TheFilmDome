package com.filmdome.webserver.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String username;

    @Size(min = 7, message = "Password must be more than 6 characters")
    @Pattern(regexp = ".*[A-Z].*", message = "Password must contain at least one uppercase letter")
    @Pattern(regexp = ".*\\d.*", message = "Password must contain at least one number")
    private String password;

    @Pattern(regexp = "^\\d{10}$", message = "Phone Number length is incorrect.")
    private String phoneNumber;
}