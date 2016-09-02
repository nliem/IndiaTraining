package com.training.domains;

import java.util.HashMap;
import java.util.List;

public class Doctor {
	
	private int doctorCode;
	private String doctorName;
	private String specialization;
	
	private Patient patient;
	private List<Patient> patientList;
	private HashMap<String, String> supportStaff;
	
	public HashMap<String, String> getSupportStaff() {
		return supportStaff;
	}

	public void setSupportStaff(HashMap<String, String> supportStaff) {
		this.supportStaff = supportStaff;
	}

	public Doctor(){
		super();
	}
	
	public Doctor(int doctorCode, String doctorName, String specialization){
		this.doctorCode = doctorCode;
		this.doctorName = doctorName;
		this.specialization = specialization;
	}

	public int getDoctorCode() {
		return doctorCode;
	}

	public void setDoctorCode(int doctorCode) {
		this.doctorCode = doctorCode;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	public Patient getPatient(){
		return patient;
	}
	
	public void setPatient(Patient patient){
		this.patient = patient;
	}
	
	public List<Patient> getPatientList(){
		return patientList;
	}
	
	public void setPatientList(List<Patient> patientList){
		this.patientList = patientList;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("------------------------\n");
		sb.append("Doctor #:\t" + this.doctorCode).append("\n");
		sb.append("Doctor Name:\t" + this.doctorName).append("\n");
		sb.append("Specialization:\t" + this.specialization).append("\n");
		sb.append("Patient:\n" + this.patient).append("\n");
		sb.append("Patient List:\n" + this.patientList).append("\n");
		sb.append("Support Staff:\n" + this.supportStaff).append("\n");
		sb.append("------------------------\n");
		return sb.toString();
	}

}
