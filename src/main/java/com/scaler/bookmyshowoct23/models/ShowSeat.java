package com.scaler.bookmyshowoct23.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel {
    @ManyToOne
    private Show show;

    @ManyToOne
    private Seat seat;

    private ShowSeatStatus showSeatStatus;
}


/*

   1      1
ShowSeat Show => M:1
  M        1

ShowSeat

123 | A1
123 | A2
321 | A1
345 | A1




 */