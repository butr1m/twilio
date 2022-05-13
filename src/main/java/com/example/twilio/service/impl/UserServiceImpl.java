package com.example.twilio.service.impl;

import com.example.twilio.dto.UserDTO;
import com.example.twilio.entity.User;
import com.example.twilio.repository.UserRepository;
import com.example.twilio.service.UserService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Value("${twilio.account-cid}")
    private String ACCOUNT_SID;

    @Value("${twilio.auth-token}")
    private String AUTH_TOKEN;

    @Value("${twilio.phone-number}")
    private String TWILIO_PHONE_NUMBER;

    private final UserRepository userRepository;

    @Override
    public void sendMessage(UserDTO userDTO) {
        User user = userRepository.findByPhoneNumber(userDTO.getPhoneNumber());
        if (user != null) {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message.creator(new PhoneNumber(user.getPhoneNumber()), new PhoneNumber(TWILIO_PHONE_NUMBER), userDTO.getMessage()).create();
        } else {
            throw new EntityNotFoundException(String.format("User with phone number %s not found", userDTO.getPhoneNumber()));
        }
    }
}
