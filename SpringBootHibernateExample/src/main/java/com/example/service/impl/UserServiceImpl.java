package com.example.service.impl;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UserDAO;
import com.example.entity.Company;
import com.example.entity.Country;
import com.example.entity.Users;
import com.example.model.CompanyVO;
import com.example.model.CountryVO;
import com.example.model.UsersVO;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDao;

	@Override
	@Transactional
	public UsersVO getUsers(Long userId) {
		
		UsersVO usersVO = new UsersVO();
		
		BeanUtils.copyProperties(userDao.getUsers(userId), usersVO);
		
		return usersVO;
		
		
	}

	@Override
	@Transactional
	public UsersVO saveUsers(UsersVO usersVO) {
		
		UsersVO usersVOResponse = new UsersVO();
		Users users = new Users();
		
		BeanUtils.copyProperties(usersVO, users);
		
		Company company = new Company();
		company.setId(usersVO.getCompanyId());
		
		Country country = new Country();
		country.setId(usersVO.getCountryId());
		
		users.setCompany(company);
		users.setCountry(country);
		
		BeanUtils.copyProperties(userDao.saveUsers(users), usersVOResponse);
		
		return usersVOResponse;
	}

	@Override
	@Transactional
	public CompanyVO saveCompanies(CompanyVO companyVO) {
		
		CompanyVO companyVOResponse = new CompanyVO();
		Company company = new Company();
		
		BeanUtils.copyProperties(companyVO, company);
		
		BeanUtils.copyProperties(userDao.saveCompanies(company), companyVOResponse);
		
		return companyVOResponse;
	}

	@Override
	@Transactional
	public CountryVO saveCountries(CountryVO countryVO) {
		
		CountryVO countryVOResponse = new CountryVO();
		Country country = new Country();
		
		BeanUtils.copyProperties(countryVO, country);
		
		BeanUtils.copyProperties(userDao.saveCountries(country), countryVOResponse);
		
		return countryVOResponse;
	}

}
