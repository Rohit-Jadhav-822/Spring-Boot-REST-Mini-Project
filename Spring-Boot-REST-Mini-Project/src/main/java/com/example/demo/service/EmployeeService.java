package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {

	public Integer addEmployee(Employee employee);
	public Integer updateEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public void deleteEmployee(Integer id);
}
