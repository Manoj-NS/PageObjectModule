package com.tests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.LoginPage;
import com.pages.LoginPageValidation;
import com.pages.WelcomePageValidation;


public class WelcomeValidation extends BaseClass {

	@BeforeTest
	public void setData() {
		excelFileName="Login Detail";
		
		testName = "HomepageValidation"; 
		testDescription="Home page validation";
		testCategory="Logo and Title"; 
		testAurthor="Manoj";
	
	}
	
	@Test(dataProvider="loginValidation")
	public void test(String username, String password) throws IOException {
		
		new WelcomePageValidation()
		.enterUsername(username)
		.enterPassword(password)
		.clickLoginbutton()
		.logoValidation()
		.titleValidation()
		.clickCRMSFA();
					
	}
}






