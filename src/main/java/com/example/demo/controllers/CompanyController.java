package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Company ;
import com.example.demo.servicesInterface.CompanyService;

@RestController()
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping(path="/companies")
	public @ResponseBody ResponseEntity<?> getCompanies() {
		return new ResponseEntity<>(companyService.getCompanies(), HttpStatus.OK);
	  }
	
	@PostMapping(path="/companies")
	public @ResponseBody ResponseEntity<?> createCompany(@RequestBody Company company ) {
		companyService.createCompany(company);
	    return new ResponseEntity<>("Company is created successfully", HttpStatus.CREATED);
	}
	
	@PostMapping(path="/companies/update/{companyId}")
	public @ResponseBody ResponseEntity<?> updateCompany(@PathVariable (value = "companyId") int id,
			                                             @RequestBody Company company) {
		companyService.updateCompany(id,company);
	    return new ResponseEntity<>("Company is updated successfully", HttpStatus.OK);
	}
	
	@GetMapping(path="/companies/delete/{companyId}")
	public @ResponseBody ResponseEntity<?> deleteCompany(@PathVariable (value = "companyId") int id){
		companyService.deleteCompany(id);
		return new ResponseEntity<>("Company is deleted successfully", HttpStatus.OK);
	}
	
	
}
