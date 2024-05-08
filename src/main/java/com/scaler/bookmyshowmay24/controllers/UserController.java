package com.scaler.bookmyshowmay24.controllers;

import com.scaler.bookmyshowmay24.dtos.*;
import com.scaler.bookmyshowmay24.exceptions.UserNotFoundException;
import com.scaler.bookmyshowmay24.models.User;
import com.scaler.bookmyshowmay24.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignupResponseDto signUp(SignupRequestDto requestDto) {
        //TODO : Handle Exception (if any)
        User user = userService.signup(requestDto.getName(),
                requestDto.getEmail(),
                requestDto.getPassword());

        SignupResponseDto responseDto = new SignupResponseDto();
        responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        responseDto.setUserId(user.getId());
        return responseDto;
    }

    public LoginResponseDto login(LoginRequestDto requestDto) {
        LoginResponseDto responseDto = new LoginResponseDto();
        try {
            User user = userService.login(requestDto.getEmail(),
                    requestDto.getPassword());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
