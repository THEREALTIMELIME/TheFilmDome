package com.filmdome.webserver.model;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordView {

    private int id;

    @Size(min = 7, message = "Password must be at least 7 characters long")
    @Pattern(regexp = ".*[A-Z].*", message = "Password must contain at least one uppercase letter")
    @Pattern(regexp = ".*\\d.*", message = "Password must contain at least one number")
    private String newPassword;

    private String currentPassword;

    private String confirmPassword;

}