package com.safir.meetingplanner.repository;

// RoomRepository.java

import com.safir.meetingplanner.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByCapacityLessThanEqual(int capacity);
    List<Room> findByToolsContaining(String tool);
//    List<Room> findByTimeSlotsContaining(String timeSlot);
//    List<Room> findByAvailableTimeSlotsBetween(Date startTime, Date endTime);
}
