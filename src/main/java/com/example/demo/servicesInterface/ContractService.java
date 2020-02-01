package com.example.demo.servicesInterface;

import java.util.List;

import com.example.demo.entities.Contract;

public interface ContractService {
	public void createContract(int employeeId,Contract contract);
	public void updateContract(int id, Contract contract);
	public void deleteContract(int employeeId, int contractId);
	public List<Contract> getContracts();
}
