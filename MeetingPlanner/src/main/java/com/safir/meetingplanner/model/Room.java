package com.safir.meetingplanner.model;

// Room.java

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int capacity;
    @ElementCollection
    private List<String> tools;


    // Constructors, getters, and setters
}

