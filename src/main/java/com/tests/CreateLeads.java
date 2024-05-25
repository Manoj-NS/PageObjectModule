package com.tests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.LoginPage;


public class CreateLeads extends BaseClass {

	@BeforeTest
	public void setData() {
		excelFileName="CreateLeads";
		
		testName = "CreateLead"; 
		testDescription="Create Lead with mandatory info";
		testCategory="Functionality"; 
		testAurthor="Manoj";
		
		
	}
	
	@Test(dataProvider="loginValidation")
	public void test(String username, String password, String companyname, String fname, String lname, String source, String marketingCampaign, String dateBirth, String description, String phone) throws IOException {
		
		new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLoginbutton()
		.clickCRMSFA()
		.clickLeads()
		.clickCreateLeadLink();
	/*	.enterCompanyName(companyname)
		.enterFirstName(fname)
		.enterLastName(lname)
		.selectDropdown1(source)
		.selectDropdown2(marketingCampaign)
		.enterdateofBirth(dateBirth)
		.enterDescription(description)
		.enterPhone(phone);
	*/	
		
	}
}






