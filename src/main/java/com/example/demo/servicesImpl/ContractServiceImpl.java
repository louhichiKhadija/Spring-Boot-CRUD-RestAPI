package com.example.demo.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Contract;
import com.example.demo.entities.Employee;
import com.example.demo.repositories.ContractRepository;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.servicesInterface.ContractService;


@Transactional
@Service("contractService")
public class ContractServiceImpl implements ContractService {

	@Autowired
	private ContractRepository contractRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void createContract(int employeeId,Contract contract) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		employee.get().setContract(contract);
		employeeRepository.save(employee.get());
		//contract.setEmployee(employee.get());
	}

	@Override
	public void updateContract(int contractId, Contract contract) {
		Optional<Contract> oldContract= contractRepository.findById(contractId);
		oldContract.get().setType(contract.getType());
		oldContract.get().setPeriode(contract.getPeriode());
		contractRepository.save(oldContract.get());
	}
	
	@Override
	public void deleteContract( int employeeId, int contractId) {
		Optional<Employee> emp=employeeRepository.findById(employeeId);
		emp.get().setContract(null);
		employeeRepository.saveAndFlush(emp.get());
		contractRepository.deleteById(contractId);
		
	}
	
	@Override
	public List<Contract> getContracts(){
		return contractRepository.findAll();
	}
}
