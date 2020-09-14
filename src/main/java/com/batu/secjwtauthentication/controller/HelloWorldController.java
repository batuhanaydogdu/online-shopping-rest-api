package com.batu.secjwtauthentication.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.batu.secjwtauthentication.model.DAOUser;
import com.batu.secjwtauthentication.repository.UserDao;

@RestController
public class HelloWorldController {

	@Autowired
	UserDao userDAO;
	
	
	@GetMapping("/hello")
	public ResponseEntity<List<DAOUser>> firstPage() {
		long a=12;
		Optional<DAOUser> userdao=userDAO.findById(a);
		a=13;
		Optional<DAOUser> userdao2=userDAO.findById(a);
		List<DAOUser> b=new ArrayList();
		b.add(userdao.get());
		b.add(userdao2.get());
		
		System.out.println(userdao.get().getUsername()+"  "+userdao.get().getPassword());
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(b);
	}
	
	@GetMapping("dene")
	public String dene() {
		return "deneme";
	}
	@GetMapping("dene2")
	public String dene2() {
		return "deneme2";
	}

}