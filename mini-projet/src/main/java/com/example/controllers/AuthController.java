package com.example.controllers;

import com.example.models.Utilisateur;
import com.example.repositories.UtilisateurRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final UtilisateurRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UtilisateurRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new Utilisateur());
        return "register";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute Utilisateur user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (user.getRole() == null || (!user.getRole().equals("ROLE_ADMIN") && !user.getRole().equals("ROLE_PROF"))) {
            user.setRole("ROLE_USER");
        }

        userRepository.save(user);

        return "redirect:/login";
    }
}
