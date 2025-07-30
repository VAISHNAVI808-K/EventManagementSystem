package com.eventManagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventManagement.entities.EventEntity;


@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {

	List<EventEntity> findByVenueId(Long venueId);

	List<EventEntity> findByOrganizerId(Long organizerId);
}
