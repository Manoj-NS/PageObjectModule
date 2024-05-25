package com.tests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.LoginPage;


public class CreateLeadsValidation extends BaseClass {

	@BeforeTest
	public void setData() {
		excelFileName="CreateLeads-Source-DDL";
		
		testName = "Validation"; 
		testDescription="Validating dropdown list";
		testCategory="Functionality"; 
		testAurthor="Manoj";
		
		
	}
	
	@Test(dataProvider="loginValidation")
	public void test(String username, String password, String source) throws IOException {
		
		new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLoginbutton()
		.clickCRMSFA()
		.clickLeads()
		.clickCreateLeadLink()
		.sourceddlValues(source)
		.sourceddlSelect(source);
		
		
	}
}






