package com.scaler.bookmyshowmay24.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel { // Ticket
    private String bookingNumber;

    @ManyToOne
    private User user;

    @ManyToOne
    private Show show;

    @ManyToMany
    private List<ShowSeat> showSeats;
    private int amount;

    @OneToMany
    private List<Payment> payments;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
}

/*
  1            1
Booking ----- User => M:1 ManyToOne
  M            1

  1             1
Booking ------ Show
  M              1


  1               M
Booking ------ ShowSeat
  M               1

  1              M
Booking ------ Payment
  1               1

 */
