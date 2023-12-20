package com.example.SpringDemoProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringDemoProject.model.TestInfo;

@Repository
public interface TestInfoRepository extends JpaRepository<TestInfo, Long> {
	
	List<TestInfo> getAllTestByPatientName(String patientName);
}
