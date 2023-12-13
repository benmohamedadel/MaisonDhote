package com.example.validation.maisonDhote.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HOUSES")
public class HouseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String location;
	private String details;
	private String city ;
	private String  nameOwner;
	private HouseModel() {
	}
	private HouseModel( String name, String location, String details, String city, String nameOwner) {

		this.name = name;
		this.location = location;
		this.details = details;
		this.city = city;
		this.nameOwner = nameOwner;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getNameOwner() {
	return nameOwner;
	}
	public void setNameOwner(String  nameOwner) {
		this.nameOwner = nameOwner;
	}
	@Override
	public String toString() {
		return "HouseModel [id=" + id + ", name=" + name + ", location=" + location + ", details=" + details + ", city="
				+ city + ", nameOwner=" + nameOwner + "]";
	}
	
	
}
