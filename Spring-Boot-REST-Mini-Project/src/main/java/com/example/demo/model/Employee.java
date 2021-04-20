package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employee {
 
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String address;
	private Double salary;
}
