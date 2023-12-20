package com.example.SpringDemoProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tests_data")
public class TestInfo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-Increment
    @Column(name = "id")
    private Long id;
	
	@Column(name = "patient_Id")
	private String patientId;
	
	@Column(name = "patient_Name")
	private String patientName;
	
    @Column(name = "test_id")
    private String testId;

    @Column(name = "test_name")
    private String testName;

    @Column(name = "description")
    private String desc;

    @Column(name = "cost_of_test")
    private int costOfTest;
	
	
	public TestInfo(Long id, String patientId, String patientName, String testId, String testName, String desc,
			int costOfTest) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.patientName = patientName;
		this.testId = testId;
		this.testName = testName;
		this.desc = desc;
		this.costOfTest = costOfTest;
	}


	public TestInfo() {
		
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPatientId() {
		return patientId;
	}


	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}


	public String getPatientName() {
		return patientName;
	}


	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}


	public String getTestId() {
		return testId;
	}


	public void setTestId(String testId) {
		this.testId = testId;
	}


	public String getTestName() {
		return testName;
	}


	public void setTestName(String testName) {
		this.testName = testName;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public int getCostOfTest() {
		return costOfTest;
	}


	public void setCostOfTest(int costOfTest) {
		this.costOfTest = costOfTest;
	}


	@Override
	public String toString() {
		return "TestInfo [id=" + id + ", patientId=" + patientId + ", patientName=" + patientName + ", testId=" + testId
				+ ", testName=" + testName + ", desc=" + desc + ", costOfTest=" + costOfTest + "]";
	}



		 
}
