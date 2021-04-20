package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/employee")
@Api(description = "Employee CRUD operations API's")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	@ApiOperation("Fetch all the Employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}
	
	@PostMapping
	@ApiOperation("Add Employee data")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		Integer id = employeeService.addEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body("Employee '" + id + "' added sucessfully");
	}

	@PatchMapping("/{id}")
	@ApiOperation("Update Employee for specified id")
	public ResponseEntity<String> updateEmployee(@RequestParam Integer id, @RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
		return ResponseEntity.status(HttpStatus.RESET_CONTENT).body("Employee '" + id + "' updated sucessfully");
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation("Delete Employee for specified id")
	public ResponseEntity<String> deletedEmployee(@RequestParam Integer id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.status(HttpStatus.OK).body("Employee '" + id + "' deleted sucessfully");
	}
	
}
