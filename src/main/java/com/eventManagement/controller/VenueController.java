package com.eventManagement.controller;

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

import com.eventManagement.dto.OrganizerRequest;
import com.eventManagement.dto.OrganizerResponse;
import com.eventManagement.dto.VenueRequest;
import com.eventManagement.dto.VenueResponse;
import com.eventManagement.services.VenueService;

@RestController
@RequestMapping("/api/venues")

public class VenueController {

	@Autowired
	private VenueService venueService;

	@PostMapping("/create")
	VenueResponse createVenue(@RequestBody VenueRequest request) {
		return venueService.createVenue(request);
	}
	
	@GetMapping("/{id}")
	VenueResponse getVenueById(@PathVariable Long id) {
		return venueService.getVenueById(id);
	}

	@GetMapping("/getAllOrganizer")
	List<VenueResponse> getAllVenues() {
		return venueService.getAllVenues();
	}
	
	@PutMapping("/updateVenue/{id}")
	VenueResponse updateVenue(@PathVariable Long id, @RequestBody VenueRequest request) {
		return venueService.updateVenue(id, request);

	}
	
	@DeleteMapping("/deleteVenue/{id}")
	String deleteVenue(@PathVariable Long id) {
		return venueService.deleteVenue(id);
	}
}
