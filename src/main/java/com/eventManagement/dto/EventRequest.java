package com.eventManagement.dto;

import java.util.Date;

import com.eventManagement.entities.OrganizerEntity;
import com.eventManagement.entities.VenueEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class EventRequest {

	private Long eventId;
	private String eventName;
	private Date eventDate;
	private String description;
	private OrganizerEntity organizer;
	private VenueEntity venue;
}
