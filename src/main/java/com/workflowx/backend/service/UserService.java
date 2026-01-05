package com.workflowx.backend.service;

import com.workflowx.backend.dto.UserRequestDTO;
import com.workflowx.backend.dto.UserResponseDTO;

public interface UserService {

    UserResponseDTO registerUser(UserRequestDTO requestDTO);
}
