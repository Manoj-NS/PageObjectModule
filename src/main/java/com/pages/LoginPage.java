package com.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.base.BaseClass;


public class LoginPage extends BaseClass {
	
	public LoginPage() {
		
	}
	
	public LoginPage enterUsername(String username) throws IOException {
		
		  try { WebElement usernameElement = driver.findElement(By.id("username"));
		  usernameElement.sendKeys(username);
 
		  reportStep(username+": Username is entered successfully","Pass");
		  
		  } catch (Exception e) {
		  reportStep(username+": Username is not entered successfully..."+e,"Fail"); }

		return this;
		}	
	

	public LoginPage enterPassword(String password) throws IOException {

		  try { WebElement passwordElement = driver.findElement(By.id("password"));
		  passwordElement.sendKeys(password);
		  reportStep(password+": Password entered successfully","Pass"); } catch
		  (Exception e) {
		  reportStep(password+": Password not entered successfully..."+e,"Fail"); }
		 
		
		return this;
	
	}
	
	public  WelcomePage clickLoginbutton() throws IOException {
		
		try {
			WebElement loginbuttonElement = driver.findElement(By.className("decorativeSubmit"));
			loginbuttonElement.click();
			reportStep("Login button is clicked","Pass");
		} catch (Exception e) {
			reportStep("Login button is not clicked..."+e,"Fail");
		}
		
		return new WelcomePage();
	}
	

	}
