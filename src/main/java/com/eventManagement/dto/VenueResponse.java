package com.eventManagement.dto;

import java.util.List;

import com.eventManagement.entities.EventEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class VenueResponse {

	private Long venueId;
	private String venueName;
	private String location;
	private int capacity;

	private List<EventEntity> events;
}
