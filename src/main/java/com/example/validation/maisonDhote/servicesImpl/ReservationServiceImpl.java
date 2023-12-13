package com.example.validation.maisonDhote.servicesImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.validation.maisonDhote.models.ReservationModel;
import com.example.validation.maisonDhote.repositories.ReservationRepository;
import com.example.validation.maisonDhote.services.ReservationService;

@Service

public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private ReservationRepository resRepo ;
	
	@Override
	public List<ReservationModel> getAllReservation() {
		
		return resRepo.findAll();
	}

	@Override
	public ReservationModel getReservationById(Long id) {

	   java.util.Optional<ReservationModel> re = resRepo.findById(id);
	return re.isPresent() ? re.get() : null;
	}
	@Override
	public ReservationModel addReservation(ReservationModel re) {
		
		return resRepo.save(re);
	}
	@Override
	public ReservationModel updateReservation(ReservationModel re) {
	
		return resRepo.save(re);
	}
}
