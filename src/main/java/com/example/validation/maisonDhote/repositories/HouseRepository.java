package com.example.validation.maisonDhote.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.validation.maisonDhote.models.HouseModel;

public interface HouseRepository extends JpaRepository<HouseModel, Long>{
	 Optional<List<HouseModel>> findByName(String name);
	Optional <List<HouseModel>> findByLocation(String location);
	Optional<List<HouseModel>> findByNameAndLocation(String name, String location);
	
	
}
