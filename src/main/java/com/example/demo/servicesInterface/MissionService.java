package com.example.demo.servicesInterface;
import java.util.List;
import com.example.demo.entities.Mission;


public interface MissionService {
	public void createMission(int employeeId,Mission mission);
	public void updateMission(int id, Mission mission);
	public void deleteMission(int missionId);
	public List<Mission> getMissions(int employeeId);
}
