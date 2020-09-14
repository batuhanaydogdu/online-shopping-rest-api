package com.batu.secjwtauthentication.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.batu.secjwtauthentication.business.dto.UserDTO;
import com.batu.secjwtauthentication.model.DAOUser;
import com.batu.secjwtauthentication.repository.CartDao;
import com.batu.secjwtauthentication.repository.UserDao;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	@Autowired
	private CartDao cartDao;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		DAOUser user = userDao.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with email: " + email);
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				new ArrayList<>());
	}
	
	public DAOUser save(UserDTO user) {
		DAOUser newUser = new DAOUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setRole(user.getRole());
		newUser.setEmail(user.getEmail());
		newUser.setAddress(user.getAddress());
		if(user.getCartId()!=null) {
			newUser.setCart(cartDao.findById(user.getCartId()).get());
			
			
		}
		
		
		
		return userDao.save(newUser);
	}
}