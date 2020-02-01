package com.example.demo.servicesImpl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Employee;
import com.example.demo.entities.Mission;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.MissionRepository;
import com.example.demo.servicesInterface.MissionService;

@Transactional
@Service("missionService")
public class MissionServiceImpl implements MissionService {

	@Autowired
	private MissionRepository missionRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Mission> getMissions(int employeeId){
		return missionRepository.findByEmployeeId(employeeId);
	}
	
	@Override
	public void createMission(int employeeId, Mission mission) {
		Optional<Employee> empl=employeeRepository.findById(employeeId);
		mission.setEmployee(empl.get());
		missionRepository.save(mission);
	}
	
	@Override
	public void updateMission(int missionId, Mission newMission) {
		Optional<Mission> oldMission= missionRepository.findById(missionId);
		oldMission.get().setDescription(newMission.getDescription());
		missionRepository.save(oldMission.get());
	}
	

	@Override
	public void deleteMission(int missionId) {
		missionRepository.deleteById(missionId);
			
	}
	
}
