package com.scaler.bookmyshowmay24.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private int rowNum;
    private int colNum;
    private String number;
    private SeatType seatType;
}
