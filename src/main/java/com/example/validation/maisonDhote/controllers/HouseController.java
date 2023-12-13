package com.example.validation.maisonDhote.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation.maisonDhote.models.HouseModel;
import com.example.validation.maisonDhote.repositories.HouseRepository;
import com.example.validation.maisonDhote.services.HouseService;
@RestController
@RequestMapping("api/houses")
@CrossOrigin("*")
public class HouseController {
	 @Autowired
	  private HouseRepository hRepository;

	@Autowired
    public HouseService hService ;
	@GetMapping()
	public List<HouseModel> getAll(){
	return hService.getAllHouses();
	}
	@GetMapping("/{id}")
	public HouseModel getById(@PathVariable Long id) {
		return hService.getHouseById(id);
	}
	@GetMapping("/findByName/{name}")
	public List<HouseModel> findByName(@PathVariable String name) {
		return hService.findByName(name);
	}
	@GetMapping("/findByLocation/{location}")
	public List<HouseModel> findByLocation(@PathVariable String location) {
		return hService.findByLocation(location);
	}
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		hService.deleteHouseById(id);
	}

	
	  @PostMapping()
	  public HouseModel addHouse(@RequestBody HouseModel h) {
	    return hRepository.save(h);
	  }
	@PutMapping
	public HouseModel update(@RequestBody HouseModel h) {
		return hService.updateHouse(h);
	}
}
