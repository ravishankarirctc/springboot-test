/**
 * 
 */
package com.example.model;

import lombok.Data;

/**
 * @author ravishankar9
 *
 */
@Data
public class ProductDetailsResponse {

	private String productId;
	private String productName;
	private Double price;
	private Long count;
	
}
