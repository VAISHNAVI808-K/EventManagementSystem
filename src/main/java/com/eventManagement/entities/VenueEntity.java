package com.eventManagement.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Venue_Info")
public class VenueEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long venueId;
	private String venueName;
	private String location;
	private int capacity;

	@OneToMany(mappedBy = "venue")
	private List<EventEntity> events;

}
