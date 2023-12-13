package com.example.validation.maisonDhote.services;

import com.example.validation.maisonDhote.models.AuthenticationRequestDto;
import com.example.validation.maisonDhote.models.AuthenticationResponse;
import com.example.validation.maisonDhote.models.RegistrationRequestDto;

public interface UserService{
	
	 AuthenticationResponse register(RegistrationRequestDto request);

	  AuthenticationResponse authenticate(AuthenticationRequestDto request);

}
