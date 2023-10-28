package com.scaler.bookmyshowoct23.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Show extends BaseModel {
    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Screen screen;
    private Date startTime;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}

/*
  1         1
Show ---- Movie => M:1
 M          1

 1          1
Show ---- Screen => M:1 [SUBJECTIVE]
 M          1
-> One Screen can run multiple shows.

Show - Movie, Theatre, Screen, Time

 */