package com.example.validation.maisonDhote.servicesImpl;

import java.util.HashMap;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.validation.maisonDhote.configSecurity.JwtUtils;
import com.example.validation.maisonDhote.models.AuthenticationRequestDto;
import com.example.validation.maisonDhote.models.AuthenticationResponse;
import com.example.validation.maisonDhote.models.Erole;
import com.example.validation.maisonDhote.models.RegistrationRequestDto;
import com.example.validation.maisonDhote.models.User;
import com.example.validation.maisonDhote.repositories.UserRepository;
import com.example.validation.maisonDhote.services.UserService;




@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
	@Autowired
	private  PasswordEncoder passwordEncoder;
	TokenRepository tokenRepository;
	private JwtUtils jwtUtils;

	private final  AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;
	private void revokeAllUserTokens(User user) {

		var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
		if (validUserTokens.isEmpty())
			return;
		validUserTokens.forEach(token -> {
			token.setExpired(true);
			token.setRevoked(true);
		});
		tokenRepository.saveAll(validUserTokens);
	}

	@Override
	public AuthenticationResponse authenticate(AuthenticationRequestDto request) {
		System.out.println(request);
		System.out.println(request.getEmail());
	/*	authenticationManager
				.authenticate(
						new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		System.out.println("Authentication successful. Password after authentication: " + request.getPassword());
		final User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
		Map<String, Object> claims = new HashMap<>();
		claims.put("userId", user.getId()); // optional
		claims.put("fullName", user.getFirstname() + " " + user.getLastname()); // optional
		// generate a JWT token
		String token = jwtUtils.generateToken(user, claims);
		AuthenticationResponse authenticationResponse = new AuthenticationResponse(token);

		return authenticationResponse ;*/
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getEmail(),
						request.getPassword()
				)
		);
		var user = userRepository.findByEmail(request.getEmail())
				.orElseThrow();
		var jwtToken = jwtUtils.generateToken(user);
		var refreshToken = jwtUtils.generateRefreshToken(user);
		revokeAllUserTokens(user);
		saveUserToken(user, jwtToken);
		return AuthenticationResponse.builder()
				.accessToken(jwtToken)
				.refreshToken(refreshToken)
				.build();
	}

	@Override
	public AuthenticationResponse register(RegistrationRequestDto request) {
		User user = RegistrationRequestDto.dtoToEntityUser(request);		    
		    // encode the password
		    user.setPassword(passwordEncoder.encode(request.getPassword()));
		    user.setRole(Erole.USER);
		    var savedUser = userRepository.save(user);

		    Map<String, Object> claims = new HashMap<>();
		   // claims.put("userId", savedUser.getId()); // optional
		    claims.put("fullName", savedUser.getFirstname() + " " + savedUser.getLastname()); // optional

		    // generate a JWT token
		    String token = jwtUtils.generateToken(savedUser, claims);
		    AuthenticationResponse authenticationResponse = new AuthenticationResponse(token);
		//	authenticationResponse.setToken(token);
			return authenticationResponse ;
		  }

}
