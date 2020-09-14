package com.batu.secjwtauthentication.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="cart")
public class DAOCart {

	@Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cartId;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JsonIgnore
	@JoinColumn(name = "email", referencedColumnName = "email")
	private DAOUser user;
	
	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true,
            mappedBy = "cart")
    private List<DAOProductInOrder> products = new ArrayList();
	
	
	public DAOCart() {
		// TODO Auto-generated constructor stub
	}
	public DAOCart(DAOUser user) {
		this.user=user;
	}
	public DAOUser getUser() {
		return user;
	}
	public void setUser(DAOUser user) {
		this.user = user;
	}
	public List<DAOProductInOrder> getProducts() {
		return products;
	}
	public void setProducts(List<DAOProductInOrder> products) {
		this.products = products;
	}
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	
	 @Override
	    public String toString() {
	        return "Cart{" +
	                "cartId=" + cartId +
	                ", products=" + products +
	                '}';
	    }
	
	
	
}
