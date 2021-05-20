package com.divergentsl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.divergentsl.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByUsername(String uname);
	
}
