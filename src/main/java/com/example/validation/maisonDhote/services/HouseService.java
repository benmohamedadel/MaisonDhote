package com.example.validation.maisonDhote.services;

import java.util.List;

import com.example.validation.maisonDhote.models.HouseModel;

public interface HouseService {
	 public List<HouseModel> getAllHouses();
     public HouseModel getHouseById(Long id);
     public void deleteHouseById(Long id);
     public HouseModel addHouse(HouseModel h);
     public HouseModel updateHouse(HouseModel h);
	public List<HouseModel> findByName(String name);
	public List<HouseModel> findByLocation(String location);
    

}
