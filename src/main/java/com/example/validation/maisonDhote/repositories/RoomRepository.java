package com.example.validation.maisonDhote.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.validation.maisonDhote.models.RoomModel;

public interface RoomRepository extends JpaRepository<RoomModel, Long> {

}
