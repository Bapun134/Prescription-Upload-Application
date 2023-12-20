package com.example.SpringDemoProject.controller;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.SpringDemoProject.model.TestInfo;
import com.example.SpringDemoProject.repository.TestInfoRepository;

import java.io.IOException;
import java.util.List;


import javax.servlet.http.HttpSession;

@Controller
public class FileUploadController {

    @Autowired
    private TestInfoRepository testInfoRepository;
    
    @Autowired
    HttpSession session;
	
	
	
    //GET
    @GetMapping("/upload")
    public String showUploadPage() {
    	
    	String pName = (String) session.getAttribute("loggedInUserName");
		 
		 if (pName == null) {
			    // Handle scenario where user is not logged in
			    return "redirect:/login"; 
		}
		 else {
			 return "uploadPage";
		 }

    }

    //POST
    @PostMapping("/upload")
    public String extractAndDisplay(@RequestParam("file") MultipartFile file, Model model) {

        if (file.isEmpty()) {
            model.addAttribute("extractionError", "No file provided");
            return "uploadPage";
        }

        if (MediaType.APPLICATION_PDF_VALUE.equals(file.getContentType())) {
            try {
                PDDocument document = PDDocument.load(file.getInputStream());
                PDFTextStripper pdfTextStripper = new PDFTextStripper();
                pdfTextStripper.setSortByPosition(true);
                pdfTextStripper.setStartPage(1);
                pdfTextStripper.setEndPage(document.getNumberOfPages());
                String pdfContent = pdfTextStripper.getText(document);
                document.close();

                String[] lines = pdfContent.split("\\r?\\n");
                boolean headerSkipped = false;
                
                for (String line : lines) {
                	
                	if (!headerSkipped) {
                        // Check if the current line matches the header format
                        if (line.startsWith("Patient Name Patient ID Test ID Test Name Description Amount")) {
                            headerSkipped = true;
                            continue; // Skip this line and move to the next
                        }
                    }
                	
                    String[] rowData = line.split("\\s+(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                    if (rowData.length >= 7) { // Check if the row contains enough columns
                        String patientName = rowData[0] + " " + rowData[1]; // Concatenate first and last name
                        String patientId = rowData[2];
                        String testId = rowData[3];
                        String testName = rowData[4];
                        String description = rowData[5].replace("_", " "); // Replace underscores with spaces in description
                        int amount = Integer.parseInt(rowData[6].replaceAll("[^\\d]", ""));


                        // Create TestInfo object and save it to the repository
                        TestInfo testInfo = new TestInfo();
                        testInfo.setTestId(testId);
                        testInfo.setTestName(testName);
                        testInfo.setPatientId(patientId);
                        testInfo.setPatientName(patientName);
                        testInfo.setDesc(description);
                        testInfo.setCostOfTest(amount);

                        testInfoRepository.save(testInfo);
                    } else {
                        // Log or handle incomplete rows if needed
                    }
                }

                model.addAttribute("success", "Data Uploaded Successfully");
                return "uploadPage";
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("extractionError", "An error occurred during processing");
                return "uploadPage";
            }
        } else {
            model.addAttribute("extractionError", "Unsupported file type");
            return "uploadPage";
        }
    }


    
    
	 //Details
    
	 @RequestMapping("/details")
	 public String showDetailsPage(ModelMap model) {
		 
		String pName = (String) session.getAttribute("loggedInUserName");
		
		 if (pName == null) {
			    // Handle scenario where user is not logged in
			    return "redirect:/login"; 
		}else {
			//getting testData info based on pName
			List<TestInfo> testData = testInfoRepository.getAllTestByPatientName(pName);
			model.addAttribute("testInfoList",testData);
				 
			return "detailsPage";
		}
		 
		 
	 }
	
    
}
