package com.example.validation.maisonDhote.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation.maisonDhote.models.ReservationModel;
import com.example.validation.maisonDhote.services.ReservationService;
@RestController
@RequestMapping("api/reservation")
@CrossOrigin("*")
public class ReservationController {
     @Autowired 
	public ReservationService resService;
     @GetMapping()
 	public List<ReservationModel> getAll(){
 	return resService.getAllReservation();
 	}
 	@GetMapping("/{id}")
 	public ReservationModel getById(@PathVariable Long id) {
 		return resService.getReservationById(id);
 	}
 		@PostMapping
 		public ReservationModel add(@RequestBody ReservationModel re) {	
 		return resService.updateReservation(re);
 		}
}
