package com.example.validation.maisonDhote.models;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name="_User")
public class User implements UserDetails{
	@Id
    @GeneratedValue
    private Long id ;	
	private String firstName;
	private String lasteName;
	private String adresse;
	private String phone;
	private String confirmPassword;
	@Column(unique = true)
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private Erole role;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Long id, String firstName, String lasteName, String adresse, String phone, String confirmPassword,
			String email, String password, Erole role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lasteName = lasteName;
		this.adresse = adresse;
		this.phone = phone;
		this.confirmPassword = confirmPassword;
		this.email = email;
		this.password = password;
		this.role = role;
	}


	public Long getId() {
		return id;
	}
	public String getFirstname() {
		return firstName;
	}
	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lasteName;
	}
	public void setLastname(String lasteName) {
		this.lasteName = lasteName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Erole getRole() {
		return role;
	}
	public void setRole(Erole role) {
		this.role = role;
	}
	public void setPassword(String password) {
		this.password = password;
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
	@Override
	  public Collection<? extends GrantedAuthority> getAuthorities() {
	    return Collections.singleton(new SimpleGrantedAuthority(role.name()));
	  }
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}
	@Override
	public boolean isAccountNonExpired() {
		//ajouter le controle de reservation 
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// customer depature
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
	//active
		return true;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}}
