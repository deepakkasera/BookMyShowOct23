package com.scaler.bookmyshowoct23.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
//Ticket
public class Booking extends BaseModel {
    @ManyToOne
    private User user;

    @ManyToOne
    private Show show;

    @OneToMany
    private List<ShowSeat> showSeats;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

    private int amount;

    @OneToMany
    private List<Payment> payments;
}

/*
  1      1
Booking User => M:1
` M      1

   1      M
Booking ShowSeat => 1:M
   1      1
=> One Booking can have many show seats.
=> One Show Seat can be booked in one Booking.

   1     M
Booking Payment => 1:M
   1       1
 */