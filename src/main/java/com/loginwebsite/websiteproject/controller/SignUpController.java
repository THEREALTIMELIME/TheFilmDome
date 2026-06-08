package com.loginwebsite.websiteproject.controller;

import com.filmdome.movies.repository.MoviesRepository;
import com.loginwebsite.websiteproject.repository.AccountRepository;
import com.loginwebsite.websiteproject.entity.User;
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
    
    @Autowired
    private MoviesRepository moviesRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    Date end = new Date();
    Date start = Date.from(Instant.now().minus(14, ChronoUnit.DAYS));

    public SignUpController(MoviesRepository moviesRepository, AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.moviesRepository = moviesRepository;
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
            model.addAttribute("trendingMovies", moviesRepository.findByPopularityGreaterThanOrderByPopularityDesc(50.0));
            model.addAttribute("newestMovies", moviesRepository.findByReleaseDateBetweenOrderByReleaseDateDesc(start, end));

            return "home-page";
        }
    }
}
