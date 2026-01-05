package com.workflowx.backend.service.imp;

import com.workflowx.backend.dto.UserRequestDTO;
import com.workflowx.backend.dto.UserResponseDTO;
import com.workflowx.backend.entity.User;
import com.workflowx.backend.repository.UserRepository;
import com.workflowx.backend.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO registerUser(UserRequestDTO requestDTO) {

        User user = new User();
        user.setName(requestDTO.getName());
        user.setEmail(requestDTO.getEmail());
        user.setPassword(requestDTO.getPassword()); // hashing later
        user.setRole(requestDTO.getRole());

        User savedUser = userRepository.save(user);

        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setUserId(savedUser.getUserId());
        responseDTO.setName(savedUser.getName());
        responseDTO.setEmail(savedUser.getEmail());
        responseDTO.setRole(savedUser.getRole());

        return responseDTO;
    }
}
