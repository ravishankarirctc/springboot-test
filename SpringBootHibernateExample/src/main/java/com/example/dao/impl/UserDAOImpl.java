package com.example.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.dao.UserDAO;
import com.example.entity.Company;
import com.example.entity.Country;
import com.example.entity.Users;

@Repository
@EnableTransactionManagement
public class UserDAOImpl implements UserDAO {

//	@Autowired
//	@Qualifier("myHibernateTemplate")
	@Resource(name="myHibernateTemplate")
	HibernateTemplate hibernateTemplate;
	
//	@Autowired
//	CacheManager cacheManager;
	
	@Override
	public Users getUsers(Long userId) {
		
		return hibernateTemplate.getSessionFactory().getCurrentSession().get(Users.class, userId);
		
	}

	@Override
	public Users saveUsers(Users users) {
		
//		int size = CacheManager.ALL_CACHE_MANAGERS.get(0)
//				  .getCache("com.example.entity.Users").getSize();
		
//		System.out.println(cacheManager.getCacheNames());
//		
		
		hibernateTemplate.getSessionFactory().getCurrentSession().saveOrUpdate(users);
		return users;
	}

	@Override
	public Company saveCompanies(Company company) {
		hibernateTemplate.getSessionFactory().getCurrentSession().saveOrUpdate(company);
		return company;
	}

	@Override
	public Country saveCountries(Country country) {
		hibernateTemplate.getSessionFactory().getCurrentSession().saveOrUpdate(country);
		return country;
	}
	
	
	//Critetia Example
	public List<Users> getAllUsers(){
		
		List<Users> usersList = new ArrayList<>();
		
		Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Users.class);
		
		usersList  = criteria.list();
		
		return usersList;
		
	}

}
