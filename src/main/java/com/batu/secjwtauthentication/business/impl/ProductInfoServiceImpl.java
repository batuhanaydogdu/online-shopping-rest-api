package com.batu.secjwtauthentication.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.batu.secjwtauthentication.business.dto.ProductInfoDTO;
import com.batu.secjwtauthentication.business.service.ProductCategoryService;
import com.batu.secjwtauthentication.business.service.ProductInfoService;
import com.batu.secjwtauthentication.model.DAOProductInfo;
import com.batu.secjwtauthentication.repository.ProductCategoryDao;
import com.batu.secjwtauthentication.repository.ProductInfoDao;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {
	@Autowired
	ProductInfoDao productInfoDao;

	@Autowired
	ProductCategoryDao productCategoryDao;

	@Autowired
	ProductCategoryService productCategoryService;

	@Override
	@Transactional
	public void increaseStock(String productIdDto, int amount) throws Exception {
		Optional<DAOProductInfo> optional = productInfoDao.findById(productIdDto);
		if (optional.isPresent()) {
			DAOProductInfo daoProductInfo = optional.get();
			daoProductInfo.setProductStock(daoProductInfo.getProductStock() + amount);
			productInfoDao.save(daoProductInfo);

		} else
			throw new Exception("olm product not exist");

	}

	@Override
	@Transactional
	public void decreaseStock(String productIdDto, int amount) throws Exception {
		Optional<DAOProductInfo> optional = productInfoDao.findById(productIdDto);
		if (optional.isPresent()) {
			DAOProductInfo daoProductInfo = optional.get();
			daoProductInfo.setProductStock(daoProductInfo.getProductStock() - amount);
			productInfoDao.save(daoProductInfo);

		} else
			throw new Exception("olm product not exist");

	}

	@Override
	@Transactional
	public ProductInfoDTO offSale(String productIdDto) throws Exception {

		Optional<DAOProductInfo> optional = productInfoDao.findById(productIdDto);

		if (optional.isPresent()) {
			DAOProductInfo daoProductInfo = optional.get();

			if (daoProductInfo.getProductStatus() == 1) {
				throw new Exception("olm product already offsale");
			}
			daoProductInfo.setProductStatus(1);
			return toDto(productInfoDao.save(daoProductInfo));
		} else {
			throw new Exception("olm product not found");
		}
	}

	@Override
	@Transactional
	public ProductInfoDTO onSale(String productIdDto) throws Exception {
		Optional<DAOProductInfo> optional = productInfoDao.findById(productIdDto);

		if (optional.isPresent()) {
			DAOProductInfo daoProductInfo = optional.get();

			if (daoProductInfo.getProductStatus() == 0) {
				throw new Exception("olm product already onsale");
			}
			daoProductInfo.setProductStatus(0);
			return toDto(productInfoDao.save(daoProductInfo));
		} else {
			throw new Exception("olm product not found");
		}
	}

	@Override
	public ProductInfoDTO update(ProductInfoDTO productInfoDto) throws Exception {

		// implemented throw exception for method so if null method will throw exception
		if(productInfoDto.getProductStatus()==null) {
			productInfoDto.setProductStatus(0);
			
		}
		
		if ( productInfoDto.getProductStatus() > 1) {
			throw new Exception("olm product status must be 1 or 0 for product");
		}
		// if problem check for id -- future
		return toDto(productInfoDao.save(toEntity(productInfoDto)));

	}

	@Override
	public ProductInfoDTO save(ProductInfoDTO productInfoDto) throws Exception {
		if(productInfoDao.existsById(productInfoDto.getProductId())) {
			throw new Exception("already exists");
		}
		return update(productInfoDto);
	}

	@Override
	public void delete(String productIdDto) throws Exception {

		Optional<DAOProductInfo> optional = productInfoDao.findById(productIdDto);

		if (optional.isPresent()) {
			productInfoDao.delete(optional.get());
		} else {
			throw new Exception("olm product not exist");
		}

	}

	@Override
	public List<ProductInfoDTO> findAllInCategory(Integer categoryType) {

		List<ProductInfoDTO> listOfProductInfoDto = new ArrayList();
		for (DAOProductInfo daoProductInfo : productInfoDao.findAllByCategoryType(categoryType)) {
			listOfProductInfoDto.add(toDto(daoProductInfo));
		}
		return listOfProductInfoDto;

	}

	@Override
	public List<ProductInfoDTO> findAllSellingProducts() {
		// O MEAN ON SALE
		List<ProductInfoDTO> listOfProductInfoDto = new ArrayList();
		for (DAOProductInfo daoProductInfo : productInfoDao.findAllByProductStatus(0)) {
			listOfProductInfoDto.add(toDto(daoProductInfo));
		}
		return listOfProductInfoDto;

	}

	@Override
	public List<ProductInfoDTO> findAll() {

		List<ProductInfoDTO> listOfProductInfoDto = new ArrayList();
		for (DAOProductInfo daoProductInfo : productInfoDao.findAll()) {
			listOfProductInfoDto.add(toDto(daoProductInfo));
		}
		return listOfProductInfoDto;

	}

	private DAOProductInfo toEntity(ProductInfoDTO productInfoDto) {
		DAOProductInfo daoProductInfo = new DAOProductInfo();

		daoProductInfo.setCategoryType(productInfoDto.getCategoryType());
		daoProductInfo.setProductDescription(productInfoDto.getProductDescription());
		daoProductInfo.setProductId(productInfoDto.getProductId());
		daoProductInfo.setProductName(productInfoDto.getProductName());
		daoProductInfo.setProductPrice(productInfoDto.getProductPrice());
		daoProductInfo.setProductStock(productInfoDto.getProductStock());
		daoProductInfo.setCreateTime(productInfoDto.getCreateTime());
		daoProductInfo.setUpdateTime(productInfoDto.getUpdateTime());
		daoProductInfo.setProductStatus(productInfoDto.getProductStatus());

		return daoProductInfo;
	}

	private ProductInfoDTO toDto(DAOProductInfo daoProductInfo) {
		ProductInfoDTO productInfoDto = new ProductInfoDTO();

		productInfoDto.setCategoryType(daoProductInfo.getCategoryType());
		productInfoDto.setCreateTime(daoProductInfo.getCreateTime());
		productInfoDto.setProductDescription(daoProductInfo.getProductDescription());
		productInfoDto.setProductId(daoProductInfo.getProductId());
		productInfoDto.setProductName(daoProductInfo.getProductName());
		productInfoDto.setProductPrice(daoProductInfo.getProductPrice());
		productInfoDto.setProductStatus(daoProductInfo.getProductStatus());
		productInfoDto.setProductStock(daoProductInfo.getProductStock());
		productInfoDto.setUpdateTime(daoProductInfo.getUpdateTime());

		return productInfoDto;
	}

	@Override
	public ProductInfoDTO findOne(String productId) throws Exception {
		Optional<DAOProductInfo> optional=productInfoDao.findById(productId);
		if(optional.isPresent()) {
			
			return toDto(optional.get());
		}
		else {
			throw new Exception("product not found la");
		}
		
		
		
	}

}
