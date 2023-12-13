package com.example.validation.maisonDhote.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.validation.maisonDhote.models.RoomModel;
import com.example.validation.maisonDhote.repositories.RoomRepository;
import com.example.validation.maisonDhote.services.RoomService;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired  
	private RoomRepository rRepo ;
	@Override
	public List<RoomModel> getAllRooms() {

		return rRepo.findAll();
	}

	@Override
	public RoomModel getRoomById(Long id) {
		java.util.Optional<RoomModel> r = rRepo.findById(id);
		return r.isPresent() ? r.get(): null;
	}

	@Override
	public void deleteRoomById(Long id) {
	rRepo.deleteById(id);
		
	}

	@Override
	public RoomModel addRoom(RoomModel r) {
	
		return rRepo.save(r);
	}

	@Override
	public RoomModel updateRoom(RoomModel r) {
	
		return rRepo.save(r);
	}

}
