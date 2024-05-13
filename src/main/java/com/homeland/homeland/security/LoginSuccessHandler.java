package com.homeland.homeland.security;

import com.homeland.homeland.model.Role;
import com.homeland.homeland.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws ServletException, IOException {

        User user = (User) authentication.getPrincipal();
        String redirectUrl = request.getContextPath();

        if (user.hasRole(Role.ADMIN))
            redirectUrl = "/admin";
        else if (user.hasRole(Role.USER))
            redirectUrl = "/";

        response.sendRedirect(redirectUrl);
    }
}
