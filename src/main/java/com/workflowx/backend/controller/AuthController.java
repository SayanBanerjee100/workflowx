package com.workflowx.backend.controller;

import com.workflowx.backend.dto.LoginRequestDTO;
import com.workflowx.backend.dto.LoginResponseDTO;
import com.workflowx.backend.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @Valid @RequestBody LoginRequestDTO request) {

        String token = authService.login(request);
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
