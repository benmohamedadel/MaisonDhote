package com.example.validation.maisonDhote.models;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="RESERVATION")
public class ReservationModel {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String fullName;
		private int phoneNumber;
		private Date CheckIn;
		private Date CheckOut ;
		private int nbguests;
		private int nbChildrens;
		private ReservationModel() {
		
		}
		private ReservationModel(String fullName, int phoneNumber, Date checkIn, Date checkOut,
				int nbguests, int nbChildrens) {
			this.fullName = fullName;
			this.phoneNumber = phoneNumber;
			this.CheckIn = checkIn;
			this.CheckIn = checkOut;
			this.nbguests = nbguests;
			this.nbChildrens = nbChildrens;
		}
		public Long getId() {
			return id;
		}
		public String getFullName() {
			return fullName;
		}
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		public int getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(int phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public Date getCheckIn() {
			return CheckIn;
		}
		public void setCheckIn(Date checkIn) {
			this.CheckIn = checkIn;
		}
		public Date getCheckOut() {
			return CheckOut;
		}
		public void setCheckOut(Date checkOut) {
			this.CheckOut = checkOut;
		}
		public int getNbguests() {
			return nbguests;
		}
		public void setNbguests(int nbguests) {
			this.nbguests = nbguests;
		}
		public int getNbChildrens() {
			return nbChildrens;
		}
		public void setNbChildrens(int nbChildrens) {
			this.nbChildrens = nbChildrens;
		}
		@Override
		public String toString() {
			return "ReservationModel [id=" + id + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber
					+ ", CheckIn=" + CheckIn + ", CheckOut=" + CheckOut + ", nbguests=" + nbguests + ", nbChildrens="
					+ nbChildrens + "]";
		}
		

}
