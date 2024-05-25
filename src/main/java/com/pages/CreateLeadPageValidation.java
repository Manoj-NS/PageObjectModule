package com.pages;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.base.BaseClass;



public class CreateLeadPageValidation extends BaseClass {
	
	public CreateLeadPageValidation() {
		
		
	}
	/*
	
	public CreateLeadPageValidation enterCompanyName(String companyName) {
		WebElement companynameElement = driver.findElement(By.id("createLeadForm_companyName"));
		companynameElement.sendKeys(companyName);
		return this;
	}
	
	public CreateLeadPageValidation enterFirstName(String firstName) {
		WebElement firstnameElement = driver.findElement(By.id("createLeadForm_firstName"));
		firstnameElement.sendKeys(firstName);
		return this;
	}
	public CreateLeadPageValidation enterLastName(String lastName) {
		WebElement lastnameElement = driver.findElement(By.id("createLeadForm_lastName"));
		lastnameElement.sendKeys(lastName);
		return this;
	}
	
	*/
	
	
	
	public CreateLeadPageValidation sourceddlValues (String source) {
	try {	
		WebElement sourceddlElement = driver.findElement(By.id("createLeadForm_dataSourceId"));		 
		 Select sourceList= new Select(sourceddlElement); 
		 
		 String[] expectedOptions = source.split( ", ");//to read data after comma in Excel
		 
		 List<WebElement> sourceOptions =sourceList.getOptions();
		 
		 for (int j = 1; j < sourceOptions.size(); j++) {
	         String actualOptions = sourceOptions.get(j).getText().trim(); //to read data after comma in Excel
	         System.out.println("Source DDL options: "+actualOptions);
	         
	         if (Arrays.asList(expectedOptions).contains(actualOptions)) { //to read data after comma in Excel
	        	 System.out.println("Source dropdown have a expacted options \n");}
		 } 	 
		 }catch(Exception e)
	          {
	        	 System.out.println("Source dropdown not have a expacted options \n");
	         }
		 
		 	 
		 
		return this;
	}
	
		public CreateLeadPageValidation sourceddlSelect(String source) {
		
			try{
				WebElement sourceddlElement = driver.findElement(By.id("createLeadForm_dataSourceId"));		 
			
			 Select sourceList= new Select(sourceddlElement); 
			 
			 sourceList.selectByVisibleText(source);
			 String sourceselectedVlue=sourceList.getFirstSelectedOption().getText();
			 System.out.println("Selected option is: "+sourceselectedVlue);
			 
			 } catch (Exception e) {
				 System.out.println(source+": Invalid Option");
			 }
			 
			 /*
			 if (sourceList.isMultiple()) {
					
					System.out.println("Dropdown list accepts multiple choices.\n");
					
				} else {
					System.out.println("Dropdown list does not accept multiple choices.\n");

				}	
			 
	//DDL Size
			 
			 int sourceSize=sourceList.getOptions().size();
			 System.out.println("Source DDL size: "+sourceSize+"\n");
	*/		 
		
		return this;	
	}

	public ViewLeadPage clickCreateLeadButton() {
		
		WebElement submitbuttonElement = driver.findElement(By.name("submitButton"));
		submitbuttonElement.click();
		return new ViewLeadPage();
	}
}
