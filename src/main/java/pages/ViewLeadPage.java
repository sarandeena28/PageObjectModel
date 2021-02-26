package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class ViewLeadPage  extends ProjectSpecificMethods{
	public ViewLeadPage(ChromeDriver driver) {
		this.driver=driver;
	}
	public ViewLeadPage verifyFirstName() {
		System.out.println("Verified successfully");
		return this;
		
	}
	
	public ViewLeadPage verifyLeadID() {
	
		String element = driver.findElementById("viewLead_companyName_sp").getText();

		System.out.println("Verified successfully" +element);
		return this;
		
	}
	public ViewLeadPage clickEditLead() {
		driver.findElementByLinkText("Edit").click();
		return this;
		
	}
	public DuplicateLeadPage clickDuplicateLead()
	{
		driver.findElementByLinkText("Duplicate Lead").click();
		return new DuplicateLeadPage(driver);
	}
	
	public MyLeadPage clickDeleteLead()
	{
		driver.findElementByLinkText("Delete").click();
		return new MyLeadPage(driver);
	}
	
	public ViewLeadPage modifyCompanyName(String companyName) {
		driver.findElementById("updateLeadForm_companyName").sendKeys(companyName);
		return this;
	}
	public ViewLeadPage clickUpdateLead() {
		System.out.println("Verified successfully");
		driver.findElementByName("submitButton").click();
		return this;
	}

}
