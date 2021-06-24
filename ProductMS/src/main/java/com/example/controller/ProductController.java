/**
 * 
 */
package com.example.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ProductDetailsResponse;

/**
 * @author ravishankar9
 *
 */
@RestController
public class ProductController {
	
	Logger log = LoggerFactory.getLogger(ProductController.class);
	
	long sold;
	
	@GetMapping(value="/prod")
	public ProductDetailsResponse getOrder() {
		ProductDetailsResponse res = new ProductDetailsResponse();
		res.setProductId(UUID.randomUUID().toString());
		res.setProductName("Washing Machine");
		res.setPrice(20000d);
		res.setCount(15l - sold);
		sold ++;
		
		log.info("Product Deatils: ");
		log.info(res.toString());
		System.out.println("\n#########################\n");
		System.out.println("from Sysout: " + res.toString());
		
		//System.exit(0);
		
		return res;
	}
	
}
