package pages;

import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class CreateLeadPage extends ProjectSpecificMethods {
	
	public CreateLeadPage(ChromeDriver driver) {
		this.driver=driver;
	}
	public CreateLeadPage enterCompanyName(String companyName) {
		driver.findElementById("createLeadForm_companyName").sendKeys(companyName);
		return this;
	}
	
	public CreateLeadPage enterFirstName(String firstName) {
		driver.findElementById("createLeadForm_firstName").sendKeys(firstName);
		return this;
	}
	public CreateLeadPage enterLastName(String lastName) {
		driver.findElementById("createLeadForm_lastName").sendKeys(lastName);
		return this;
	}
	
	public CreateLeadPage enterPhoneNumber(String Phonenumber)
	{
		driver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys(Phonenumber);
		return this;
	}
	public ViewLeadPage clickCreateLead() {
	driver.findElementByName("submitButton").click();
	return new ViewLeadPage(driver);
	}

}
