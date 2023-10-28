package com.scaler.bookmyshowoct23.repositories;

import com.scaler.bookmyshowoct23.models.Show;
import com.scaler.bookmyshowoct23.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {

    List<ShowSeatType> findAllByShow(Show show);
    //select * from show_seat_type where show_id = show.id;
}
