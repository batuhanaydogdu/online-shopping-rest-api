package com.batu.secjwtauthentication.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.batu.secjwtauthentication.model.DAOProductCategory;

@Repository
public interface ProductCategoryDao extends CrudRepository<DAOProductCategory, Integer>{

	List<DAOProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes);
	
	DAOProductCategory findByCategoryType(Integer categoryType);
	
}
