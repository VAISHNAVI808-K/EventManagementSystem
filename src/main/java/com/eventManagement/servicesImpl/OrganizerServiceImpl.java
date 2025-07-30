package com.eventManagement.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventManagement.dto.EventResponse;
import com.eventManagement.dto.OrganizerRequest;
import com.eventManagement.dto.OrganizerResponse;
import com.eventManagement.entities.EventEntity;
import com.eventManagement.entities.OrganizerEntity;
import com.eventManagement.exception.ResourceNotFoundException;
import com.eventManagement.repositories.OrganizerRepository;
import com.eventManagement.services.OrganizerService;

@Service
public class OrganizerServiceImpl implements OrganizerService {

	@Autowired
	private OrganizerRepository organizerRepository;

	@Override
	public OrganizerResponse createOrganizer(OrganizerRequest organizerRequest) {
		OrganizerEntity entity = convertRequestToEntity(organizerRequest);
		OrganizerEntity save = organizerRepository.save(entity);
		return convertEntityToResponse(save);
	}

	@Override
	public OrganizerResponse getOrganizerById(Long id) {
		  OrganizerEntity entity = organizerRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Organizer not found with id " + id));
	        return convertEntityToResponse(entity);
	}

	@Override
	public List<OrganizerResponse> getAllOrganizers() {
		List<OrganizerEntity> list = organizerRepository.findAll();

		List<OrganizerResponse> resList = new ArrayList<>();
		for (OrganizerEntity entity : list) {
			OrganizerResponse response = convertEntityToResponse(entity);
			resList.add(response);
		}
		return resList;
	}

	@Override
	public OrganizerResponse updateOrganizer(Long id, OrganizerRequest organizerRequest) {
		if (Objects.nonNull(id)) {
			  OrganizerEntity entity = organizerRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Organizer not found with id " + id));

			  entity.setOrganizerName(organizerRequest.getOrganizerName());
			  entity.setContactInfo(organizerRequest.getContactInfo());
		        
			  OrganizerEntity save = organizerRepository.save(entity);
		        OrganizerResponse response = convertEntityToResponse(save);
		        return response;
		} else {
			throw new RuntimeException("Organizer is not updated...!!!");
		}
	}

	@Override
	public String deleteOrganizer(Long id) {
		if (Objects.nonNull(id)) {
			 OrganizerEntity entity = organizerRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Organizer not found with id " + id));
			 organizerRepository.delete(entity);
			return "Organizer is deleted...!!!";
		} else {
			throw new RuntimeException("Organizer is not deleted...!!!");
		}
	}

	private OrganizerEntity convertRequestToEntity(OrganizerRequest request) {
		OrganizerEntity entity = new OrganizerEntity();
		entity.setOrganizerName(request.getOrganizerName());
		entity.setContactInfo(request.getContactInfo());
		return entity;
	}

	private OrganizerResponse convertEntityToResponse(OrganizerEntity organizer) {
		OrganizerResponse organizerResponse = new OrganizerResponse();
		organizerResponse.setOrganizerId(organizer.getOrganizerId());
		organizerResponse.setOrganizerName(organizer.getOrganizerName());
		organizerResponse.setContactInfo(organizer.getContactInfo());
		return organizerResponse;
	}
}
