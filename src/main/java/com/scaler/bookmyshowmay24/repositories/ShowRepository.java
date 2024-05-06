package com.scaler.bookmyshowmay24.repositories;

import com.scaler.bookmyshowmay24.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
//    @Override
//    Optional<Show> findById(Long aLong);
}
