package com.codingdojo.phone;

public abstract class Phone {
    private String versionNumber;
    private int batteryPercentage;
    private String carrier;
    private String ringTone;
    public Phone(String versionNumber, int batteryPercentage, String carrier, String ringTone){
        this.versionNumber = versionNumber;
        this.batteryPercentage = batteryPercentage;
        this.carrier = carrier;
        this.ringTone = ringTone;
    }
    // abstract method. This method will be implemented by the subclasses
    public abstract void displayInfo();
    
    // getters and setters
    public String getVersionNumber() {
    	return versionNumber;
    }
    
    public void setVersionNumber(String versionNumber) {
    	this.versionNumber = versionNumber;
    }
    
    public int getbatteryPercentage() {
    	return batteryPercentage;
    }
    
    public void setbatteryPercentage(int batteryPercentage) {
    	this.batteryPercentage = batteryPercentage;
    }
    
    public String getCarrier() {
    	return carrier;
    }
    
    public void setCarrier(String carrier) {
    	this.carrier = carrier;
    }
    
    public String getRingTone() {
    	return ringTone;
    }
    
    public void setRingTone(String ringTone) {
    	this.ringTone = ringTone;
    }
}