package com.batu.secjwtauthentication.business.service;

import java.util.List;

import com.batu.secjwtauthentication.business.dto.ProductCategoryDTO;
import com.batu.secjwtauthentication.model.DAOProductCategory;

public interface ProductCategoryService {

	List<ProductCategoryDTO> findAll();
	ProductCategoryDTO findByCategoryType(Integer categoryType) throws Exception;
	 List<ProductCategoryDTO> findByCategoryType(List<Integer> categoryTypeList);
	 
	 ProductCategoryDTO save(ProductCategoryDTO productCategoryDto);
	 


}
