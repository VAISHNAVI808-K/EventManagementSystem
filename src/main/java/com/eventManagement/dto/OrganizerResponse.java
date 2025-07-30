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

public class OrganizerResponse {

	private Long organizerId;
	private String organizerName;
	private String contactInfo;

	private List<EventEntity> events;
}
