package com.scaler.bookmyshowoct23.controllers;

import com.scaler.bookmyshowoct23.dtos.BookMovieRequestDto;
import com.scaler.bookmyshowoct23.dtos.BookMovieResponseDto;
import com.scaler.bookmyshowoct23.models.Booking;
import com.scaler.bookmyshowoct23.models.User;
import com.scaler.bookmyshowoct23.repositories.UserRepository;
import com.scaler.bookmyshowoct23.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;
    @Autowired
    BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    BookMovieResponseDto bookMovie(BookMovieRequestDto requestDto) {
        return null;
    }
}
