package com.homeland.homeland.controller;

import com.homeland.homeland.dto.RegisterRequest;
import com.homeland.homeland.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new RegisterRequest());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") RegisterRequest request, Model model) {
        try {
            userService.register(request);
            return "redirect:/login";
        } catch (Exception exception) {
            model.addAttribute("error", exception.getMessage());
            return "register";
        }
    }
}
