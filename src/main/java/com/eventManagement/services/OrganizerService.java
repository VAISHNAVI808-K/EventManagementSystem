package com.eventManagement.services;

import java.util.List;

import com.eventManagement.dto.OrganizerRequest;
import com.eventManagement.dto.OrganizerResponse;

public interface OrganizerService {

	public OrganizerResponse createOrganizer(OrganizerRequest organizerRequest);
	
	public OrganizerResponse getOrganizerById(Long id);
	
	public List<OrganizerResponse> getAllOrganizers();
	
	public OrganizerResponse updateOrganizer(Long id, OrganizerRequest organizerRequest);
	
	public String deleteOrganizer(Long id);
}
