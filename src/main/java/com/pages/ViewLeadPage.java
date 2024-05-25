package com.pages;

import org.openqa.selenium.By;

import com.base.BaseClass;

public class ViewLeadPage extends BaseClass {
	
	public ViewLeadPage() {
		
	}
	public void verifyLead() {
		String leadID=driver.findElement(By.id("viewLead_companyName_sp")).getText().replaceAll("[^0-9]", "");
		System.out.println(leadID);
	}
	

}
