package com.scaler.bookmyshowmay24.controllers;

import com.scaler.bookmyshowmay24.dtos.CreateBookingRequestDto;
import com.scaler.bookmyshowmay24.dtos.CreateBookingResponseDto;
import com.scaler.bookmyshowmay24.dtos.ResponseStatus;
import com.scaler.bookmyshowmay24.exceptions.ShowNotFoundException;
import com.scaler.bookmyshowmay24.exceptions.UserNotFoundException;
import com.scaler.bookmyshowmay24.models.Booking;
import com.scaler.bookmyshowmay24.services.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public CreateBookingResponseDto createBooking(CreateBookingRequestDto requestDto) {
        CreateBookingResponseDto responseDto = new CreateBookingResponseDto();

        try {
            Booking booking = bookingService.createBooking(requestDto.getUserId(),
                    requestDto.getShowSeatIds(),
                    requestDto.getShowId());

            responseDto.setBookingId(booking.getId());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return responseDto;
    }
}
