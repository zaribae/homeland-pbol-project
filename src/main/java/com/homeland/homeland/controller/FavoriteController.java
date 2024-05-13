package com.homeland.homeland.controller;

import com.homeland.homeland.model.User;
import com.homeland.homeland.service.FavoriteService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/favorites")
@RequiredArgsConstructor
public class FavoriteController {

    private final FavoriteService favoriteService;

    @PostMapping("/{propertyId}")
    public String addFavorite(
            HttpServletRequest request,
            @AuthenticationPrincipal User user,
            @PathVariable Long propertyId
    ) {
        if (user == null) return "redirect:/login";

        favoriteService.addFavorite(user.getId(), propertyId);

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }
}
