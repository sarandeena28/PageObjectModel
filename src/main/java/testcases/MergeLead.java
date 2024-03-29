package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class MergeLead extends ProjectSpecificMethods{
	@BeforeTest
	public void setFile() {
		excelFileName="MergeLead";
		testName="MergeLead";
		testDesc="MergeLead in positive flow";
		testCategory="Functional";
		testAuthor="Saranya";
	}
	
	@Test(dataProvider="fetchData")
	public void mergeLead(String Username,String Password,String firstname,String Firstname) throws InterruptedException, IOException {
		
		new LoginPage(driver)
		.enterUsername(Username)
		.enterPassword(Password)
		.clickLoginButton()
		.clickCrmsfa()
		.clickLead()
		.clickMergeLead()
		.clickFromLead()
		.enterFirstname(firstname)
		.clickFindlead()
		.getFirstLeadID()
		.clickFirstlead()
		.clickToLead()
		.enterFirstname(Firstname)
		.clickFindlead()
		.clickFirstlead()
		.clickMergeLead()
		.handleAlert()
		.clickFindLead()
		.enterMergeLeadID()
		.clickFindLeads()
		.VerfiyMergeLeadID();
		
		
		
	}
}
