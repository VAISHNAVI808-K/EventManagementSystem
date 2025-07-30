package com.eventManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class VenueRequest {

	private Long venueId;
	private String venueName;
	private String location;
	private int capacity;
}
