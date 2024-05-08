package com.scaler.bookmyshowmay24.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupResponseDto {
    private Long userId;
    private ResponseStatus responseStatus;
}
