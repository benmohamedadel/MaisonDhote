package com.example.validation.maisonDhote.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.validation.maisonDhote.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("select u from User u where u.email = :email")	
    Optional<User> findUserByEmail(@Param("email") String email);

    Optional<User> findByEmail(String email);
    //other way..User findByEmail (String email);
}
