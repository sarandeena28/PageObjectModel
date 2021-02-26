package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.HomePage;
import pages.LoginPage;
import pages.MyHomePage;

public class CreateLead extends ProjectSpecificMethods {
	@BeforeTest
	public void setFile() {
		excelFileName="CreateLead";
	}
	
	
	@Test(dataProvider="fetchData")
	public void createLead(String Username,String Password,String companyName,String firstName,String lastName,String Phonenumber) throws IOException {
		
		new LoginPage(driver)
		.enterUsername(Username)
		.enterPassword(Password)
		.clickLoginButton()
		.clickCrmsfa()
		.clickLead()
		.clickCreateLead()
		.enterCompanyName(companyName)
		.enterFirstName(firstName)
		.enterLastName(lastName)
		.enterPhoneNumber(Phonenumber)
		.clickCreateLead()
		.verifyFirstName();
		
	}

}
