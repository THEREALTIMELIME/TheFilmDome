package com.loginwebsite.websiteproject.controller;

import com.filmdome.movies.repository.MoviesRepository;
import com.loginwebsite.websiteproject.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SessionLoginController {

    MoviesRepository moviesRepository;

    @GetMapping("/login")
    public String login(@RequestParam(value = "expired", required = false) String expired, Model model) {

        Login userLogin = new Login();
        model.addAttribute("userLogin", moviesRepository.searchEverything(String.valueOf(userLogin)));

        return "user-login";
    }
}
