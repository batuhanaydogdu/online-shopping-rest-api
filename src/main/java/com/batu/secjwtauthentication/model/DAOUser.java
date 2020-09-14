package com.batu.secjwtauthentication.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class DAOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotEmpty
	private String username;
	
	@JsonIgnore
	@NotEmpty
	@Size(min = 3, message = "Length must be more than 3")
	private String password;
	@Column
	private String role;
	
	@NaturalId
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	private String address;
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)//mappedby böyle ise DAOCart objesinde DAOUser attributesinin adı user o user bu user
	@JsonIgnore
	private DAOCart cart;
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public DAOCart getCart() {
		return cart;
	}
	public void setCart(DAOCart cart) {
		this.cart = cart;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "DAOUser [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ", email="
				+ email + ", address=" + address + ", cart=" + cart + "]";
	}
	
	

}