package com.homeland.homeland.controller;

import com.homeland.homeland.dto.MessageRequest;
import com.homeland.homeland.service.MessageService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public String sendMessage(HttpServletRequest servletRequest, Model model, @ModelAttribute("message")MessageRequest request) {
        messageService.save(request);

        String referer = servletRequest.getHeader("Referer");
        return "redirect:" + referer;
    }
}
