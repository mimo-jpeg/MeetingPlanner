package com.safir.meetingplanner.service;

import com.safir.meetingplanner.model.Room;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MeetingServiceImplTest {
        @Autowired
        private MeetingService meetingService;

        @Test
        void testGetBestRoom() {
            // Create some rooms and add them to the utility
            List<String> tools1 = new ArrayList<>();
            tools1.add("screen");
            tools1.add("octopus");
            tools1.add("webcam");
            List<String> tools2 = new ArrayList<>();
            tools2.add("board");
            List<String> tools3 = new ArrayList<>();
            tools3.add("board");
            tools3.add("screen");
            tools3.add("octopus");
            List<String> tools4 = new ArrayList<>();
            Room room1 = new Room(1L,"Room 1", 10, tools1);
            Room room2 = new Room(2L,"Room 2", 20, tools2);
            Room room3 = new Room(3L,"Room 3", 15, tools3);
            Room room4 = new Room(4L,"Room 4", 15, tools4);
            meetingService.addRoom(room1);
            meetingService.addRoom(room2);
            meetingService.addRoom(room3);
            meetingService.addRoom(room4);

            // Test finding the best room for a videoconference (VC)
            String bestRoom = meetingService.findBestRoom(8, "VC", tools1);
            assertEquals("Room 1", bestRoom);

            // Test finding the best room for a sharing and case study session (SPEC)
            bestRoom = meetingService.findBestRoom(10, "SPEC", tools2);
            assertEquals("Room 2", bestRoom);

            // Test finding the best room for a simple meeting (RS)
            bestRoom = meetingService.findBestRoom(5, "RS", tools4);
            assertEquals("Room 4", bestRoom);

            // Test finding the best room for a coupled meeting (RC)
            bestRoom = meetingService.findBestRoom(12, "RC", tools3);
            assertEquals("Room 3", bestRoom);

            // Test finding the best room when no suitable room is available
            bestRoom = meetingService.findBestRoom(2, "VC", tools4);
            assertNull(bestRoom);
        }
}
