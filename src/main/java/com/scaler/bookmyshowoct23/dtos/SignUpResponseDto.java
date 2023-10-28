package com.scaler.bookmyshowoct23.dtos;

import com.scaler.bookmyshowoct23.models.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDto {
    private ResponseStatus responseStatus;
    private Long userId;
}
