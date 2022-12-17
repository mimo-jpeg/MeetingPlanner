package com.safir.meetingplanner.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Room room;

    private LocalTime startTime;
    private LocalTime endTime;

    // Constructors, getters, and setters
}

