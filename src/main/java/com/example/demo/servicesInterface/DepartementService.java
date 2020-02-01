package com.example.demo.servicesInterface;

import java.util.List;

import com.example.demo.entities.Departement;

public interface DepartementService {

	public void createDepartement(int companyId,Departement departement);
	public void updateDepartement(int id, Departement departement);
	public void deleteDepartement(int companyId,int departementId);
	public List<Departement> getDepartements();
	public void addDepartement(int companyId,int departementId);
}
