package com.scaler.bookmyshowoct23.controllers;

import com.scaler.bookmyshowoct23.dtos.BookMovieRequestDto;
import com.scaler.bookmyshowoct23.dtos.BookMovieResponseDto;
import com.scaler.bookmyshowoct23.models.Booking;
import com.scaler.bookmyshowoct23.models.BookingStatus;
import com.scaler.bookmyshowoct23.models.ResponseStatus;
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
        BookMovieResponseDto responseDto = new BookMovieResponseDto();

        try {
            Booking booking = bookingService.bookMovie(requestDto.getUserId(),
                    requestDto.getShowId(),
                    requestDto.getShowSeatIds());

            responseDto.setBookingId(booking.getId());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            throw new RuntimeException(e);
        }

        return responseDto;
    }
}
