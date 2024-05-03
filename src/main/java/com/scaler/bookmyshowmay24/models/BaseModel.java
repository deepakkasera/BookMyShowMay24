package com.scaler.bookmyshowmay24.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO INCREMENT.
    private Long id;
    private Date createdAt;
    private Date lastModifiedAt;
}


//We don't need the table for BaseModel class.
//But we want all the attributes of BaseModel class to be present in the model tablels