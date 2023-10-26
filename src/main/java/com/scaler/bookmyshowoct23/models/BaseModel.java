package com.scaler.bookmyshowoct23.models;

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
    //This class will contain the common attributes to all the Models.
    @Id //PRIMARY KEY COLUMN.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO INCREMENT
    private Long id;
    private Date createdAt;
    private Date lastModifiedAt;
}

//CARDINALITIES.
