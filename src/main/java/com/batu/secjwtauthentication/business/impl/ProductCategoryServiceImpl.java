package com.batu.secjwtauthentication.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batu.secjwtauthentication.business.dto.ProductCategoryDTO;
import com.batu.secjwtauthentication.business.service.ProductCategoryService;
import com.batu.secjwtauthentication.model.DAOProductCategory;
import com.batu.secjwtauthentication.repository.ProductCategoryDao;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{

	@Autowired
	ProductCategoryDao productCategoryDao;
	
	
	
	@Override
	public List<ProductCategoryDTO> findAll() {
		
		List<ProductCategoryDTO> rs=new ArrayList<ProductCategoryDTO>();
		
		for(DAOProductCategory daoProductCategory:productCategoryDao.findAll()) {
			
			
			rs.add(toDto(daoProductCategory));
		}
		
		
		
		return rs;
	}

	@Override
	public ProductCategoryDTO findByCategoryType(Integer categoryType) throws Exception {
		
		ProductCategoryDTO productCategoryDto=toDto(productCategoryDao.findByCategoryType(categoryType));
		
		if(productCategoryDto==null) {
			throw new Exception("olm invalid category type");
		}
		
		return productCategoryDto;
	}

	@Override
	public List<ProductCategoryDTO> findByCategoryType(List<Integer> categoryTypeList) {
		
		
		
		List<ProductCategoryDTO> rs=new ArrayList<ProductCategoryDTO>();

		
		
		for(DAOProductCategory daoProductCategory:productCategoryDao.findByCategoryTypeIn(categoryTypeList)) {
			
			
			rs.add(toDto(daoProductCategory));
		}
		
		
		
		
		
		return rs;
	}

	@Override
	public ProductCategoryDTO save(ProductCategoryDTO productCategoryDto) {
		DAOProductCategory daoProductCategory=productCategoryDao.save(toEntity(productCategoryDto));
		return toDto(daoProductCategory);
	}
	
	
	private DAOProductCategory toEntity(ProductCategoryDTO productCategoryDto) {
		DAOProductCategory daoProductCategory=new DAOProductCategory();
		
		daoProductCategory.setCategoryName(productCategoryDto.getCategoryName());
		daoProductCategory.setCategoryType(productCategoryDto.getCategoryType());
		
		// @CreationTimestamp and @UpdateTimestamp çalışma mantığını öğrendikten sonra duruma göre update edilecek
		daoProductCategory.setCreateTime(productCategoryDto.getCreateTime());
		daoProductCategory.setUpdateTime(productCategoryDto.getUpdateTime());
		
		
		return daoProductCategory;
	}
	private ProductCategoryDTO toDto(DAOProductCategory daoProductCategory) {
		ProductCategoryDTO productCategoryDto =new ProductCategoryDTO();
		
		productCategoryDto.setCategoryName(daoProductCategory.getCategoryName());
		productCategoryDto.setCategoryType(daoProductCategory.getCategoryType());
		productCategoryDto.setCreateTime(daoProductCategory.getCreateTime());
		productCategoryDto.setUpdateTime(daoProductCategory.getUpdateTime());
		
		return productCategoryDto;
		
	}
	
	
	
	
	
	

}
