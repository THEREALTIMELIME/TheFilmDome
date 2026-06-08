package com.loginwebsite.websiteproject.controller;

import com.filmdome.movies.repository.MoviesRepository;
import com.loginwebsite.websiteproject.repository.AccountRepository;
import com.loginwebsite.websiteproject.model.Login;
import com.loginwebsite.websiteproject.entity.User;
import com.loginwebsite.websiteproject.util.MovieUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Controller
public class LoginController {

    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    Date end = new Date();
    Date start = Date.from(Instant.now().minus(30, ChronoUnit.DAYS));


    public LoginController(MoviesRepository moviesRepository, AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.moviesRepository = moviesRepository;
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/loginPart1";
    }

    @GetMapping("/loginPart1")
    public String showForm(Model theModel) {
        theModel.addAttribute("userLogin", new Login());
        return "user-login";
    }

    @GetMapping("/sessionEndLogout")
    public String invalidateSession(HttpSession session, Model theModel) {
        if (session != null) {
            session.invalidate();
        }
        theModel.addAttribute("userLogin", new Login());
        return "user-login";
    }

    @PostMapping("/loginPart2")
    public String loginPassword(@ModelAttribute Login userLogin, Model theModel) {
        String input = userLogin.getLoginInput();
        User theUser = accountRepository.findByUsername(input);
        if (theUser == null) theUser = accountRepository.findByEmail(input);
        if (theUser == null) theUser = accountRepository.findByPhoneNumber(input);

        theModel.addAttribute("userLogin", userLogin);
        if (theUser != null) {
            return "user-password";
        } else {
            theModel.addAttribute("errorMessage", "Account not found.");
            return "user-login";
        }
    }

    @PostMapping("/loginUserAccount")
    public String loginUserAccount(@ModelAttribute Login userLogin,
                                   Model model,
                                   HttpSession session) {

        String input = userLogin.getLoginInput();
        String password = userLogin.getPassword();
        User user = accountRepository.findByUsername(input);
        if (user == null) user = accountRepository.findByEmail(input);
        if (user == null) user = accountRepository.findByPhoneNumber(input);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            session.setAttribute("user", user);

            model.addAttribute("trendingMovies", MovieUtil.convertTo(moviesRepository.findByPopularityGreaterThanOrderByPopularityDesc(50.0)));
            model.addAttribute("newestMovies", MovieUtil.convertTo(moviesRepository.findByReleaseDateBetweenOrderByReleaseDateDesc(start, end)));

            return "home-page";
        }


        model.addAttribute("userLogin", moviesRepository.searchEverything(String.valueOf(userLogin)));
        model.addAttribute("errorMessage", "Invalid password.");
        return "user-password";
    }
}
