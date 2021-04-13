package com.ericvuu.driverslicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ericvuu.driverslicense.models.License;
import com.ericvuu.driverslicense.repositories.LicenseRepository;

@Service
public class LicenseService {
	private static String licenseNumber = "0000";
	
	private final LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public List<License> allLicenses() {
		return licenseRepository.findAll();
	}
	
	public void createLicense(License license) {
		license.setNumber(licenseNumber);
		licenseNumber = String.format("%06d", Integer.parseInt(licenseNumber) + 1);
		licenseRepository.save(license);
	}
	
	public Optional<License> getLicense(Long id) {
        return licenseRepository.findById(id);
    }
	

}
