package com.training.domains;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@JsonIgnoreProperties
public class TestReport {

	
	private String patientName;

	@JsonIgnore
	private long reportId;

	private String report;

	private String reportType;

	public TestReport(){
		super();
	}

	public TestReport(String patientName, long reportId, String report, String reportType){
		this.patientName = patientName;
		this.reportId = reportId;
		this.report = report;
		this.reportType = reportType;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public long getReportId() {
		return reportId;
	}

	public void setReportId(long reportId) {
		this.reportId = reportId;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	
}
