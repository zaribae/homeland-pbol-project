package com.homeland.homeland.controller;

import com.homeland.homeland.dto.MessageRequest;
import com.homeland.homeland.service.MessageService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/messages")
    public String sendMessage(HttpServletRequest servletRequest, Model model, @ModelAttribute("message")MessageRequest request) {
        messageService.save(request);
        model.addAttribute("success", true);
        String referer = servletRequest.getHeader("Referer");
        return "redirect:" + referer;
    }
}
