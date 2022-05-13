package com.example.twilio.controller;

import com.example.twilio.dto.UserDTO;
import com.example.twilio.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping("/writeInfo")
    public String writeInfo(Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("userDTO", userDTO);
        return "write-form";
    }

    @RequestMapping("/sendMessage")
    public String sendMessage(@ModelAttribute("userDTO") UserDTO userDTO) {
        userService.sendMessage(userDTO);
        return "after-send-message";
    }
}
