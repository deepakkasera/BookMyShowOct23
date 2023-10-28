package com.scaler.bookmyshowoct23.controllers;

import com.scaler.bookmyshowoct23.dtos.SignUpRequestDto;
import com.scaler.bookmyshowoct23.dtos.SignUpResponseDto;
import com.scaler.bookmyshowoct23.models.ResponseStatus;
import com.scaler.bookmyshowoct23.models.User;
import com.scaler.bookmyshowoct23.repositories.UserRepository;
import com.scaler.bookmyshowoct23.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.UnknownServiceException;
import java.util.Optional;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto) {
        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
        try {
            User user = userService.signUp(signUpRequestDto.getEmail(),
                    signUpRequestDto.getPassword());
            signUpResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            signUpResponseDto.setUserId(user.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return signUpResponseDto;
    }
}
