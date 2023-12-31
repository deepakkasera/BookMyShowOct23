package com.scaler.bookmyshowoct23.models;

import jakarta.annotation.security.DenyAll;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel {
    @ManyToOne
    private Show show;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
    private int price;
}


/*
 1               1
ShowSeatType - Show
    M           1

123 | GOLD
123 | PLATINUM
123 | DIAMOND
101 | GOLD
101 | PLATINUM
100 | GOLD


 */
