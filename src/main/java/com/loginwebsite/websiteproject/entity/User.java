package com.loginwebsite.websiteproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "account", schema = "movies")
public class User {
    @Id
    @Access(AccessType.FIELD)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "username")
    private String username;

    /**
     * ^: Matches the beginning of the string.
     * (?=.*[0-9]): Ensures at least one digit.
     * (?=.*[a-z]): Ensures at least one lowercase letter.
     * (?=.*[A-Z]): Ensures at least one uppercase letter.
     * (?=.*[!@#$%^&*()]): Ensures at least one special character.
     * (?=\\S+$): Ensures no whitespace.
     * .{8,20}: Ensures the length is between 8 and 20 characters.
     * $: Matches the end of the string.
     */
    @Size(min = 7, message = "Password must be more than 6 characters")
    @Pattern(regexp = ".*[A-Z].*", message = "Password must contain at least one uppercase letter")
    @Pattern(regexp = ".*\\d.*", message = "Password must contain at least one number")
    @Column(name = "password")
    private String password;

    @Pattern(regexp = "^\\d{10}$", message = "Phone Number length is incorrect.")
    @Column(name = "phone_number")
    private String phoneNumber;

}