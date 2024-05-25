package com.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pages.LoginPage;
import com.pages.WelcomePage;

public class LoginPageValidation extends BaseClass{

public LoginPageValidation() {
		
	}
	
	public LoginPageValidation enterUsername(String username) throws IOException {
		
		try {
			WebElement usernameElement = driver.findElement(By.id("username"));
			usernameElement.sendKeys(username);
			reportStep(username+": Username is entered successfully","Pass");
			
		} catch (Exception e) {
			reportStep(username+": Username is not entered successfully..."+e,"Fail");
		}	
		
		return this;
	}
	
	public LoginPageValidation enterPassword(String password) throws IOException {
		
		try {
			WebElement passwordElement = driver.findElement(By.id("password"));
			passwordElement.sendKeys(password);
			reportStep(password+"Password entered successfully","Pass");
		} catch (Exception e) {
			reportStep(password+"Password not entered successfully..."+e,"Fail");
		}
		
		return this;
	
	}
	public WelcomePage clickLoginbutton() throws IOException {
		
		try {
			WebElement loginbuttonElement = driver.findElement(By.className("decorativeSubmit"));
			loginbuttonElement.click();
			reportStep("Login button is clicked","Pass");
		} catch (Exception e) {
			reportStep("Login button is not clicked..."+e,"Fail");
		}
		
		return new WelcomePage();
		
	}
	
	public LoginPageValidation clickLogInForFailer() throws IOException {
		try {
			WebElement loginbuttonElement = driver.findElement(By.className("decorativeSubmit"));
			loginbuttonElement.click();
			reportStep("Login button is clicked","Pass");
		} catch (Exception e) {
			reportStep("Login button is not clicked..."+e,"Fail");
		}		
		return this;
	}

	public LoginPageValidation userErrorMsg(String errorMessage) throws IOException {
		try {
			WebElement useralertElement = driver.findElement(By.xpath("//*[text()[contains(.,'User not found.')]]"));
			String actualUserAlert = useralertElement.getText();
						
			if(actualUserAlert.equals(errorMessage)) {
				System.out.println("Invalid Username error message text: Passed ");
				reportStep("Invalid username alert message displayed","Pass");}
			
			else {
				System.out.println("Username Actual and Expected error message text is not same.");
				reportStep("Username Actual and Expected error message text is not same","Fail");}
		}
	catch(Exception e) {
				//	System.out.println("Username: Unknown exception occured while verifying the Text");
			}
	
		return this;
	}
	
	public LoginPageValidation passwordErrorMsg(String errorMessage) throws IOException {
		try {
			WebElement passwordalertElement=driver.findElement(By.xpath("//*[text()[contains(.,'Password incorrect')]]"));
			String actualPasswordalert=passwordalertElement.getText();
			
			if(actualPasswordalert.equals(errorMessage)) {
				System.out.println("Invalid password error message text: Passed ");
				reportStep("Invalid password alert message displayed","Pass");}
			else {
				System.out.println("Password Actual and Expected error message text is not same.");
				reportStep("Password Actual and Expected error message text is not same","Fail");}						
		}
	
	catch(Exception e) {
	//	System.out.println("Password: Unknown exception occured while verifying the Text");
				}
	
		return this;
	}	
		
	public LoginPageValidation user2ErrorMsg(String errorMessage) throws IOException {
			try {
				WebElement nouserElement =driver.findElement(By.xpath("//p[text()='username was empty reenter']"));
				 String Actualnouseralert=nouserElement.getText();
				 
				 if(Actualnouseralert.equals(errorMessage)) {
						System.out.println("Username is empty");
						reportStep("Empty username alert message displayed","Pass");}
				 else {
						System.out.println("Empty username is not displayed");}		
					
				}
			catch (Exception e) {
			//	System.out.println("Empty username: Unknown exception occured while verifying the Text");
				
			}		
			return this;
		}
		
		public LoginPageValidation password2ErrorMsg(String errorMessage) throws IOException {
			try {
				WebElement nopasswordElement =driver.findElement(By.xpath("//p[text()='password was empty reenter']"));
				String Actualnopasswordalert=nopasswordElement.getText();
				
				if(Actualnopasswordalert.equals(errorMessage)) {
					System.out.println("Password is empty");
					reportStep("Empty password alert message displayed","Pass");}
					else {
						System.out.println("Password is not empty");
						reportStep("Empty password alert message not displayed","Fail");}		
		
				}
			catch (Exception e) {
				//	System.out.println("Empty Password: Unknown exception occured while verifying the Text");	
				}
		
			return this;}
		
		public LoginPageValidation validLogin (String errorMessage) {
			try {
				WebElement logoutElement = driver.findElement(By.linkText("CRM/SFA"));
				String loginStatus=logoutElement.getText();
				
				if (loginStatus.equalsIgnoreCase(errorMessage)){
					System.out.println("Login Successfully");
					reportStep("Login Successfully", "Pass");}
						else {
							System.out.println("Please check the login credentials");
							reportStep("Please check the login credentials","Fail");}
				
				}
			catch(Exception e) {
				//System.out.println("Login Status: Unknown exception occured while verifying the Text");				
			}
			return this;}
		
		public HomePage clickCRMSFA() throws IOException {
			
			try {
			WebElement crmsfaElement = driver.findElement(By.linkText("CRM/SFA"));
			crmsfaElement.click();
			reportStep("CRMSFA clicked","Pass");
			}
			catch (Exception e) {
				reportStep("CRMSFA clicked","Fail");	
			}
			return new HomePage();
			
		}
		
}

