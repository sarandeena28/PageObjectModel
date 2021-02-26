package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethods;

public class LoginPage  extends ProjectSpecificMethods {
	
	public LoginPage(ChromeDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
//	
//	@FindBy(how=How.ID,using="username") WebElement uName;
//	@FindBy(how=How.ID,using="password") WebElement password;
//	@FindBy(how=How.CLASS_NAME,using="decorativeSubmit") WebElement login;
		
	public  LoginPage enterUsername(String Username) throws IOException {
		try {
			driver.findElementById("username").sendKeys(Username);
			reportStep("Username"+Username+" entered succesfully","Pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			reportStep("Username"+Username+" not entered succesfully","Fail");
		}
//		uName.sendKeys(Username);
		return this;
	}
	
	public LoginPage enterPassword(String Password) throws IOException {
		try {
			driver.findElementById("password").sendKeys(Password);
			reportStep("Password"+Password+" entered succesfully","Pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			reportStep("Password"+Password+" not entered succesfully","Fail");
		}
//		password.sendKeys(Password);
		return this;
	}
	public HomePage clickLoginButton() throws IOException {
		try {
			driver.findElementByClassName("decorativeSubmit").click();
			reportStep("click entered succesfully","Pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			reportStep("Not click entered succesfully","Fail");
		}
//		login.click();
		return new HomePage(driver);
}

}
