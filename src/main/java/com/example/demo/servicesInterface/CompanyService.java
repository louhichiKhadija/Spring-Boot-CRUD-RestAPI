package com.example.demo.servicesInterface;

import java.util.List;

import com.example.demo.entities.Company;

public interface CompanyService {
	public void createCompany(Company company);
	public void updateCompany(int companyId, Company company);
	public void deleteCompany(int companyId);
	public List<Company> getCompanies();
}
