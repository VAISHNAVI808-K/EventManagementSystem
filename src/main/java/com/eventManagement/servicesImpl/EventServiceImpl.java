package com.eventManagement.servicesImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventManagement.dto.EventRequest;
import com.eventManagement.dto.EventResponse;
import com.eventManagement.dto.OrganizerResponse;
import com.eventManagement.dto.VenueResponse;
import com.eventManagement.entities.EventEntity;
import com.eventManagement.entities.OrganizerEntity;
import com.eventManagement.entities.VenueEntity;
import com.eventManagement.exception.ResourceNotFoundException;
import com.eventManagement.repositories.EventRepository;
import com.eventManagement.repositories.OrganizerRepository;
import com.eventManagement.repositories.VenueRepository;
import com.eventManagement.services.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private OrganizerRepository organizerRepository;

	@Autowired
	private VenueRepository venueRepository;

	@Override
	public EventResponse createEvent(EventRequest eventRequest, Long organizerId, Long venueId) throws IOException {

		OrganizerEntity organizer = organizerRepository.findById(organizerId)
				.orElseThrow(() -> new ResourceNotFoundException("Organizer not found with id " + organizerId));

		VenueEntity venue = venueRepository.findById(venueId)
				.orElseThrow(() -> new ResourceNotFoundException("Venue not found with id " + venueId));

		EventEntity entity = convertRequestToEntity(eventRequest);
		entity.setOrganizer(organizer);
		entity.setVenue(venue);

		EventEntity save = eventRepository.save(entity);
		EventResponse response = convertEntityToResponse(save);
		return response;
	}

	@Override
	public List<EventResponse> getAllEvents() {

		List<EventEntity> list = eventRepository.findAll();

		List<EventResponse> resList = new ArrayList<>();
		for (EventEntity entity : list) {
			EventResponse response = convertEntityToResponse(entity);
			resList.add(response);
		}
		return resList;

	}

	@Override
	public EventResponse getEventById(Long id) {
		EventEntity event = eventRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Event not found with id " + id));
		EventResponse response = convertEntityToResponse(event);
		return response;
	}

	@Override
	public EventResponse updateEvent(Long id, EventRequest eventRequest) {
		if (Objects.nonNull(id)) {
			EventEntity entity = eventRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Event not found with id " + id));

			entity.setEventName(eventRequest.getEventName());
			entity.setEventDate(eventRequest.getEventDate());
			entity.setDescription(eventRequest.getDescription());
//			entity.setOrganizer(organizer);
//			entity.setVenue(venue);
			EventEntity save = eventRepository.save(entity);
			EventResponse response = convertEntityToResponse(save);
			return response;
		} else {
			throw new RuntimeException("Event is not updated...!!!");
		}
	}

	@Override
	public String deleteEvent(Long id) {
		if (Objects.nonNull(id)) {
			EventEntity entity = eventRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Event not found with id " + id));
			eventRepository.delete(entity);
			return "Event is deleted...!!!";
		} else {
			throw new RuntimeException("Event is not deleted...!!!");
		}
	}

	@Override
	public List<EventResponse> getEventsByVenue(Long venueId) {
		List<EventEntity> events = eventRepository.findByVenueId(venueId);
		List<EventResponse> eventResponses = new ArrayList<>();
		for (EventEntity event : events) {
			eventResponses.add(convertEntityToResponse(event));
		}
		return eventResponses;
	}

	@Override
	public List<EventResponse> getEventsByOrganizer(Long organizerId) {
		List<EventEntity> events = eventRepository.findByOrganizerId(organizerId);
		List<EventResponse> eventResponses = new ArrayList<>();
		for (EventEntity event : events) {
			eventResponses.add(convertEntityToResponse(event));
		}
		return eventResponses;
	}

	private EventEntity convertRequestToEntity(EventRequest request) {
		EventEntity entity = new EventEntity();
		entity.setEventName(request.getEventName());
		entity.setEventDate(request.getEventDate());
		entity.setDescription(request.getDescription());
		return entity;
	}

	private EventResponse convertEntityToResponse(EventEntity event) {
		EventResponse eventResponse = new EventResponse();
		eventResponse.setEventId(event.getEventId());
		eventResponse.setEventName(event.getEventName());
		eventResponse.setEventDate(event.getEventDate());
		eventResponse.setDescription(event.getDescription());

		eventResponse.setOrganizer(event.getOrganizer());
		eventResponse.setVenue(event.getVenue());

		return eventResponse;
	}

//	private OrganizerResponse convertEntityToResponse(OrganizerEntity organizer) {
//		OrganizerResponse organizerResponse = new OrganizerResponse();
//		organizerResponse.setOrganizerId(organizer.getOrganizerId());
//		organizerResponse.setOrganizerName(organizer.getOrganizerName());
//		organizerResponse.setContactInfo(organizer.getContactInfo());
//		return organizerResponse;
//	}
//	
//	private VenueResponse convertEntityToResponse(VenueEntity entity) {
//		VenueResponse response = new VenueResponse();
//		response.setVenueId(entity.getVenueId());
//		response.setVenueName(entity.getVenueName());
//		response.setLocation(entity.getLocation());
//		response.setCapacity(entity.getCapacity());
//		return response;
//	}
}
