package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;

public class WelcomePage extends BaseClass {
	
	public WelcomePage() {
		
	}
	
	public HomePage clickCRMSFA() {
		WebElement crmsfaElement = driver.findElement(By.linkText("CRM/SFA"));
		crmsfaElement.click();
		return new HomePage();
	}
	
/*	public LoginPage clickLogoutbutton() {
		WebElement loginbuttonElement = driver.findElement(By.className("decorativeSubmit"));
		loginbuttonElement.click();
		return new LoginPage();
		}
		*/


}
