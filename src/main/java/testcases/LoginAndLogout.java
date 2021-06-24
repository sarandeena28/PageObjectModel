package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class LoginAndLogout extends ProjectSpecificMethods{
	@BeforeTest
	public void provideTestDetails() {
		testName="LoginAndLogout";
		testAuthor="Saran";
		testDesc="Login with Positive Credentials";
		testCategory="Regression";
		excelFileName="Login";
	}
	@Test(dataProvider="fetchData")
	public void loginTest(String Username,String Password) throws IOException {
		
		//LoginPage lp=new LoginPage();
		new LoginPage(driver)
		.enterUsername(Username)
		.enterPassword(Password)
		.clickLoginButton().clickCrmsfa();
	}

}
