package com.example.SpringDemoProject.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.SpringDemoProject.model.Appointment;
import com.example.SpringDemoProject.model.TestInfo;
import com.example.SpringDemoProject.repository.AppointmentRepository;
import com.example.SpringDemoProject.repository.TestInfoRepository;

@Controller
public class AppointmentController {

	@Autowired
	private TestInfoRepository testInfoRepository;
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
    @Autowired
    HttpSession session;
    
	
	 @GetMapping("/appointment")
	 public String showScheduleAppointmentPage(ModelMap model,RedirectAttributes redirectAttributes) {
		 
		String pName = (String) session.getAttribute("loggedInUserName");
		
		 if (pName == null) {
			    // Handle scenario where user is not logged in
			    return "redirect:/login"; 
		}else {
			//getting testData info based on pName
			List<TestInfo> testData = testInfoRepository.getAllTestByPatientName(pName);

			// Calculate total amount
            int totalAmount = testData.stream()
				            		.mapToInt(test -> test.getCostOfTest())
				                    .sum();
            model.addAttribute("totalAmount", totalAmount);
            
			return "appointmentPage";
		}
		 
		 
	 }
	 

	 @PostMapping("/appointment")
	 public String createNewAppointment(Appointment appointment,Model model) {
		 try {
		        appointmentRepository.save(appointment);
		        model.addAttribute("successMessage", "Appointment scheduled successfully!");
		        return "appointmentPage";
		    } 
		 catch (Exception e) {
		        // Handle exceptions or errors if needed
		    	model.addAttribute("errorMessage", "Failed to schedule appointment!");
		    	return "appointmentPage";
		    }
 
		 
	 }
	 
	 
	 //for checking the scheduled appointments.
	 @GetMapping("/appointmentDetails")
	 public String showAppointmentDetailsPage(Model model){
		 
		 String pEmail = (String) session.getAttribute("loggedInUserEmail");
		 
		 List<Appointment> appointmentDetails = appointmentRepository.findAllByUserEmail(pEmail);
		 
		 model.addAttribute("appointmentDetails", appointmentDetails);
		 
		 return "appointmentDetailsPage";
	 }
	 
	 
	 
	 
	 	 
	 
}
