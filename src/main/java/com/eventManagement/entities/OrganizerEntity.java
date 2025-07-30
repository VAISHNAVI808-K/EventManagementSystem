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
@Table(name = "Organizer_Info")
public class OrganizerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long organizerId;
	private String organizerName;
	private String contactInfo;

	@OneToMany(mappedBy = "organizer")
	private List<EventEntity> events;

}
