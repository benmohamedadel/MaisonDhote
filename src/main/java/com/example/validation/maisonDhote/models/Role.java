package com.example.validation.maisonDhote.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Entity
public class Role {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long role_id;
private String role; 
	
}
