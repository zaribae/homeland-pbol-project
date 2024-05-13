package com.homeland.homeland.controller;

import com.homeland.homeland.dto.MessageRequest;
import com.homeland.homeland.dto.PropertyDto;
import com.homeland.homeland.dto.PropertyRequest;
import com.homeland.homeland.service.ImageService;
import com.homeland.homeland.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;
    private final ImageService imageService;

    @GetMapping("/")
    public String listProperties(Model model) {
        model.addAttribute("properties", propertyService.findAllProperties());
        model.addAttribute("topProperties", propertyService.findLatestProperties());
        return "index";
    }

    @GetMapping("/properties/add")
    public String newProperty(Model model) {
        model.addAttribute("request", new PropertyRequest());
        return "new-property";
    }

    @PostMapping("/properties")
    public String addProperty(@ModelAttribute("request") PropertyRequest request) {
        propertyService.addProperty(request);
        return "redirect:/properties/add";
    }

    @GetMapping("/properties/{id}")
    public String showProperty(Model model, @PathVariable Long id) {
        model.addAttribute("property", propertyService.findPropertyById(id));
        model.addAttribute("topProperties", propertyService.findLatestProperties());
        model.addAttribute("message", new MessageRequest());
        return "property-details";
    }

}
