package com.eventManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventManagement.entities.VenueEntity;

@Repository
public interface VenueRepository extends JpaRepository<VenueEntity, Long> {

}
