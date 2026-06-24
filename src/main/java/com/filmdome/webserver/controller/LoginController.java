package com.filmdome.webserver.controller;

import com.filmdome.webserver.dto.UserDto;
import com.filmdome.webserver.repository.AccountRepository;
import com.filmdome.webserver.model.Login;

import com.filmdome.webserver.util.UserUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class LoginController {

    private final AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public LoginController(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showForm(@RequestParam(required = false) String expired, Model model) {

        model.addAttribute("userLogin", new Login());

        if (expired != null) {
            model.addAttribute("sessionExpired", true);
        }

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

        UserDto user = UserUtil.convertTo(accountRepository.findByUsername(input));


        if (user == null) {
            user = UserUtil.convertTo(accountRepository.findByEmail(input));
        }

        if (user == null) {
            user = UserUtil.convertTo(accountRepository.findByPhoneNumber(input));
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

        return "redirect:/homePage1";
    }
}
