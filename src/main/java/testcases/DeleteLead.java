package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class DeleteLead extends ProjectSpecificMethods {

	@BeforeTest
	public void setFile() {
		excelFileName="DeleteLead";
		testName="DeleteLead";
		testCategory="Functional";
		testAuthor="Saranya";
	}
	
	@Test(dataProvider="fetchData")
	public void deleteLead(String Username,String Password,String Phonenumber) throws InterruptedException, IOException {
		
		String leadID = null;
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
		.clickDeleteLead()
		.clickFindLead()
		.enterLeadID()
		.VerfiyDeletedLeadID();
	}
		
}