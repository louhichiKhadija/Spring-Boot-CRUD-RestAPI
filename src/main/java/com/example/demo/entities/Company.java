package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String type;
	private String adress;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy ="company", orphanRemoval=true ,
			cascade = { CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.REMOVE})
	private List<Employee> employees=new ArrayList<Employee>();
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "company_departement",
    joinColumns = @JoinColumn(name = "company_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "departement_id", referencedColumnName = "id"))
	private List<Departement> departements=new ArrayList<Departement>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	@JsonIgnore
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	@JsonIgnore
	public List<Departement> getDepartements() {
		return departements;
	}
	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}
	
	
	
}
