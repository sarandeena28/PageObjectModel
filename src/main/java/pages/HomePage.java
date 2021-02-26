package pages;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class HomePage  extends ProjectSpecificMethods {
	public HomePage(ChromeDriver driver) {
		this.driver=driver;
	}
	public MyHomePage clickCrmsfa() throws IOException {
		try {
			driver.findElementByLinkText("CRM/SFA").click();
			reportStep("Clciked","Pass");
		} catch (Exception e) {
			reportStep("Not Clicked","Fail");
		}
		return new MyHomePage(driver);
	}
	
	
}
