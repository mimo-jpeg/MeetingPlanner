package com.safir.meetingplanner.service;

import com.safir.meetingplanner.model.Reservation;
import com.safir.meetingplanner.model.Room;
import com.safir.meetingplanner.repository.ReservationRepository;
import com.safir.meetingplanner.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class MeetingServiceImpl implements MeetingService {

    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;

    private List<Room> roomList = new ArrayList<>();


    @Autowired
    public MeetingServiceImpl(ReservationRepository reservationRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
    }

    public String findBestRoom(int numberOfPersons, String typeOfMeeting, List<String> resources) {
        // Get a list of all rooms
        List<Room> rooms = getAllRooms();

        // Initialize variables to keep track of the best room and its capacity
        Room bestRoom = null;
        int bestRoomCapacity = Integer.MAX_VALUE;

        for (Room room : rooms) {
            // Check if the room has the required capacity and resources
            if (room.getCapacity() >= numberOfPersons && new HashSet<>(room.getTools()).containsAll(resources)) {
                // Check if the room is available at the given time
                List<Reservation> reservations = reservationRepository.findByRoomAndStartTimeAfterAndEndTimeBefore(room, LocalTime.of(8, 0), LocalTime.of(9, 0));
                if (reservations.isEmpty()) {
                    // If the room is a good fit, update the best room and its capacity
                    if (room.getCapacity() < bestRoomCapacity) {
                        bestRoom = room;
                        bestRoomCapacity = room.getCapacity();
                    }
                }
            }
        }

        // Return the name of the best room
        if (bestRoom != null) {
            return bestRoom.getName();
        } else {
            return "No available room";
        }
    }

    public List<Room> getAllRooms() {
        // Return a list of all rooms in the database
        return roomList;
    }

    @Override
    public void addRoom(Room room) {
       roomList.add(room);
    }
}

