package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class DuplicateLead extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setFile() {
		excelFileName="DuplicateLead";
	}
	@Test(dataProvider="fetchData")
	public void duplicateLead(String Username,String Password,String Phonenumber) throws InterruptedException, IOException {
		
		new LoginPage(driver)
		.enterUsername(Username)
		.enterPassword(Password)
		.clickLoginButton()
		.clickCrmsfa()
		.clickLead()
		.clickFindLead()
		.clickPhone()
		.enterPhonenumber(Phonenumber)
		.clickFindLeads()
		.clickFirstLead()
		.clickDuplicateLead()
		.clickCreatLead()
		.verifyLeadID();
		
		
		
	
		
		
	}

}
