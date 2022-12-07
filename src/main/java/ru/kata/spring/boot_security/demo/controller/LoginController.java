package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
public class LoginController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public LoginController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }
    @GetMapping("/login")
    String login() {
        return "login";


//    @GetMapping("/login")
//    public String showLoginPage(Authentication authentication,String email) {
//        User user = (User) authentication.getPrincipal();
//        userService.loadUserByUserEmail(email);
//        return "login";
    }
//    @GetMapping
//    public String getUser(Model model, Authentication authentication) {
//        User user = userService.loadUserByUserEmail(((User) authentication.getPrincipal()).getEmail());
//        model.addAttribute("user", user);
//        return "userAuth";
//    }
}
