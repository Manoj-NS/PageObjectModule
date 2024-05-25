package com.tests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.LoginPage;
import com.pages.LoginPageValidation;
import com.pages.PractisePage;


public class LoginValidation extends BaseClass {

	@BeforeTest
	public void setData() {
		excelFileName="Validation";
		
		testName = "Login(Negative)"; 
		testDescription= "Login for Failure(Negative testCase)";
		testCategory="Smoke"; 
		testAurthor="manoj";
		
		
		
	
	}
	
	@Test(dataProvider="loginValidation")
	public void test(String username, String password, String errorMessage) throws IOException, InterruptedException {
		
		new LoginPageValidation()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogInForFailer()
		.userErrorMsg(errorMessage)
		.passwordErrorMsg(errorMessage)
		.user2ErrorMsg(errorMessage)
		.password2ErrorMsg(errorMessage)
		.validLogin(errorMessage)
		.clickCRMSFA();
			
	}
}






