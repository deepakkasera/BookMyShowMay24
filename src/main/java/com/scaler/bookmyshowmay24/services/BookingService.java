package com.scaler.bookmyshowmay24.services;

import com.scaler.bookmyshowmay24.exceptions.ShowNotFoundException;
import com.scaler.bookmyshowmay24.exceptions.UserNotFoundException;
import com.scaler.bookmyshowmay24.models.*;
import com.scaler.bookmyshowmay24.repositories.BookingRepository;
import com.scaler.bookmyshowmay24.repositories.ShowRepository;
import com.scaler.bookmyshowmay24.repositories.ShowSeatRepository;
import com.scaler.bookmyshowmay24.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

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
    private BookingRepository bookingRepository;

    public BookingService(UserRepository userRepository,
                          ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository,
                          PriceCalculator priceCalculator,
                          BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculator = priceCalculator;
        this.bookingRepository = bookingRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(Long userId, List<Long> showSeatIds, Long showId) throws UserNotFoundException, ShowNotFoundException {
        /*
        1. Get the user with the given userId.
        2. Get the show with the given showId.
        3. Get the List of showSeats with the given id's.
        ----------TAKE A LOCK---------------
        4. Check if all the seats are available or not.
        5. If not, throw an exception.
        6. If yes, Mark the status of all the seats as BLOCKED.
        ----------RELEASE THE LOCK---------------
        7. Save the changes in the DB as well.
        8. Create the booking with pending status. [save booking obj to DB.]
        9. Return the booking object.
         */

        //1. Get the user with the given userId.
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User with id: " + userId + " not found");
        }
        User user = optionalUser.get();

        //2. Get the show with the given showId.
        Optional<Show> optionalShow = showRepository.findById(showId);

        if (optionalShow.isEmpty()) {
            throw new ShowNotFoundException("Show with id: " + showId + " not found");
        }
        Show show = optionalShow.get();

        //3. Get the List of showSeats with the given id's.
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        //4. Check if all the seats are available or not.
        //5. If not, throw an exception.
        for (ShowSeat showSeat : showSeats) {
            if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                throw new RuntimeException("Show Seat with id : " + showSeat.getId() + " isn't available.");
            }
        }

        //6. If yes, Mark the status of all the seats as BLOCKED.
        for (ShowSeat showSeat : showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            // 7. Save the changes in the DB as well.
            showSeatRepository.save(showSeat);
        }

        //8. Create the booking with pending status. [save booking obj to DB.]
        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setCreatedAt(new Date());
        booking.setUser(user);
        booking.setShow(show);
        booking.setPayments(new ArrayList<>());
        booking.setShowSeats(showSeats);
        booking.setAmount(priceCalculator.calculatePrice(show, showSeats));

        return bookingRepository.save(booking);
    }
}
