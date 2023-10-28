package com.scaler.bookmyshowoct23.services;

import com.scaler.bookmyshowoct23.exceptions.InvalidUserException;
import com.scaler.bookmyshowoct23.exceptions.ShowSeatNotAvailableException;
import com.scaler.bookmyshowoct23.models.*;
import com.scaler.bookmyshowoct23.repositories.ShowRepository;
import com.scaler.bookmyshowoct23.repositories.ShowSeatRepository;
import com.scaler.bookmyshowoct23.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private PriceCalculator priceCalculator;
    @Autowired
    BookingService(UserRepository userRepository, ShowRepository showRepository,
                   ShowSeatRepository showSeatRepository, PriceCalculator priceCalculator) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculator = priceCalculator;
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

        //1. Get the user from userId.
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()) {
            throw new InvalidUserException("Invalid User");
        }
        User bookedBy = optionalUser.get();

        //2. Get the show from showId.
        Optional<Show> optionalShow = showRepository.findById(showId);

        if (optionalShow.isEmpty()) {
            throw new Exception("Invalid Show");
        }
        Show show = optionalShow.get();

        //3. Get the showSeats from list of showSeatIds.
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        //4. Check if all the show Seats are available.
        for (ShowSeat showSeat : showSeats) {
            if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                throw new ShowSeatNotAvailableException("ShowSeat not available");
            }
        }

        List<ShowSeat> savedShowSeats = new ArrayList<>();
        //5. If yes, Mark the show seat status as BLOCKED.
        //6. Save the updated status to DB.
        for (ShowSeat showSeat : showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }

        //7. Create the Booking Object.
        Booking booking = new Booking();
        booking.setUser(bookedBy);
        booking.setShow(show);
        booking.setCreatedAt(new Date());
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setPayments(new ArrayList<>());
        booking.setAmount(priceCalculator.calculatePrice(savedShowSeats, show));

        return booking;
    }
}
