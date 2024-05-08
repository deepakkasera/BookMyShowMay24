package com.scaler.bookmyshowmay24;

import com.scaler.bookmyshowmay24.controllers.UserController;
import com.scaler.bookmyshowmay24.dtos.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookMyShowMay24ApplicationTests {
    @Autowired
    private UserController userController;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSignUpFunctionality() {
        SignupRequestDto requestDto = new SignupRequestDto();
        requestDto.setName("Jegan");
        requestDto.setEmail("jegan@scaler.com");
        requestDto.setPassword("123456");

        SignupResponseDto responseDto = userController.signUp(
                requestDto
        );

        System.out.println(responseDto.getUserId());
    }

    @Test
    public void testLoginFunctionality() {
        LoginRequestDto requestDto = new LoginRequestDto();
        requestDto.setEmail("zahidul@scaler.com");
        requestDto.setPassword("abcD");

        LoginResponseDto responseDto = userController.login(requestDto);

        if (responseDto.getResponseStatus().equals(ResponseStatus.SUCCESS)) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Unsuccessful");
        }
    }
}
