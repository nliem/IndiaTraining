package com.training.domains;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Patient {
	
	private static final Logger log = Logger.getLogger("myLogger");
	private long patientId;
	private String patientName;
	private String patientType;
	
	public Patient(){
		super();
		log.log(Level.INFO, "Patient initialized (0 Arg Constructor)");
	}
	
	public Patient(long patientId, String patientName, String patientType){
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientType = patientType;
		log.log(Level.INFO, "Patient initialized (Parameterized Constructor)");
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
		log.log(Level.INFO, "patientId set.");
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
		log.log(Level.INFO, "patientName set.");
	}

	public String getPatientType() {
		return patientType;
	}

	public void setPatientType(String patientType) {
		this.patientType = patientType;
		log.log(Level.INFO, "patientType set");
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Patient #:\t" + this.patientId).append("\n");
		sb.append("Patient Name:\t" + this.patientName).append("\n");
		sb.append("Patient Type:\t" + this.patientType).append("\n");
		return sb.toString();
	}
	
}
