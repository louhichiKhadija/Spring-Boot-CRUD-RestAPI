package com.example.demo.servicesInterface;
import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Employee;


public interface EmployeeService {
	public void createEmployee(int ComapnyId,Employee employee);
	public void updateEmployee(int EmployeeId, Employee employee);
	public void deleteEmployee(int employeeId);
	public List<Employee> getEmployees();
	public List<Employee> getEmployeesByCompany(int companyId);
	public Optional<Employee> getEmployee(int employeeId);
	public boolean found(int employeeId);
	public void addImage(int employeeId, String image);
}
