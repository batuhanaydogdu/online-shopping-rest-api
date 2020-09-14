package com.batu.secjwtauthentication.business.service;

import java.util.List;

import com.batu.secjwtauthentication.business.dto.ProductInfoDTO;

public interface ProductInfoService {

	void increaseStock(String productIdDto, int amount) throws Exception;

    void decreaseStock(String productIdDto, int amount) throws Exception;

    ProductInfoDTO offSale(String productIdDto) throws Exception;

    ProductInfoDTO onSale(String productIdDto) throws Exception;

    ProductInfoDTO update(ProductInfoDTO productInfoDto) throws Exception;
    ProductInfoDTO save(ProductInfoDTO productInfoDto) throws Exception;

    void delete(String productIdDto) throws Exception;
	
	List<ProductInfoDTO> findAllInCategory(Integer categoryType);
	
	List<ProductInfoDTO> findAllSellingProducts();
	
	List<ProductInfoDTO> findAll();
	public ProductInfoDTO findOne(String productId) throws Exception;
}
