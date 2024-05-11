package com.homeland.homeland.controller;

import com.homeland.homeland.dto.PropertyDto;
import com.homeland.homeland.dto.PropertyRequest;
import com.homeland.homeland.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;

    @GetMapping("/properties")
    public String listProperties(Model model) {
        List<PropertyDto> properties = propertyService.findAllProperties();
        model.addAttribute("properties", properties);
        return "index";
    }

    @GetMapping("/new")
    public String newProperty(Model model) {
        model.addAttribute("request", new PropertyRequest());
        return "add";
    }

    @PostMapping("/new")
    public String addProperty(@ModelAttribute("request") PropertyRequest request) {
        propertyService.addProperty(request);
        return "index";
    }

}
