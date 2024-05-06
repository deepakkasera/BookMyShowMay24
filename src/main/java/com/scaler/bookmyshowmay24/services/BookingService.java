package com.scaler.bookmyshowmay24.services;

import com.scaler.bookmyshowmay24.exceptions.ShowNotFoundException;
import com.scaler.bookmyshowmay24.exceptions.UserNotFoundException;
import com.scaler.bookmyshowmay24.models.Booking;
import com.scaler.bookmyshowmay24.models.Show;
import com.scaler.bookmyshowmay24.models.User;
import com.scaler.bookmyshowmay24.repositories.ShowRepository;
import com.scaler.bookmyshowmay24.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowRepository showRepository;

    public BookingService(UserRepository userRepository,
                          ShowRepository showRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
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

        //2. Get the show with the given showId.
        Optional<Show> optionalShow = showRepository.findById(showId);

        if (optionalShow.isEmpty()) {
            throw new ShowNotFoundException("Show with id: " + showId + " not found");
        }




        return null;
    }
}
