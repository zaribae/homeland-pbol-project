package com.homeland.homeland.controller;

import com.homeland.homeland.dto.PropertyDto;
import com.homeland.homeland.service.PropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PropertyController {
    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/properties")
    public String listProperties(Model model) {
        List<PropertyDto> properties = propertyService.findAllProperties();
        model.addAttribute("properties", properties);
        return "index";
    }

}
