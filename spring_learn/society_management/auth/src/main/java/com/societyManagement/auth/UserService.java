package com.societyManagement.auth;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    String createUser(String username, String password, String email, String role) {
        UserEntity user = UserEntity.builder()
                .username(username)
                .password(password)
                .email(email)
                .role(role)
                .build();
        userRepository.save(user);
        return "User created successfully";
    }

    String login(String username, String password) {
        
        return "Login successful";
    }

}
