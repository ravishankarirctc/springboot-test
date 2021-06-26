/**
 * 
 */
package com.example.controller;

import java.util.Arrays;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Response;

/**
 * @author ravishankar
 *
 */
@RestController
public class MyController {
	
//	@Value("${DB-PASSWORD}")
//    private String dbPassword;
//	
//	@Value("${OKTA-API-KEY}")
//    private String oktaApiKey;
	
	Logger log = LoggerFactory.getLogger(MyController.class);
	Long srNo = 0l;

	@GetMapping(value="/order")
	public Response getOrder() {
		Response res = new Response();
		res.setOrderId(UUID.randomUUID().toString());
		res.setProductList(Arrays.asList("Tea", "Rice", "Sugar", "Milk"));
		res.setAmount(200.50);
		res.setCustomerName("Ravi Shankar");
		
		res.setMessage("SALE!!!!!!!!!!!!!!!!!!!");
		res.setSrNo(srNo++);
		
//		res.setDbPassword(dbPassword);
//		res.setOktaApiKey(oktaApiKey);
//		
		log.info("Order Deatils: ");
		log.info(res.toString());
		
		System.out.println("from Sysout: " + res.toString());
		
		//System.exit(0);
		
		return res;
	}
	
}
