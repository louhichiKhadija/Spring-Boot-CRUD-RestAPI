package com.example.demo.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Mission;

@Repository("missionRepository")
public interface MissionRepository extends JpaRepository<Mission, Integer>{
	
	/*why we should write here ( it's without any code or traitement just one ligne
	how it understand it */
	List<Mission> findByEmployeeId(Integer employeeId);
	List<Mission> findByIdAndEmployeeId(Integer missionId,Integer employeeId );
}
