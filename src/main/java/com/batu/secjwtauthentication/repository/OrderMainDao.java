package com.batu.secjwtauthentication.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.batu.secjwtauthentication.model.DAOOrderMain;

@Repository
public interface OrderMainDao extends CrudRepository<DAOOrderMain, Long>{

	List<DAOOrderMain> findAllByOrderStatus(Integer orderStatus);
	List<DAOOrderMain> findAllByBuyerEmail(String buyerEmail);
	
	
	
	
}
