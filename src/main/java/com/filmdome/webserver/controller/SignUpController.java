package com.filmdome.webserver.controller;

import com.filmdome.movies.repository.MoviesRepository;
import com.filmdome.webserver.repository.AccountRepository;
import com.filmdome.webserver.entity.User;
import com.filmdome.webserver.util.MovieUtil;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Controller
public class SignUpController {
    
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SignUpController(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/checkCurrentPassword")
    @ResponseBody
    public boolean checkCurrentPassword(@RequestParam int id, @RequestParam String currentPassword) {

        User user = accountRepository.findById(id);
        return passwordEncoder.matches(currentPassword, user.getPassword());
    }

    @GetMapping("/showSignUpPage")
    public String showPage(Model theModel) {
        theModel.addAttribute("user", new User());

        return "user-sign-up";
    }

    @PostMapping("/processSignUpPage")
    public String processPage(@Valid @ModelAttribute User theUser, BindingResult result, Model model, HttpSession session) {

        boolean errorFound = false;

        if (result.hasErrors()) {
            model.addAttribute("user", theUser);
            errorFound = true;
        }

        if (theUser.getEmail() != null) {
            User emailUser = accountRepository.findByEmail(theUser.getEmail());
            if (emailUser != null) {
                model.addAttribute("emailErrorMessage", "Email already exists.");
                errorFound = true;
            }
        }

        if (theUser.getUsername() != null) {
            User usernameUser = accountRepository.findByUsername(theUser.getUsername());
            if (usernameUser != null) {
                model.addAttribute("usernameErrorMessage", "Username already exists.");
                errorFound = true;
            }
        }

        if (theUser.getPhoneNumber() != null){
            User phonenumberUser = accountRepository.findByPhoneNumber(theUser.getPhoneNumber());
            if (phonenumberUser != null) {
                model.addAttribute("phoneNumberErrorMessage", "Phone Number already exists.");
                errorFound = true;
            }
        }

        if (errorFound){
            return "user-sign-up";
        } else {

            theUser.setPassword(passwordEncoder.encode(theUser.getPassword()));
            accountRepository.save(theUser);

            session.setAttribute("user", theUser);

            return "redirect:/homePage1";
        }
    }
}
