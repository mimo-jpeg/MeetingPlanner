package com.safir.meetingplanner.repository;

// ReservationRepository.java

import com.safir.meetingplanner.model.Reservation;
import com.safir.meetingplanner.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByRoomAndStartTimeAfterAndEndTimeBefore(Room room, LocalTime startTime, LocalTime endTime);
}

