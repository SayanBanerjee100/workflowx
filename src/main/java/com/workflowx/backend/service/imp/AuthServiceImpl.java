package com.workflowx.backend.service.imp;

import com.workflowx.backend.dto.LoginRequestDTO;
import com.workflowx.backend.entity.User;
import com.workflowx.backend.repository.UserRepository;
import com.workflowx.backend.security.JwtUtil;
import com.workflowx.backend.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String login(LoginRequestDTO request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return JwtUtil.generateToken(user.getEmail());
    }
}
