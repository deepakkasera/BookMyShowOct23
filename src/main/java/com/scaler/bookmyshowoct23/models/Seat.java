package com.scaler.bookmyshowoct23.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private String num;
    private int rowVal;
    private int colVal;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
}
