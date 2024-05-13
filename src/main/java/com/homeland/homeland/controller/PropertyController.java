package com.homeland.homeland.controller;

import com.homeland.homeland.dto.MessageRequest;
import com.homeland.homeland.model.User;
import com.homeland.homeland.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;

    @GetMapping("/")
    public String listProperties(@AuthenticationPrincipal User user, Model model) {
        if (user != null) {
            model.addAttribute("user", user);
        }
        model.addAttribute("properties", propertyService.findAllProperties());
        model.addAttribute("topProperties", propertyService.findLatestProperties());
        return "index";
    }

    @GetMapping("/properties/{id}")
    public String showProperty(@AuthenticationPrincipal User user, Model model, @PathVariable Long id) {
        if (user != null) model.addAttribute("user", user);
        model.addAttribute("property", propertyService.findPropertyById(id));
        model.addAttribute("topProperties", propertyService.findLatestProperties());
        model.addAttribute("message", new MessageRequest());
        return "property-details";
    }

}
