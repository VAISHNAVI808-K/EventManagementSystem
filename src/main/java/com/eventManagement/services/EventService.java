package com.eventManagement.services;

import java.io.IOException;
import java.util.List;

import com.eventManagement.dto.EventRequest;
import com.eventManagement.dto.EventResponse;

public interface EventService {

	public EventResponse createEvent(EventRequest eventRequest,Long OrganizerId, Long VenueId) throws IOException;

	public List<EventResponse> getAllEvents();

	public EventResponse getEventById(Long id);

	public EventResponse updateEvent(Long id, EventRequest eventRequest);

	public String deleteEvent(Long id);

	public List<EventResponse> getEventsByVenue(Long venueId);

	public List<EventResponse> getEventsByOrganizer(Long organizerId);
}
