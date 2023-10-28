package com.scaler.bookmyshowoct23.repositories;

import com.scaler.bookmyshowoct23.models.Show;
import com.scaler.bookmyshowoct23.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    List<ShowSeat> findAllById(List<Long> showSeatIds);

    @Override
    ShowSeat save(ShowSeat showSeat);
    /*
    Insert -> If showSeat object is not present in the DB.
           -> If input showSeat object doesn't contain the id.

    Update -> updating the existing object in the DB.

    //save method returns an updated object.
     */


}
