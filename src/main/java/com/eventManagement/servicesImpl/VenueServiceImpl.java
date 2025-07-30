package com.eventManagement.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventManagement.dto.VenueRequest;
import com.eventManagement.dto.VenueResponse;
import com.eventManagement.entities.VenueEntity;
import com.eventManagement.exception.ResourceNotFoundException;
import com.eventManagement.repositories.VenueRepository;
import com.eventManagement.services.VenueService;

@Service
public class VenueServiceImpl implements VenueService {

	@Autowired
	private VenueRepository venueRepository;

	@Override
	public VenueResponse createVenue(VenueRequest venueRequest) {
		VenueEntity entity = new VenueEntity();
		entity.setVenueName(venueRequest.getVenueName());
		entity.setLocation(venueRequest.getLocation());
		entity.setCapacity(venueRequest.getCapacity());

		VenueEntity save = venueRepository.save(entity);
		return convertEntityToResponse(save);
	}

	@Override
	public VenueResponse getVenueById(Long id) {
		VenueEntity entity = venueRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Venue not found with id " + id));
		return convertEntityToResponse(entity);
	}

	@Override
	public List<VenueResponse> getAllVenues() {
		List<VenueEntity> list = venueRepository.findAll();

		List<VenueResponse> resList = new ArrayList<>();
		for (VenueEntity entity : list) {
			VenueResponse response = convertEntityToResponse(entity);
			resList.add(response);
		}
		return resList;
	}

	@Override
	public VenueResponse updateVenue(Long id, VenueRequest venueRequest) {
		if (Objects.nonNull(id)) {
			VenueEntity entity = venueRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Venue not found with id " + id));

			entity.setVenueName(venueRequest.getVenueName());
			entity.setLocation(venueRequest.getLocation());
			entity.setCapacity(venueRequest.getCapacity());

			VenueEntity update = venueRepository.save(entity);
			VenueResponse response = convertEntityToResponse(update);
			return response;
		} else {
			throw new RuntimeException("Venue is not updated...!!!");
		}
	}

	@Override
	public String deleteVenue(Long id) {
		if (Objects.nonNull(id)) {
			VenueEntity entity = venueRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Venue not found with id " + id));
			venueRepository.delete(entity);
			return "Venue is deleted...!!!";
		} else {
			throw new RuntimeException("Venue is not deleted...!!!");
		}
	}

	private VenueResponse convertEntityToResponse(VenueEntity entity) {
		VenueResponse response = new VenueResponse();
		response.setVenueId(entity.getVenueId());
		response.setVenueName(entity.getVenueName());
		response.setLocation(entity.getLocation());
		response.setCapacity(entity.getCapacity());
		return response;
	}

}
