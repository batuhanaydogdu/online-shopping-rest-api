package com.batu.secjwtauthentication.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.batu.secjwtauthentication.business.dto.ProductCategoryDTO;
import com.batu.secjwtauthentication.business.service.ProductCategoryService;

@RestController
@CrossOrigin
public class ProductCategoryController {
	@Autowired
	ProductCategoryService productCategoryService;
	
	
	@PostMapping("/productCategory/save")
	public ResponseEntity<?> saveProductCategory(@RequestBody ProductCategoryDTO productCategoryDto) throws Exception {
		return ResponseEntity.ok(productCategoryService.save(productCategoryDto));
	}
	
	
}
