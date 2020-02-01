package com.example.demo.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Company;
import com.example.demo.repositories.CompanyRepository;
import com.example.demo.servicesInterface.CompanyService;

@Transactional
@Service("companyService")
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public void createCompany(Company company) {
		companyRepository.save(company);
	}

	@Override
	public void updateCompany(int companyId, Company company) {
		Optional<Company> oldCompany= companyRepository.findById(companyId);
		oldCompany.get().setAdress(company.getAdress());
		oldCompany.get().setName(company.getName());
		oldCompany.get().setType(company.getType());
		companyRepository.save(oldCompany.get());
	}
	
	@Override
	public void deleteCompany(int companyId) {
		companyRepository.deleteById(companyId);
	}
	
	@Override
	public List<Company> getCompanies(){
		return companyRepository.findAll();
	}
	
	
	
	
}
