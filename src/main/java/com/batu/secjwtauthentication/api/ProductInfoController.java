package com.batu.secjwtauthentication.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.batu.secjwtauthentication.business.dto.ProductInfoDTO;
import com.batu.secjwtauthentication.business.service.ProductCategoryService;
import com.batu.secjwtauthentication.business.service.ProductInfoService;

@RestController
@CrossOrigin
public class ProductInfoController {
	@Autowired
	ProductInfoService productInfoService;
	@Autowired
	ProductCategoryService productCategoryService;

	@GetMapping("/product")
	public ResponseEntity<List<ProductInfoDTO>> findAll() {
		return ResponseEntity.ok(productInfoService.findAll());
	}

	@GetMapping("/product/{productId}")
	public ResponseEntity<?> showOne(@PathVariable("productId") String productId) {

		try {
			return ResponseEntity.ok(productInfoService.findOne(productId));
		} catch (Exception e) {

			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@PostMapping("/seller/product/new")
	public ResponseEntity<?> create(@RequestBody ProductInfoDTO productInfoDto) {

		try {
			return ResponseEntity.ok(productInfoService.save(productInfoDto));
		} catch (Exception e) {

			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@PutMapping("/seller/product/{id}/edit")
	public ResponseEntity<?> edit(@PathVariable("id") String productId, @RequestBody ProductInfoDTO productInfoDto) {

		try {
			return ResponseEntity.ok(productInfoService.update(productInfoDto));
		} catch (Exception e) {

			e.printStackTrace();

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/seller/product/{id}/delete")
	public ResponseEntity<?> delete(@PathVariable("id") String productID){
		
		try {
			productInfoService.delete(productID);
			return ResponseEntity.ok("successfully deleted");
		} catch (Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
