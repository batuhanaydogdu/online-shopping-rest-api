package com.batu.secjwtauthentication.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.batu.secjwtauthentication.model.DAOProductInfo;

@Repository
public interface ProductInfoDao extends CrudRepository<DAOProductInfo, String> {
	
	List<DAOProductInfo> findAllByProductStatus(Integer productStatus);
	List<DAOProductInfo> findAllByCategoryType(Integer categoryType);
	
	
	
	
	
}
