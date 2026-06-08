package com.loginwebsite.websiteproject.model;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserView {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;

    @Pattern(regexp = "^\\d{10}$", message = "Phone Number length is incorrect.")
    private String phoneNumber;

}
