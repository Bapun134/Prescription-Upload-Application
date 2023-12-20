package com.example.SpringDemoProject.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="appointment_data")
public class Appointment {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String userName;
	private String userEmail;
	private String userPhone;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate scheduleDate;
	
    private int totalAmount;
    
    
	public Appointment(String userName, String userEmail, LocalDate scheduleDate,String userPhone, int totalAmount) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.scheduleDate = scheduleDate;
		this.userPhone = userPhone;
		this.totalAmount = totalAmount;
	}
    
    public Appointment() {
    	
    }

    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public LocalDate getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(LocalDate scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	
	
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", userName=" + userName + ", userEmail=" + userEmail + ", userPhone="
				+ userPhone + ", scheduleDate=" + scheduleDate + ", totalAmount=" + totalAmount + "]";
	}

	

    
    
}
