package com.example.twilio.service;

import com.example.twilio.dto.UserDTO;

public interface UserService {
    void sendMessage(UserDTO userDTO);
}
