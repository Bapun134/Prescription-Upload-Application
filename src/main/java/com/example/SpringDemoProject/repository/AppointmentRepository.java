package com.example.SpringDemoProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringDemoProject.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	
	List<Appointment> findAllByUserEmail(String userEmail);
}
