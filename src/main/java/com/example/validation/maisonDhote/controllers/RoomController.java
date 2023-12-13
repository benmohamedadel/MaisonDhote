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

import com.example.validation.maisonDhote.models.RoomModel;
import com.example.validation.maisonDhote.services.RoomService;

@RestController 
@RequestMapping("api/rooms")
@CrossOrigin("*")
public class RoomController {
	@Autowired
	public RoomService rService;
	
	@GetMapping("")
    public List<RoomModel> getAll(){
		return rService.getAllRooms();
}
	@GetMapping("/{id}")
	public RoomModel getById(@PathVariable Long id) {
		return rService.getRoomById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		rService.deleteRoomById(id);
	}

	@PostMapping
	public RoomModel add(@RequestBody RoomModel r) {
		return rService.updateRoom(r);
	}
	@PutMapping
	public RoomModel update(@RequestBody RoomModel r) {
		return rService.updateRoom(r);
	}
}

