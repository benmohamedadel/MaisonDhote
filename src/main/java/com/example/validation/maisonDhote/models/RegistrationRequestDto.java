package com.example.validation.maisonDhote.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequestDto {


 
  private String firstName;

  private String lasteName;

  private String email;

  private String adresse;
  
  private String phone;
  
  private String confirmPassword;
  
  private String password;


	public String getFirstName() {
	return firstName;
}





public void setFirstName(String firstName) {
	this.firstName = firstName;
}





public String getLasteName() {
	return lasteName;
}





public void setLasteName(String lasteName) {
	this.lasteName = lasteName;
}





public String getEmail() {
	return email;
}





public void setEmail(String email) {
	this.email = email;
}





public String getAdresse() {
	return adresse;
}





public void setAdresse(String adresse) {
	this.adresse = adresse;
}





public String getPhone() {
	return phone;
}





public void setPhone(String phone) {
	this.phone = phone;
}





public String getConfirmPassword() {
	return confirmPassword;
}





public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}





public String getPassword() {
	return password;
}





public void setPassword(String password) {
	this.password = password;
}





public static User dtoToEntityUser(RegistrationRequestDto dto) {
	
User user= new User();
user.setEmail(dto.getEmail());
user.setFirstname(dto.getFirstName());
user.setLastname(dto.getLasteName());
user.setAdresse(dto.getAdresse());
user.setPhone(dto.getPhone());
user.setConfirmPassword(dto.getConfirmPassword());
user.setPassword(dto.getPassword());
return user;
  }
  }
