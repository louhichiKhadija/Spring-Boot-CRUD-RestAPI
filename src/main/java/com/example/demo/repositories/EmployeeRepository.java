package com.example.demo.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Employee;

@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findByCompanyId(Integer companyId);
}
