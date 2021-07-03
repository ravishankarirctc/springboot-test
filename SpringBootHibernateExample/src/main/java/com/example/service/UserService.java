package com.example.service;

import com.example.model.CompanyVO;
import com.example.model.CountryVO;
import com.example.model.UsersVO;

public interface UserService {

	public UsersVO getUsers(Long userId);
	
	public UsersVO saveUsers(UsersVO usersVO);

	public CompanyVO saveCompanies(CompanyVO companyVO);

	public CountryVO saveCountries(CountryVO countryVO);

}
