package com.divergentsl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.divergentsl.entity.Users;
import com.divergentsl.repository.UserRepository;

public class LoginUserDetailService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user not found"));
		
		UserDetails u = User.withUsername(user.getUsername()).password(user.getPassword()).authorities("user").build();
		
		return u;
	}

}