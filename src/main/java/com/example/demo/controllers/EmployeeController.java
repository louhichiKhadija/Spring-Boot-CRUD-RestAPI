package com.example.demo.controllers;

import com.example.demo.entities.Employee;
import com.example.demo.exceptions.ObjectNotFoundException;
import com.example.demo.servicesInterface.EmployeeService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController()
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping(path="/employees")
	public @ResponseBody ResponseEntity<?> getEmployees() {
		return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
	  }
	@GetMapping(path="/company/{companyId}/employees")
	public @ResponseBody ResponseEntity<?> getEmployeesByCompany(@PathVariable (value = "companyId") int id) {
		
		return new ResponseEntity<>(employeeService.getEmployeesByCompany(id), HttpStatus.OK);
	}
	
	@PostMapping(path="company/{companyId}/addEmployee")
	public @ResponseBody ResponseEntity<?> createEmployee(@PathVariable (value = "companyId") int companyId,
			                                         @RequestBody  @Valid Employee employee) {
		employeeService.createEmployee(companyId,employee);
	    return new ResponseEntity<>("Employee is created successfully", HttpStatus.CREATED);
	}
	
	
	@PostMapping(path="/employees/update/{employeeId}")
	public @ResponseBody ResponseEntity<?> updateEmployee(@PathVariable (value = "employeeId") int id,
			                                              @RequestBody Employee employee) {
		
		if(!employeeService.found(id)) {
			throw new ObjectNotFoundException("employee with id :"+ id+" not found");
		}
		employeeService.updateEmployee(id,employee);
	    return new ResponseEntity<>("Employee is updated successfully", HttpStatus.OK);
	}
	
	@GetMapping(path="/employees/delete/{employeeId}")
	public @ResponseBody ResponseEntity<?> deleteEmployee(@PathVariable (value = "employeeId") int id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>("Employee is deleted successfully", HttpStatus.OK);
	}
	
	
	
}
