package com.safir.meetingplanner.service;

import com.safir.meetingplanner.model.Room;

import java.util.List;

public interface MeetingService {
    public String findBestRoom(int numberOfPersons, String typeOfMeeting, List<String> resources);
    public List<Room> getAllRooms();

    void addRoom(Room room1);
}
