package com.example.demo.entities;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Employee{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	@Column(nullable=true)
	@Min(value=18, message="Age must be at least 18 years old")
	private int age;
	
	private String adress;
	
	private String image;
	
	@Email(message = "email should be a valid email")
	private String email;
	


	@OneToMany(fetch = FetchType.EAGER, mappedBy ="employee", orphanRemoval=true,
			cascade = { CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.REMOVE})
	private List<Mission> missions= new ArrayList<Mission>();
	
	@OneToOne(fetch = FetchType.EAGER,cascade = { CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.REMOVE})
	private Contract contract;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Company company;
	 
	 
	public Employee(){
		
	}
	
	public Employee(int id, String name, int age, String adress) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.adress = adress;
	}
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	@JsonIgnore
	public List<Mission> getMissions() {
		return missions;
	}
	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}
	
	@JsonIgnore
	public Contract getContract() {
		return contract;
	}
	
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	@JsonIgnore
	public Company getCompany() {
		return company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
	
	
	
	

}
