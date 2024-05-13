package com.homeland.homeland.service.implement;

import com.homeland.homeland.dto.RegisterRequest;
import com.homeland.homeland.model.Role;
import com.homeland.homeland.model.User;
import com.homeland.homeland.repository.UserRepository;
import com.homeland.homeland.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User ID not found"));
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found wit username: " + username));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void saveAll(List<User> users) {
        userRepository.saveAll(users);
    }

    @Override
    public User register(RegisterRequest registerRequest) {

        if (userRepository.findByUsername(registerRequest.getUsername()).isPresent())
            throw new IllegalArgumentException("Username already exists");

        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent())
            throw new IllegalArgumentException("Email already exists");

        User user = User.builder()
                .username(registerRequest.getUsername())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();

        return save(user);
    }
}
