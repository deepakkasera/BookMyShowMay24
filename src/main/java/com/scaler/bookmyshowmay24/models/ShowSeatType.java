package com.scaler.bookmyshowmay24.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel {

    @ManyToOne
    private Show show;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    private int price;
}

/*
Show - X, Y, Z
SeatType - GOLD, SILVER, PLATINUM

XGOLD
XSILVER
XPLAITINUM


     1                1
ShowSeatType ------- Show
     M                 1

 */
