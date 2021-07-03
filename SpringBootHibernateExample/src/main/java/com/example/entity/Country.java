package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "COUNTRY")
@Data
public class Country {
	
	@Id
	@Column(name = "COUNTRY_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "countryIdGenerator")
	@SequenceGenerator(name = "countryIdGenerator", sequenceName = "COUNTRY_SEQ", allocationSize = 1)
	private Long id;
	
	@Column(name = "COUNTRY_NAME")
	private String countryName;
	
	@Column(name = "SHORT_NAME")
	private String shortName;
	

}
