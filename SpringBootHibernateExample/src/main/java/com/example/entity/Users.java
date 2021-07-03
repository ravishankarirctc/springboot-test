package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

import lombok.Data;

@Entity
@Table(name = "USERS")
@Data
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Users {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequenceGenerator")
	@SequenceGenerator(name = "userSequenceGenerator", sequenceName = "USER_SEQ", allocationSize = 1)
	/**
	 * @GeneratedValue : to define the type of key generation -> generator is the name for it, the same name should be there in @SequenceGenerator 
	 * @SequenceGenerator : Now we will define the Geneartor, here we want to take the sequence generator from database, so we will give the same in sequenceName as in database
	 * if we give the other name then Hibernate creates it own Sequence Generator.
	 *  
	 * allocationSize: if allocation size is 10 that means, hibernate gets the next sequence number (primary key) from the table
	 * and will increase sequence by one(or mentioned in DB sequence- INCREMENT BY). Hibernate will increase the sequence internally up to +10 only then will go to DB and then get the next sequence, this is to save the DB call for sequence generation.
	 * 
	 * But there is issue with "allocationSize" if more than one Entities are created for same table in multiple apps then it may conflict with duplication key.
	 * 
	 *  So we have used allocationSize = 1, so that hibernate always gets the next sequence from the database sequence  
	 */
	private Long id;
	

	//@Column(name = "") : as it is a many to one mapping so no direct column name mapping
	
	@ManyToOne //Many users can have one/same Company. "Many" is pointing to current entity and "One" is pointing to written object below 
	@JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID")
	private Company company;
	
	@ManyToOne //Many users can have one/same country
	@JoinColumn(name="COUNTRY_ID", referencedColumnName = "COUNTRY_ID")
	private Country country;
	
	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastname;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "CITY")
	private String city;
	
	
	
}
