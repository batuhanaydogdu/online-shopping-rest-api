package com.batu.secjwtauthentication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.batu.secjwtauthentication.model.DAOCart;

@Repository
public interface CartDao extends CrudRepository<DAOCart, Long>{

}
