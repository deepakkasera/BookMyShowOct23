package com.scaler.bookmyshowoct23.services;

import com.scaler.bookmyshowoct23.models.Booking;
import com.scaler.bookmyshowoct23.models.User;
import com.scaler.bookmyshowoct23.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    @Autowired
    BookingService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, Long showId, List<Long> showSeatIds) throws Exception {
        //Steps:-
        /*
        -----------TAKE DB LOCK-------------
        1. Get the user from userId.
        2. Get the show from showId.
        3. Get the showSeats from list of showSeatIds.
        4. Check if all the show Seats are available.
        ---------TAKE DB LOCK----------- (We'll not do this.)
        5. If yes, Mark the show seat status as BLOCKED.
        6. Save the updated status to DB.
        ----------RELEASE THE DB LOCK-------
        7. Create the Booking Object. (Go to the Payments page.)
        8. Return the Booking object.
        ----------RELEASE THE DB LOCK----------------
         */
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()) {
            throw new Exception("Invalid User");
        }


        return null;
    }
}
