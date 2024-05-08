package com.scaler.bookmyshowmay24.repositories;

import com.scaler.bookmyshowmay24.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Override
    Booking save(Booking booking);
}
