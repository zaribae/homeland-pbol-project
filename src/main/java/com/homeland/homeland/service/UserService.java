package com.homeland.homeland.service;

import com.homeland.homeland.dto.RegisterRequest;
import com.homeland.homeland.model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    User findByUsername(String username);

    User save(User user);

    void saveAll(List<User> users);

    User register (RegisterRequest registerRequest);
}
