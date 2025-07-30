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

import com.eventManagement.dto.EventRequest;
import com.eventManagement.dto.EventResponse;
import com.eventManagement.dto.OrganizerRequest;
import com.eventManagement.dto.OrganizerResponse;
import com.eventManagement.services.OrganizerService;

@RestController
@RequestMapping("/api/organizers")
public class OrganizerController {

	@Autowired
	private OrganizerService organizerService;

	@PostMapping("/create")
	OrganizerResponse createOrganizer(@RequestBody OrganizerRequest request) {
		return organizerService.createOrganizer(request);
	}
	
	@GetMapping("/{id}")
	OrganizerResponse getOrganizerById(@PathVariable Long id) {
		return organizerService.getOrganizerById(id);
	}

	@GetMapping("/getAllOrganizer")
	List<OrganizerResponse> getAllOrganizers() {
		return organizerService.getAllOrganizers();
	}
	
	@PutMapping("/updateOrganizer/{id}")
	OrganizerResponse updateOrganizer(@PathVariable Long id, @RequestBody OrganizerRequest request) {
		return organizerService.updateOrganizer(id, request);

	}
	
	@DeleteMapping("/deleteOrganizer/{id}")
	String deleteOrganizer(@PathVariable Long id) {
		return organizerService.deleteOrganizer(id);
	}


	
}
