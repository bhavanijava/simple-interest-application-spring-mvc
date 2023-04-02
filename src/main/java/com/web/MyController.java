package com.web;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	
	
	
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/req1")
	public String input()
	{
		return "input";
	}
	
	
	
	@RequestMapping("/output")
	public String result(@RequestParam int amount,
			@RequestParam double interest,
			@RequestParam String startDate,
			@RequestParam String endDate,ModelMap model)
	{

		 // Parse the start and end dates
		
        LocalDate startDateObj = LocalDate.parse(startDate);
        LocalDate endDateObj = LocalDate.parse(endDate);
        
        // Do your interest calculation here using startDateObj and endDateObj
      
		long noOfDaysBetween=(int)ChronoUnit.DAYS.between(startDateObj,endDateObj);
		double monthlyInterest=amount/100*interest;
		double dayInterest=monthlyInterest/30;
		double totalInterest2=noOfDaysBetween*dayInterest;
		double totalInterest=totalInterest2;

		double total2=(int)amount+totalInterest2;
		double total=total2;
		
		model.put("k1",amount);
		model.put("k2",noOfDaysBetween);
		model.put("k3",monthlyInterest);
		model.put("k4",totalInterest);
		model.put("k5",total);
		
		return "result";
	}
	
	
	
}
