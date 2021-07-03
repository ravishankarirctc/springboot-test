package com.example.model;

import lombok.Data;

@Data
public class UsersVO {

	private Long id;

	private Long companyId;

	private Long countryId;

	private String firstName;

	private String lastname;

	private String email;

	private String city;
	

}
