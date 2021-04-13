package com.ericvuu.relationships.services;

import java.util.List;

import com.ericvuu.relationships.models.License;
import com.ericvuu.relationships.repositories.LicenseRepository;

public class LicenseService {
	private final LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public List<License> allLicenses() {
		return licenseRepository.findAll();
	}
	
	public License createLicense(License license) {
		return licenseRepository.save(license);
	}
}
