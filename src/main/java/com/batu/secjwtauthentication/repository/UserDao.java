package com.batu.secjwtauthentication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.batu.secjwtauthentication.model.DAOUser;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Long> {
	
	DAOUser findByUsername(String username);
	DAOUser findByEmail(String email);
}