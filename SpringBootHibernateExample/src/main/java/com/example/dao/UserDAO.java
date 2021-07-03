package com.example.dao;

import com.example.entity.Company;
import com.example.entity.Country;
import com.example.entity.Users;

public interface UserDAO {

	public Users getUsers(Long userId);
	
	public Users saveUsers(Users users);

	public Company saveCompanies(Company company);

	public Country saveCountries(Country country);
}
