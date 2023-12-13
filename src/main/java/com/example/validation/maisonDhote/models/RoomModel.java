package com.example.validation.maisonDhote.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROOMS")
public class RoomModel {
     
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private String name;
	private int nbguests ;
	private String details;
	private int price ;
	private String nameHouse;
	private RoomModel() {
		
	}
	private RoomModel(String name, int nbguests, String details, int price ,String nameHouse) {
		
		this.name = name;
		this.nbguests = nbguests;
		this.details = details;
		this.price = price;
		this.nameHouse =nameHouse;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNbguests() {
		return nbguests;
	}
	public void setNbguests(int nbguests) {
		this.nbguests = nbguests;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getNameHouse() {
		return nameHouse;
	}
	public void setNameHouse(String nameHouse) {
		this.nameHouse = nameHouse;
	}
	@Override
	public String toString() {
		return "RoomModel [id=" + id + ", name=" + name + ", nbguests=" + nbguests + ", details=" + details + ", price="
				+ price + ", nameHouse=" + nameHouse + "]";
	}

	
}
