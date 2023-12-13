package com.example.validation.maisonDhote.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.validation.maisonDhote.models.HouseModel;
import com.example.validation.maisonDhote.repositories.HouseRepository;
import com.example.validation.maisonDhote.services.HouseService;
@Service
public class HouseServiceImpl implements HouseService {
 
	@Autowired
	private HouseRepository hRepo ;
  
	@Override
	public List<HouseModel> getAllHouses() {
		
		return hRepo.findAll();
	}
	@GetMapping("/houses/findByName/{name}")
	public List<HouseModel> findByName(@PathVariable String name) {
	    List<HouseModel> houses = hRepo.findByName(name).orElse(new ArrayList<>());

	    return houses;
		
	}
	@GetMapping("/houses/findByLocation/{location}")
	public List<HouseModel> findByLocation(@PathVariable String location) {
		List<HouseModel> houses = hRepo.findByLocation(location).orElse(new ArrayList<>());
          
		return houses;
		
	}
	@GetMapping("/houses/findByCriteria")
	public List<HouseModel> findByCriteria(
	        @RequestParam(required = false) String name,
	        @RequestParam(required = false) String location) {

	    if (name != null && location != null) {
	        // Recherche par nom et emplacement
	        return hRepo.findByNameAndLocation(name, location).orElse(new ArrayList<>());
	    } else if (name != null) {
	        // Recherche par nom
	        return hRepo.findByName(name).orElse(new ArrayList<>());
	    } else if (location != null) {
	        // Recherche par emplacement
	        return hRepo.findByLocation(location).orElse(new ArrayList<>());
	    } else {
	        // Gérer le cas où les deux paramètres sont nuls, si nécessaire
	        return new ArrayList<>();
	    }
	}

	@Override
	public HouseModel getHouseById(Long id) {

	   java.util.Optional<HouseModel> h = hRepo.findById(id);
	return h.isPresent() ? h.get() : null;
	}

	@Override
	public void deleteHouseById(Long id) {
	hRepo.deleteById(id);
		
	}

	@Override
	public HouseModel addHouse(HouseModel h) {
		
		return hRepo.save(h);
	}

	@Override
	public HouseModel updateHouse(HouseModel h) {
	
		return hRepo.save(h);
	}

}
