package com.example.validation.maisonDhote.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {


	public String getToken() {
	return token;
}

public void setToken(String token) {
	this.token = token;
}

private String token;
}
