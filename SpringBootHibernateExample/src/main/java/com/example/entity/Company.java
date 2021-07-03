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
@Table(name = "COMPANY")
@Data
public class Company {
	
	@Id
	@Column(name="company_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "companyIdGenerator")
	@SequenceGenerator(name = "companyIdGenerator", sequenceName = "COMPANY_SEQ", allocationSize = 1)
	private Long id;
	
	@Column(name = "COMPANY_NAME")
	private String companyName;
	
	@Column(name = "ADDRESS")
	private String address;
	
	
	
	
}
