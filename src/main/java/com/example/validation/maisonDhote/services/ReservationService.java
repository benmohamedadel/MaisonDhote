package com.example.validation.maisonDhote.services;

import java.util.List;

import com.example.validation.maisonDhote.models.ReservationModel;

public interface ReservationService {
	 public List<ReservationModel> getAllReservation();
     public ReservationModel getReservationById(Long id);
     public ReservationModel addReservation(ReservationModel re);
     public ReservationModel updateReservation(ReservationModel re);
    
}
