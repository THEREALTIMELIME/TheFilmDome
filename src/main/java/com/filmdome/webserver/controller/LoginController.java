package com.filmdome.webserver.controller;

import com.filmdome.movies.repository.MoviesRepository;
import com.filmdome.webserver.repository.AccountRepository;
import com.filmdome.webserver.model.Login;
import com.filmdome.webserver.entity.User;
import com.filmdome.webserver.util.MovieUtil;
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

    @PostMapping("/login")
    public String login(@ModelAttribute Login userLogin, Model model, HttpSession session) {

        String input = userLogin.getLoginInput();
        String password = userLogin.getPassword();

        User user = accountRepository.findByUsername(input);

        if (user == null) {
            user = accountRepository.findByEmail(input);
        }

        if (user == null) {
            user = accountRepository.findByPhoneNumber(input);
        }

        if (user == null) {
            model.addAttribute("userLogin", userLogin);
            model.addAttribute("errorMessage", "Your login credentials are incorrect.");
            return "user-login";
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            model.addAttribute("userLogin", userLogin);
            model.addAttribute("errorMessage", "Your login credentials are incorrect.");
            return "user-login";
        }

        session.setAttribute("user", user);

        model.addAttribute("trendingMovies", MovieUtil.convertTo(moviesRepository.findByPopularityGreaterThanOrderByPopularityDesc(50.0)));

        model.addAttribute("newestMovies", MovieUtil.convertTo(moviesRepository.findByReleaseDateBetweenOrderByReleaseDateDesc(start, end)));

        return "home-page";
    }
}
