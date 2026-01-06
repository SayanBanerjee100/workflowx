package com.workflowx.backend.service;

import com.workflowx.backend.dto.LoginRequestDTO;

public interface AuthService {
    String login(LoginRequestDTO request);
}
