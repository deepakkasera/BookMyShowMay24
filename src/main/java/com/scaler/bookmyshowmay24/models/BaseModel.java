package com.scaler.bookmyshowmay24.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseModel {
    @Id // PK attr for all the child classes of BaseModel.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO INCREMENT.
    private Long id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedAt;
}


//We don't need the table for BaseModel class.
//But we want all the attributes of BaseModel class to be present in the model tablels