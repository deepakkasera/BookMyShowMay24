package com.scaler.bookmyshowmay24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowMay24Application {

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowMay24Application.class, args);
    }

}
