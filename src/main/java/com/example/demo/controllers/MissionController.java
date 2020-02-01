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

import com.example.demo.entities.Mission;
import com.example.demo.servicesInterface.MissionService;

@RestController
public class MissionController {
	
	@Autowired
	private MissionService missionService;

	
	
	@GetMapping("/employees/{employeeId}/missions")
	public @ResponseBody ResponseEntity<?>  getAllEmployees(@PathVariable (value = "employeeId") int employeeId) {
		return new ResponseEntity<>(missionService.getMissions(employeeId),HttpStatus.OK);
    	}
	
	@PostMapping("/employees/{employeeId}/addNewMission")
	public ResponseEntity<?> createMission(@PathVariable (value = "employeeId") int employeeId, 
			                               @RequestBody Mission mission){
		missionService.createMission(employeeId, mission);
		return new ResponseEntity<>("Mission is created successfully", HttpStatus.CREATED);
	}
	
	@PostMapping("/employees/{employeeId}/missions/update/{missionId}")
	public ResponseEntity<?> updateMission(@PathVariable (value = "employeeId") int employeetId,
			                               @PathVariable (value = "missionId") int missionId,
			                               @RequestBody Mission mission){
		missionService.updateMission(missionId, mission);
		return new ResponseEntity<>("Mission is updated successfully", HttpStatus.OK);
	}
	

	@GetMapping("/employees/{employeeId}/missions/delete/{missionId}")
	public ResponseEntity<?> deleteMission(@PathVariable (value = "employeeId") int employeeId,
			                               @PathVariable (value = "missionId") int missionId){
		missionService.deleteMission(missionId);
		return new ResponseEntity<>("Mission is deleted successfully", HttpStatus.OK);
	}
	
		

}

	