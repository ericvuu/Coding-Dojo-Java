package com.ericvuu.employeemanagementsystem.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "positions")
public class Position {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 1, max = 255)
	private String name;

	@NotNull(message = "Wage must not be blank")
	private Double wage;

	@NotNull(message = "Does this person have administrative access?")
	private Boolean privileges;

	@OneToMany(mappedBy = "position", fetch = FetchType.LAZY)
	private List<Employee> employees;

	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	public Position() {
	
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	public Double getWage() {
		return wage;
	}



	public void setWage(Double wage) {
		this.wage = wage;
	}


	public Boolean getPrivileges() {
		return privileges;
	}


	public void setPrivileges(Boolean privileges) {
		this.privileges = privileges;
	}


	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
