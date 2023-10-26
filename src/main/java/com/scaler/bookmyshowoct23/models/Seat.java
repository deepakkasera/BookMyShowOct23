package com.scaler.bookmyshowoct23.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private String number;
    private int rowVal;
    private int colVal;
    private SeatType seatType;
}
