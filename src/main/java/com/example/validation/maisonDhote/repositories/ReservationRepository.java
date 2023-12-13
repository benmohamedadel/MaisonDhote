package com.example.validation.maisonDhote.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.validation.maisonDhote.models.ReservationModel;

public interface ReservationRepository extends JpaRepository<ReservationModel, Long> {

}
