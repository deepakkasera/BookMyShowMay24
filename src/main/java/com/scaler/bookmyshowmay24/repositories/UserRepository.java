package com.scaler.bookmyshowmay24.repositories;

import com.scaler.bookmyshowmay24.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //select * from users where id = userId
    @Override
    Optional<User> findById(Long userId);

//    @Override
//    Optional<User> findBy(Long userId);
}

/*
user_id <-> user
 */
