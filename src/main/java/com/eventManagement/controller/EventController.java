package com.eventManagement.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventManagement.dto.EventRequest;
import com.eventManagement.dto.EventResponse;
import com.eventManagement.services.EventService;

@RestController
@RequestMapping("/api/events")

public class EventController {

	@Autowired
	private EventService eventService;

	@PostMapping("/create/{organizerId}/{venueId}")
	EventResponse createEvent(@RequestBody EventRequest eventRequest, @PathVariable Long organizerId, @PathVariable Long venueId) throws IOException {
		return eventService.createEvent(eventRequest, organizerId, venueId);
	}

	@GetMapping("/{id}")
	EventResponse getEventById(@PathVariable Long id) {
		return eventService.getEventById(id);
	}

	@GetMapping("/getAllEvents")
	List<EventResponse> getAllEvents() {
		return eventService.getAllEvents();
	}

	@PutMapping("/updateEvent/{id}")
	EventResponse updateEvent(@PathVariable Long id, @RequestBody EventRequest eventRequest) {
		return eventService.updateEvent(id, eventRequest);

	}
	
	@DeleteMapping("/deleteEvent/{id}")
	String deleteUser(@PathVariable Long id) {
		return eventService.deleteEvent(id);
	}

	
	@GetMapping("/getEventsByVenue/{venueId}")
   List<EventResponse> getEventsByVenue(@PathVariable Long venueId) {
     return  eventService.getEventsByVenue(venueId);
       
    }

    @GetMapping("/getEventsByOrganizer/{organizerId}")
    List<EventResponse> getEventsByOrganizer(@PathVariable Long organizerId) {
       return eventService.getEventsByOrganizer(organizerId);
        
    }
}
