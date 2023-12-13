package com.example.validation.maisonDhote.services;

import java.util.List;

import com.example.validation.maisonDhote.models.RoomModel;

public interface RoomService {
       public List<RoomModel> getAllRooms();
       public RoomModel getRoomById(Long id);
       public void deleteRoomById(Long id);
       public RoomModel addRoom(RoomModel r);
       public RoomModel updateRoom(RoomModel r);
}
