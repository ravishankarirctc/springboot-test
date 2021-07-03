package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.CompanyVO;
import com.example.model.CountryVO;
import com.example.model.UsersVO;
import com.example.service.UserService;

@RestController
public class MyController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/users/{userId}")
	public UsersVO getUsers(@PathVariable Long userId) {
		
		return userService.getUsers(userId);
		
	}
	
	@PostMapping(value = "/users")
	public UsersVO saveUsers(@RequestBody UsersVO usersVO) {
		
		return userService.saveUsers(usersVO);
	}
	
	
	@PostMapping(value = "/companies")
	public CompanyVO saveCompanies(@RequestBody CompanyVO companyVO) {
		
		return userService.saveCompanies(companyVO);
	}
	
	@PostMapping(value = "/countries")
	public CountryVO saveCountries(@RequestBody CountryVO countryVO) {
		
		return userService.saveCountries(countryVO);
	}
}
