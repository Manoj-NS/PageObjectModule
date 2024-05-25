package com.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;

public class WelcomePageValidation extends BaseClass {
	
	public WelcomePageValidation() {
		
	}
	
	public WelcomePageValidation enterUsername(String username) throws IOException {
		
		  try { WebElement usernameElement = driver.findElement(By.id("username"));
		  usernameElement.sendKeys(username);

		  reportStep(username+": Username is entered","Pass");
		  
		  } catch (Exception e) {
		  reportStep(username+": Username is not entered..."+e,"Fail"); }

		return this;
		}	
	

	public WelcomePageValidation enterPassword(String password) throws IOException {

		  try { WebElement passwordElement = driver.findElement(By.id("password"));
		  passwordElement.sendKeys(password);
		  reportStep(password+": Password entered successfully","Pass"); } catch
		  (Exception e) {
		  reportStep(password+": Password not entered successfully..."+e,"Fail"); }
		 
		
		return this;
	
	}
	
	
	  public WelcomePageValidation clickLoginbutton() throws IOException {
	  
	  try { WebElement loginbuttonElement =
	  driver.findElement(By.className("decorativeSubmit"));
	  loginbuttonElement.click(); reportStep("Login button is clicked","Pass"); }
	  catch (Exception e) { reportStep("Login button is not clicked..."+e,"Fail");
	  }
	  
	  return this; }
	 

	
	public WelcomePageValidation logoValidation() throws IOException {
		
		try{
			WebElement logoElement = driver.findElement(By.id("logo"));
			logoElement.isDisplayed();
			reportStep("Logo displayed","Pass");
			System.out.println("Logo displayed? "+logoElement.isDisplayed());
			}
		
		catch(Exception e) {
			reportStep("Logo not displayed","Fail");
			System.out.println("Logo not displayed");
			} 
		
	return this;}
	
	public WelcomePageValidation titleValidation() throws IOException {
		
		try {
			driver.getTitle().equals("Test Login | Practice Test Automation");
			reportStep("Title displayed","Pass");
			System.out.println("Title is displaying");
			}
			
		catch(Exception e) {
			reportStep("Title not displayed","Fail");
			System.out.println("Title is not displaying");}
			
		return this;
	}
	
	
	public HomePage clickCRMSFA() {
		WebElement crmsfaElement = driver.findElement(By.linkText("CRM/SFA"));
		crmsfaElement.click();
		return new HomePage();
	}

}
