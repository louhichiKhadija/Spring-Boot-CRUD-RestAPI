package com.example.demo.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Company;
import com.example.demo.entities.Departement;
import com.example.demo.repositories.CompanyRepository;
import com.example.demo.repositories.DepartementRepository;
import com.example.demo.servicesInterface.DepartementService;

@Transactional
@Service("deratemntService")
public class DepartementServiceImpl implements DepartementService{
	@Autowired
	private DepartementRepository departementRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	
	@Override
	public void createDepartement(int companyId,Departement departement) {
		Company company=companyRepository.findById(companyId).get();
		List<Company> companies= departement.getCompanies();
		companies.add(company);
		departement.setCompanies(companies);
		departementRepository.save(departement);
		List<Departement> departements=company.getDepartements();
		departements.add(departement);
		company.setDepartements(departements);
		companyRepository.save(company);
	}
	
	@Override
	public void addDepartement(int companyId,int departementId) {
		Company company=companyRepository.findById(companyId).get();
		Departement departement= departementRepository.findById(departementId).get();
		List<Company> companies= departement.getCompanies();
		companies.add(company);
		departement.setCompanies(companies);
		departementRepository.save(departement);
		List<Departement> departements=company.getDepartements();
		departements.add(departement);
		company.setDepartements(departements);
		companyRepository.save(company);
		
	}

	@Override
	public void updateDepartement(int departementId, Departement departement) {
		Departement dep= departementRepository.findById(departementId).get();
		dep.setName(departement.getName());
		dep.setSpeciality(departement.getSpeciality());
		departementRepository.save(dep);
		
	}
	
	@Override
	public void deleteDepartement(int companyId,int departementId) {
		Company company=companyRepository.findById(companyId).get();
		Departement dep=departementRepository.findById(departementId).get();
		dep.getCompanies().remove(company);
		companyRepository.save(company);
		company.getDepartements().remove(dep);
		departementRepository.save(dep);
		
	}
	
	@Override
	public List<Departement> getDepartements(){
		return departementRepository.findAll();
	}
	

}
