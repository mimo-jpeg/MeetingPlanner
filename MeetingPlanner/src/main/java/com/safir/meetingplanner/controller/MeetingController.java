package com.safir.meetingplanner.controller;

// MeetingController.java

import com.safir.meetingplanner.service.MeetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/meetings")
public class MeetingController {

    private final MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping("/best-room")
    public ResponseEntity<String> findBestRoom(@RequestParam("numberOfPersons") int numberOfPersons,
                                               @RequestParam("typeOfMeeting") String typeOfMeeting,
                                               @RequestParam("resources") List<String> resources) {
        String bestRoom = meetingService.findBestRoom(numberOfPersons, typeOfMeeting, resources);
        return ResponseEntity.ok(bestRoom);
    }
}


