package com.example.SpringDemoProject.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.SpringDemoProject.model.User;
import com.example.SpringDemoProject.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	HttpSession session;
	
	
	//login
	
    @GetMapping("/login")
	public String sayLoginPage() {
		return "loginPage";
	}
    
    @PostMapping("/login")
	public String gotoWelcomePage(@RequestParam("email") String email, @RequestParam("password") String password ,
												RedirectAttributes redirectAttributes) {
    	
    	User user = userRepository.findByEmail(email);
    	
    	if (user != null && user.getPassword().equals(password)) {
    		
    		String fullName = user.getfName() + " " + user.getlName();
            session.setAttribute("loggedInUserName", fullName);  // Store the fullName in session
            session.setAttribute("loggedInUserEmail", user.getEmail());  // Store the email in session
            
            return "redirect:/welcome";
            
        } else if (user != null && !user.getPassword().equals(password)) {
        	
        	redirectAttributes.addFlashAttribute("error", "Incorrect password");
            return "redirect:/login";
            
        } else {
        	
        	redirectAttributes.addFlashAttribute("error", "User not found");
            return "redirect:/login";
        }
	}
    
    
    //Register
	
	 @GetMapping("/register")
    public String showRegisterPage() {
        return "registerPage";
    }
	
	 
	@PostMapping("/register")
	public String createNewUser(User user,RedirectAttributes redirectAttributes) {
		
		//check if email is already registered or not
		String checkEmail = user.getEmail();
		if(userRepository.findByEmail(checkEmail) != null) {
	        redirectAttributes.addFlashAttribute("error", "Email already exists");
	        return "redirect:/register";
	    }
		
		try {
	        userRepository.save(user);
	        return "redirect:login";
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Error creating user: " + e.getMessage();
	    }
	}

	
	
	//welcome
	
	 @RequestMapping("/welcome")
	 public String showWelcomePage() {
	     return "welcomePage";
	 }
	 
	 
	//logout
	
	 @RequestMapping("/logout")
	 public String logout(RedirectAttributes redirectAttributes, HttpServletResponse response) {
		 
	     session.invalidate();
	     
	     // Prevent caching
	     response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	     response.setHeader("Pragma", "no-cache");
	     response.setHeader("Expires", "0");
	     
	     return "redirect:/login";
	 }
	
	
	
}
