package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class EditLead extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setFile() {
		excelFileName="EditLead";
		testName="EditLead";
		testDesc="EditLead in positive flow";
		testCategory="Functional";
		testAuthor="Saranya";
	}
	
	@Test(dataProvider="fetchData")
	public void editLead(String Username,String Password,String Phonenumber,String companyName) throws InterruptedException, IOException {
		
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
		.clickEditLead()
		.modifyCompanyName(companyName)
		.clickUpdateLead();
		
		
	}

}
