package com.homeland.homeland.controller;

import com.homeland.homeland.dto.PropertyRequest;
import com.homeland.homeland.service.MessageService;
import com.homeland.homeland.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final MessageService messageService;
    private final PropertyService propertyService;

    @GetMapping
    public String dashboardPage(Model model) {
        model.addAttribute("messages", messageService.findAll());
        return "admin";
    }

    @GetMapping("/new")
    public String newPropertyForm(Model model) {
        model.addAttribute("request", new PropertyRequest());
        return "new-property";
    }

    @PostMapping("/new")
    public String addProperty(@ModelAttribute("request") PropertyRequest request) {
        propertyService.addProperty(request);
        return "redirect:/admin/new";
    }
}
