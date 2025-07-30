package com.eventManagement.services;

import java.util.List;

import com.eventManagement.dto.VenueRequest;
import com.eventManagement.dto.VenueResponse;

public interface VenueService {

	public VenueResponse createVenue(VenueRequest venueRequest);

	public VenueResponse getVenueById(Long id);

	public List<VenueResponse> getAllVenues();

	public VenueResponse updateVenue(Long id, VenueRequest venueRequest);

	public String deleteVenue(Long id);
}
