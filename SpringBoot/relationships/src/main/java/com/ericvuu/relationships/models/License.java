package com.ericvuu.relationships.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="licenses")
public class License {
	int licensesCreated;

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 private String number;
	 
	 @DateTimeFormat(pattern = "MM/dd/yyyy")
	 private Date expirationDate;
	 
	 private String state;
	 
	 @Column(updatable=false)
	 private Date createdAt;
	 
	 private Date updatedAt;
	 
	 @OneToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="person_id")
	 private Person person;
	 
	 public License() {
		 licensesCreated++;
	 }
	 
	public License(Long id, Date expirationDate, String state, Person person) {
		this.id = id;
		this.number = generateLicenseNumber();
		this.expirationDate = expirationDate;
		this.state = state;
		this.person = person;
		licensesCreated++;
	}
	
	private String generateLicenseNumber() {
		String licenseId = "";
		return licenseId;
	}
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public Date getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
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
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	 
	@PrePersist
	protected void onCreate(){
	    this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	}

}
