package com.loginwebsite.websiteproject.controller;

import com.filmdome.movies.repository.MoviesRepository;
import com.loginwebsite.websiteproject.repository.AccountRepository;
import com.loginwebsite.websiteproject.model.PasswordView;
import com.loginwebsite.websiteproject.entity.User;
import com.loginwebsite.websiteproject.model.UserView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

@Controller
public class UserBioController {

    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/processUserBio")
    public String processUserBio(@RequestParam int id, Model model) {

        User fetchedUser = accountRepository.findById(id);

        model.addAttribute("userView", convertTo(fetchedUser));
        model.addAttribute("passwordView", new PasswordView());

        return "user-update";
    }

    @PostMapping("/processUser")
    public String processUser(@Valid @ModelAttribute("userView") UserView userView, BindingResult bindingResult, Model model,
                              @RequestParam(required = false) String updateButton,
                              @RequestParam(required = false) String deleteButton) {

        model.addAttribute("passwordView", new PasswordView());

        if (bindingResult.hasErrors()) {
            return "user-update";
        }

        if (updateButton != null) {

            User existingUser = accountRepository.findById(userView.getId());

            if (userView.getEmail() != existingUser.getEmail()) {
                User emailUser = accountRepository.findByEmail(userView.getEmail());
                if (emailUser != null && emailUser.getId() != existingUser.getId()) {
                    model.addAttribute("userInputErrors", "Email already exists.");
                    return "user-update";
                }
            }

            if (userView.getUsername() != existingUser.getUsername()) {
                User usernameUser = accountRepository.findByUsername(userView.getUsername());
                if (usernameUser != null && usernameUser.getId() != existingUser.getId()) {
                    model.addAttribute("userInputErrors", "Username already exists.");
                    return "user-update";
                }
            }
            if (userView.getPhoneNumber() != existingUser.getPhoneNumber()){
                User phoneUser = accountRepository.findByPhoneNumber(userView.getPhoneNumber());
                if (phoneUser != null && phoneUser.getId() != existingUser.getId()) {
                    model.addAttribute("userInputErrors", "Phone number already exists.");
                    return "user-update";
                }
            }

            existingUser.setFirstName(userView.getFirstName());
            existingUser.setLastName(userView.getLastName());
            existingUser.setEmail(userView.getEmail());
            existingUser.setUsername(userView.getUsername());
            existingUser.setPhoneNumber(userView.getPhoneNumber());

            accountRepository.save(existingUser);

            model.addAttribute("updateAccountSuccess", true);
            model.addAttribute("updateAccountMsg", "Your account has been updated!");
            return "user-update";
        }

        if (deleteButton != null) {
            accountRepository.deleteById(userView.getId());
            return "user-login";
        }
        return "user-update";
    }

    @PostMapping("/updatePassword")
    public String updatePassword(@Valid @ModelAttribute PasswordView passwordView,
                                 BindingResult result,
                                 Model model) {

        User user = accountRepository.findById(passwordView.getId());

        model.addAttribute("userView", convertTo(user));

        if (result.hasErrors()) {
            return "user-update";
        }

        if (!passwordEncoder.matches(passwordView.getCurrentPassword(), user.getPassword())) {
            model.addAttribute("passwordError", "Current password is incorrect");
            return "user-update";
        } else if (!passwordView.getNewPassword().equals(passwordView.getConfirmPassword())) {
            model.addAttribute("passwordError", "New passwords do not match");
            return "user-update";
        } else {

            user.setPassword(passwordEncoder.encode(passwordView.getNewPassword()));
            accountRepository.save(user);

            model.addAttribute("updatePasswordSuccess", true);
            model.addAttribute("updatePasswordMsg", "Your password has been updated!");

            return "user-update";
        }
    }

    private UserView convertTo(User fetchedUser) {

        UserView userView = new UserView();
        userView.setEmail(fetchedUser.getEmail());
        userView.setId(fetchedUser.getId());
        userView.setUsername(fetchedUser.getUsername());
        userView.setLastName(fetchedUser.getLastName());
        userView.setFirstName(fetchedUser.getFirstName());
        userView.setPhoneNumber(fetchedUser.getPhoneNumber());

        return userView;
    }
}