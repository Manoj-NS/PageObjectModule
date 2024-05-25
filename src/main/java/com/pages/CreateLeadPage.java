package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.base.BaseClass;



public class CreateLeadPage extends BaseClass {
	
	public CreateLeadPage() {
		
		
	}
	
	public CreateLeadPage enterCompanyName(String companyName) {
		WebElement companynameElement = driver.findElement(By.id("createLeadForm_companyName"));
		companynameElement.sendKeys(companyName);
		return this;
	}
	
	public CreateLeadPage enterFirstName(String firstName) {
		WebElement firstnameElement = driver.findElement(By.id("createLeadForm_firstName"));
		firstnameElement.sendKeys(firstName);
		return this;
	}
	public CreateLeadPage enterLastName(String lastName) {
		WebElement lastnameElement = driver.findElement(By.id("createLeadForm_lastName"));
		lastnameElement.sendKeys(lastName);
		return this;
	}
	
	public CreateLeadPage selectDropdown1(String source) {
		WebElement sourceddlElement = driver.findElement(By.id("createLeadForm_dataSourceId"));		 
		 Select sourceList= new Select(sourceddlElement);
		 sourceList.selectByVisibleText(source);
		 
		 String selectedText=sourceList.getFirstSelectedOption().getText();
			System.out.println("DD1 option choosen as: "+selectedText); 
		
		
		return this;
	}
	
	public CreateLeadPage selectDropdown2 (String marketingCampaign) {
		WebElement marketingddlElement = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select sourceList= new Select(marketingddlElement);
		 sourceList.selectByVisibleText(marketingCampaign);
		 
		 String selectedText=sourceList.getFirstSelectedOption().getText();
		System.out.println("DDL2 option choosen as: "+selectedText);
		
		 
		return this;
	}
	
		public CreateLeadPage enterdateofBirth (String dateBirth) {
		
		WebElement dobElement = driver.findElement(By.id("createLeadForm_birthDate"));
		dobElement.sendKeys(dateBirth);
		System.out.println("Selected DOB: "+dateBirth);
		return this;
	}
		
		public CreateLeadPage enterDescription (String description) {
			WebElement descriptionElement = driver.findElement(By.id("createLeadForm_description"));	
			descriptionElement.sendKeys(description);
			System.out.println("Entered description: "+description);
			return this;
		}
		
		public CreateLeadPage enterPhone (String phone) {
			WebElement phoneElement = driver.findElement(By.id("createLeadForm_primaryPhoneNumber"));
			phoneElement.sendKeys(phone); 
			System.out.println("Entered the phone number: "+phone);
			return this;
		}
	
	public ViewLeadPage clickCreateLeadButton() {
		
		WebElement submitbuttonElement = driver.findElement(By.name("submitButton"));
		submitbuttonElement.click();
		return new ViewLeadPage();
	}
}
