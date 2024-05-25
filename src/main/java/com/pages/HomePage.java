package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;

public class HomePage extends BaseClass {
	
	public HomePage() {
		
	}
	
	public LeadPage clickLeads() {
		WebElement clickleadsbuttonElement = driver.findElement(By.linkText("Leads"));
		clickleadsbuttonElement.click();
		return new LeadPage();
	}

}
