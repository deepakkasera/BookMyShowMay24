package com.scaler.bookmyshowmay24.controllers;

import com.scaler.bookmyshowmay24.dtos.CreateBookingRequestDto;
import com.scaler.bookmyshowmay24.dtos.CreateBookingResponseDto;
import com.scaler.bookmyshowmay24.services.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public CreateBookingResponseDto createBooking(CreateBookingRequestDto requestDto) {
        return null;
    }
}
