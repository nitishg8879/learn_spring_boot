package com.societyManagement.auth.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.societyManagement.auth.entity.UserEntity;
import com.societyManagement.auth.repo.UserRepository;

import lombok.AllArgsConstructor;
import com.society.common.service.JwtService;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public UserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    public String createUser(String username, String password, String email, String role) {
        UserEntity user = UserEntity.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .role(role)
                .build();
        userRepository.save(user);
        return "User created successfully";
    }

    public String login(String username, String password) {
        UserEntity user = loadUserByUsername(username);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }
        return jwtService.generateToken(user.getUsername(), user.getRole());
    }

}
