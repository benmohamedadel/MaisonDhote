package com.example.validation.maisonDhote.configSecurity;

import java.util.Arrays;
import java.util.Collections;

import javax.persistence.EntityNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

import com.example.validation.maisonDhote.repositories.UserRepository;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	@Autowired
	 private  UserRepository userRepository;
	@Autowired
	  private JwtAuthFilter jwtAuthFilter;

	  @Bean
	  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf().disable()
	        .authorizeRequests()
	        .antMatchers(
	            "/**/auth/**",
	            // swagger
	            "/v3/api-docs",
	            "/v3/api-docs/**",
	            "/swagger-resources",
	            "/swagger-resources/**",
	            "/configuration/ui",
	            "/configuration/security",
	            "/swagger-ui/**",
	            "/webjars/**",
	            "/swagger-ui.html"
	        )
	        .permitAll()
	        //just pr test 
	        //.antMatchers( "/**/Hotel/**")
	        //.permitAll()
	        		
	
	        .anyRequest()
	        .authenticated()
	        .and()
	        .sessionManagement()
	        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	        .and()
	        .authenticationProvider(authenticationProvider())
	        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
	        .cors()
	    ;
	    return http.build();
	  }

	  @Bean
	    public CorsFilter corsFilter()
	    {
	        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        final CorsConfiguration corsConfiguration = new CorsConfiguration();
	        corsConfiguration.setAllowCredentials(true);
	        corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
	        corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
	        corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","PATCH","DELETE","OPTIONS"));
	        source.registerCorsConfiguration("/**",corsConfiguration);
	        return new CorsFilter(source);
	    }

	  @Bean
	  public AuthenticationProvider authenticationProvider() {
	    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	    authenticationProvider.setUserDetailsService(userDetailsService());
	    authenticationProvider.setPasswordEncoder(passwordEncoder());
	    return authenticationProvider;
	  }

	  @Bean
	  public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
	    return config.getAuthenticationManager();
	  }

	  @Bean
	  public UserDetailsService userDetailsService() {
	    return email -> userRepository.findByEmail(email)
	        .orElseThrow(() -> new EntityNotFoundException("User does not exist in the database, please register"));
	  }

	  @Bean
	  public PasswordEncoder passwordEncoder() {
	    // return NoOpPasswordEncoder.getInstance();
	    return new BCryptPasswordEncoder();
	  }
	

}
