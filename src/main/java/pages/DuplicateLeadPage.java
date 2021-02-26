package pages;

import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class DuplicateLeadPage extends ProjectSpecificMethods{
	public DuplicateLeadPage(ChromeDriver driver) {
		this.driver=driver;
	}
	
	public ViewLeadPage clickCreatLead() {
		driver.findElementByName("submitButton").click();
		return new ViewLeadPage(driver);
	}
	
	

}
