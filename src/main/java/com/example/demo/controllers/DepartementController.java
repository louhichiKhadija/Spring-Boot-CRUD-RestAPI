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

import com.example.demo.entities.Departement;
import com.example.demo.servicesInterface.DepartementService;

@RestController()
public class DepartementController {
	
	@Autowired
	private DepartementService departementService;
	
	@GetMapping("/departements")
	public @ResponseBody ResponseEntity<?> getDepartements() {
		return new ResponseEntity<>(departementService.getDepartements(),HttpStatus.OK);
    	}
	
	@PostMapping("/companies/{companyId}/addDepartement")
	public @ResponseBody ResponseEntity<?> addDepartement(@PathVariable (value = "companyId") int companyId,
			                                               @RequestBody Departement departement){
		departementService.createDepartement(companyId,departement);
		return new ResponseEntity<>("Departement is created successfully", HttpStatus.CREATED);}

	@PostMapping("/companies/{companyId}/addDepartement/{departementId}")
	public @ResponseBody ResponseEntity<?> addExistenDepartement(@PathVariable (value = "companyId") int companyId,
			                                               @PathVariable (value="departementId") int departementId){
		departementService.addDepartement(companyId,departementId);
		return new ResponseEntity<>("Departement is created successfully", HttpStatus.CREATED);}
	
	
	@PostMapping("/departements/{departementId}/update")
	public @ResponseBody ResponseEntity<?> updateDepartement(@PathVariable (value = "departementId") int departementId,
			                                      @RequestBody Departement departement){
		departementService.updateDepartement(departementId, departement);
		return new ResponseEntity<>("Departement is updated successfully", HttpStatus.OK);
	}
	
	@GetMapping("companies/{companyId}/departements/{departementId}/delete")
	public @ResponseBody ResponseEntity<?> deleteDepartement(@PathVariable (value = "companyId") int companyId,
			                                                 @PathVariable (value = "departementId") int departementId){
		
		departementService.deleteDepartement(companyId,departementId);
		return new ResponseEntity<>("Departement"+departementId+"is deleted successfully from company"+companyId,HttpStatus.OK);
	}
}
