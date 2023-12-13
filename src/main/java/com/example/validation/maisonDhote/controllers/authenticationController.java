package com.example.validation.maisonDhote.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation.maisonDhote.models.AuthenticationRequestDto;
import com.example.validation.maisonDhote.models.AuthenticationResponse;
import com.example.validation.maisonDhote.models.RegistrationRequestDto;
import com.example.validation.maisonDhote.services.UserService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/auth")
public class authenticationController {
	
@Autowired
	  private  UserService service;

	  @PostMapping("/register")
	  public ResponseEntity<AuthenticationResponse> register(
	      @RequestBody RegistrationRequestDto request
	  ) {
	    return ResponseEntity.ok(service.register(request));
	  }

	  @PostMapping("/authenticate")
	  public ResponseEntity<AuthenticationResponse> register(
	      @RequestBody AuthenticationRequestDto request
	  ) {
	    return ResponseEntity.ok(service.authenticate(request));
	  }
	}

	


