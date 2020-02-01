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

import com.example.demo.entities.Contract;
import com.example.demo.servicesInterface.ContractService;

@RestController()
public class ContractController {
	@Autowired
	private ContractService contractService;
	
	@GetMapping("/contracts")
	public @ResponseBody ResponseEntity<?>  getAllContracts() {
		return new ResponseEntity<>(contractService.getContracts(),HttpStatus.OK);
    	}
	
	@PostMapping("/employees/{employeeId}/addContract")
	public @ResponseBody ResponseEntity<?> createContract(@PathVariable (value = "employeeId") int employeeId,
			                                              @RequestBody Contract contract){
		contractService.createContract(employeeId,contract);
		return new ResponseEntity<>("Contract is created successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("contracts/{contractId}/update")
	public @ResponseBody ResponseEntity<?> updateContract(@PathVariable (value="contractId") int contractId,
			                                              @RequestBody Contract contract){
		contractService.updateContract(contractId, contract);
		return new ResponseEntity<>("Contract is updated successfully",HttpStatus.OK);
	}
	
	@PostMapping("employees/{employeeId}/contracts/{contractId}/delete")
	public @ResponseBody ResponseEntity<?> deleteContract(@PathVariable (value="employeeId") int employeeId,
			                                               @PathVariable (value="contractId") int contractId)
	{
		contractService.deleteContract(employeeId, contractId);
		return new ResponseEntity<>("Contract is deleted successfully",HttpStatus.OK);
	}
}
