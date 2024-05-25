package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;

public class LeadPage extends BaseClass {
	
	public LeadPage() {
		
	}
	
	public CreateLeadPageValidation clickCreateLeadLink() {
		WebElement createleadlinkElement = driver.findElement(By.linkText("Create Lead"));
		createleadlinkElement.click();
		
		return new CreateLeadPageValidation();
	}

}
