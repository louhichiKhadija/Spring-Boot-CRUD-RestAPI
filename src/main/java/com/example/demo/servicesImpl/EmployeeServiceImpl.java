package com.example.demo.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Company;
import com.example.demo.entities.Employee;
import com.example.demo.repositories.CompanyRepository;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.servicesInterface.EmployeeService;



@Transactional
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public Optional<Employee> getEmployee(int employeeId) {
		return employeeRepository.findById(employeeId);
	}
	
	@Override
	public void createEmployee(int companyId,Employee employee) {
		Optional<Company> company=companyRepository.findById(companyId);
		employee.setCompany(company.get());
		employeeRepository.save(employee);
	}
	
	@Override
	public void updateEmployee(int id, Employee employee) {
		Optional<Employee> emp=employeeRepository.findById(id);
		emp.get().setName(employee.getName());
		emp.get().setAge(employee.getAge());
		emp.get().setAdress(employee.getAdress());
		employeeRepository.save(emp.get());
	}
	
	@Override 
	public void deleteEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);
	}
	
	@Override
	public List<Employee> getEmployees(){
		return employeeRepository.findAll();
	}
	
	@Override
	public List<Employee> getEmployeesByCompany(int companyId){
		return employeeRepository.findByCompanyId(companyId);
	}
	
	@Override
	public boolean found(int employeeId) {
		return employeeRepository.existsById(employeeId);
	}
	
	@Override
	public void addImage(int employeeId, String image) {
		Employee employee=employeeRepository.findById(employeeId).get();
		employee.setImage(image);
		employeeRepository.save(employee);
	}
	
}
