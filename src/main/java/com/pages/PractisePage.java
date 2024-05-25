package com.pages;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;

public class PractisePage extends BaseClass {
	
	public PractisePage() {
		
	}
	
	public void homepageValidation() {
		
			WebElement logoElement = driver.findElement(By.id("logo"));
			System.out.println("Is logo displayed? "+logoElement.isDisplayed());
		
			if (driver.getTitle().equals("Test Login | Practice Test Automation")){
				System.out.println("Title is displaying");}
				else {
					System.out.println("Title is not displaying");}
		
	}
	
	public PractisePage enterUsername(String username) throws IOException {
		
		  try { 
		  WebElement usernameElement = driver.findElement(By.id("username"));
		  usernameElement.sendKeys(username);
		  reportStep(username+": Username is entered successfully","Pass");} 
		  
		  catch (Exception e) {
		  reportStep(username+": Username is not entered successfully..."+e,"Fail"); }

		  return this;
		}	
	

	public PractisePage enterPassword(String password) throws IOException {

		try { 
			WebElement passwordElement = driver.findElement(By.id("password"));
			passwordElement.sendKeys(password);
			reportStep(password+": Password entered successfully","Pass"); } 
		  
		catch(Exception e) {
		  reportStep(password+": Password not entered successfully..."+e,"Fail"); 
		  }

		return this;
	}
		
	public  PractisePage clickLoginbutton() throws IOException {
		
		try {
			WebElement loginbuttonElement = driver.findElement(By.className("decorativeSubmit"));
			loginbuttonElement.click();
			reportStep("Login button is clicked","Pass");} 
		
		catch (Exception e) {
			reportStep("Login button is not clicked..."+e,"Fail");
		}
		
		return this;
		}	
		
	public PractisePage validLogin() throws IOException, InterruptedException  {
		
		try {
				WebElement logoutElement = driver.findElement(By.xpath("//input[@value='Logout']"));
				
				if(logoutElement.isDisplayed()) {
				System.out.println("Login Status: Login Successfully");
				reportStep("Logged in successfully", "Pass");
				
				}
		else {
			System.out.println("Please check the login credentials1");
			reportStep("Please check the login credentials", "Fail");}
		}
		 catch (Exception e) {
					System.out.println("Please check the login credentials2");
				//	reportStep("Please check the login credentials", "Fail");
			}
		return this;
	}		
	
	public PractisePage usernameValidation() throws IOException {
		
		try {
		    WebElement useralertElement = driver.findElement(By.xpath("//*[text()[contains(.,'User not found.')]]"));
		    String actualUserAlert = useralertElement.getText();
		    String expectedUserAlert = "following error occurred during login: User not found.";

		    if (actualUserAlert.equals(expectedUserAlert)) {
		        System.out.println("User Status: Invalid username");
		        reportStep("Invalid username error message displayed", "Pass");
		       
		        
		    } else {
		        System.out.println("User Status: Valid username entered");
		        reportStep("Invalid username error message not displayed", "Fail");
		    }
		} catch (NoSuchElementException e) {
		    System.out.println("User Status: Valid username entered");
		   // reportStep("Valid username entered", "Pass");
		}
		return this;
	}
}	
		

/*		
		try {
			WebElement passwordalertElement=driver.findElement(By.xpath("//*[text()[contains(.,'Password incorrect')]]"));
			String Actualpasswordalert=passwordalertElement.getText();
			String Expectedpasswordalert="following error occurred during login: Password incorrect.";
					  	 		  
			if(passwordalertElement.isDisplayed() && Actualpasswordalert.equals(Expectedpasswordalert)) {
				System.out.println("Password Status: Invalid password");
				reportStep("Password is incorrect", "Fail");}
				else {
			        System.out.println("Password Status: Valid password entered");
			        reportStep("Valid password entered", "Pass");}
			    }
		
		catch(NoSuchElementException e) {
					System.out.println("Password Status: Valid password entered");
					reportStep("Valid Password is entered", "Pass");
			}
	

		return this;}	
}
*/


/*
	
	public PractisePage invalidUsername() throws IOException, InterruptedException  {	
		
		try {
		    WebElement useralertElement = driver.findElement(By.xpath("//*[text()[contains(.,'User not found.')]]"));
		    
		    Assert.assertTrue("Valid username", useralertElement.isDisplayed());
		    reportStep("Invalid username", "Fail");
*/		    
/*		    String actualUserAlert = useralertElement.getText();
		    String expectedUserAlert = "following error occurred during login: User not found.";

		    if (useralertElement.isDisplayed() && actualUserAlert.equals(expectedUserAlert)) {
		        System.out.println("User Status: Invalid username");
		        reportStep("Invalid username", "Fail");
		    } else {
		        System.out.println("User Status: Valid username entered");
		     
		     reportStep("Valid username entered", "Pass");
		    }*/
/*		    
		    Thread.sleep(2000);
		} catch (NoSuchElementException e) {
		    System.out.println("User Status: Valid username entered");
		    reportStep("Valid username entered", "Pass");
		}

		
		return this;
		 }
		
		
	public PractisePage invalidPassword() throws IOException, InterruptedException  {
		
		try {
			WebElement passwordalertElement=driver.findElement(By.xpath("//*[text()[contains(.,'Password incorrect')]]"));
			String Actualpasswordalert=passwordalertElement.getText();
			String Expectedpasswordalert="following error occurred during login: Password incorrect.";
					  	 		  
			if(passwordalertElement.isDisplayed() && Actualpasswordalert.equals(Expectedpasswordalert)) {
				System.out.println("Password Status: Invalid password");
				reportStep("Password is incorrect", "Fail");}
				else {
			        System.out.println("Password Status: Valid password entered");
			        reportStep("Valid password entered", "Pass");}
			    }
		
		catch(NoSuchElementException e) {
					System.out.println("Password Status: Valid password entered");
					reportStep("Valid Password is entered", "Pass");
			}
		return this;
	}
}

*/

	
/*			 
//Empty Username
		try {
			  			  
			  WebElement nouserElement =driver.findElement(By.xpath("//p[text()='username was empty reenter']"));
			  String Actualnouseralert=nouserElement.getText();
			  String Expectednouseralert="username was empty reenter";
			  	 		  
		//	  boolean user2=Actualnouseralert.equals(Expectednouseralert);
		//	  System.out.println("Username not entered: "+user2);

			  if(Actualnouseralert.equals( Expectednouseralert)) {
			    System.out.println("User Status: username is empty");
			    reportStep("Username is empty", "Fail");
			  }
				
			 }
			 catch(Exception e) {
				 System.out.println("User Status: Username is not empty");
				 reportStep("Username is not empty", "Pass");
			 }
			 
//Empty password
		
		try {
			WebElement nopasswordElement =driver.findElement(By.xpath("//p[text()='password was empty reenter']"));
			String Actualnopasswordalert=nopasswordElement.getText();
			String Expectednopasswordalert="password was empty reenter";
		  	 		  

		  if(Actualnopasswordalert.equals(Expectednopasswordalert)) {
		    System.out.println("Password Status:Password is empty");
		    reportStep("Password is empty", "Pass");
		  }
			
	}
	//catch(NoSuchElementException e1) {
//		System.out.println("Password is not empty");
	//}
		catch(Exception e) {
			System.out.println("Password Status: Password is not empty");
			reportStep("Password is not empty", "Fail");}
*/
				
	
	/*	
		try {
			WebElement useralertElement = driver.findElement(By.xpath("//p[text()[contains(.,'User not found.')]]")); 
		//	useralertElement.isDisplayed();
		//	reportStep("Invalid Username", "Fail");
							
			useralertElement.isDisplayed(); 
			reportStep("Invalid Username", "Pass");}
		
			catch (Exception e) {
			reportStep("Username entered", "Fail");}
			//System.out.println("Username entered");}
	
//	return this;
//  }	

//		public PractisePage validateUsername2() throws IOException  {

		try {
			WebElement nouserElement =driver.findElement(By.xpath("//p[text()='username was empty reenter']"));
			
			nouserElement.isDisplayed();
			reportStep("Username not entered", "Pass");} 
		
		catch (Exception e) {
			reportStep("Username not empty", "Fail");
			System.out.println("Username not empty");}
	
//		return this;
//	}
	

//	public PractisePage validatePassword () throws IOException {
		
		try {
		WebElement passwordalertElement=driver.findElement(By.xpath("//*[text()[contains(.,'Password incorrect')]]"));
		
		passwordalertElement.isDisplayed();
		reportStep("Incorrect Password", "Fail");} 
	
		catch (Exception e) {
		System.out.println("Password entered");}
		
	return this;		
	}
	*/
		
	

			  

	

