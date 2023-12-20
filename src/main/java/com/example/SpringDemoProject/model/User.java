package com.example.SpringDemoProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users_data")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Auto-Increment
    @Column(name = "id")
    private Long id;

    @Column(name = "f_name")
    private String fName;

    @Column(name = "l_name")
    private String lName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "gender") 
    private Character gender; 

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;

	public User(Long id, String fName, String lName, String email, Character gender, String phone,String password) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.gender = gender;
		this.phone = phone;
		this.password = password;	}
	
	public User() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", gender=" + gender
				+ ", phone=" + phone + ", password=" + password + "]";
	}

    
    
}
