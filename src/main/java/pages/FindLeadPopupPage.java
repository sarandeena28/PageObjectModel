package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class FindLeadPopupPage extends ProjectSpecificMethods {
//	public static String leadIDnew;
	
	public FindLeadPopupPage (ChromeDriver driver) {
		this.driver=driver;
	}
	
	public FindLeadPopupPage enterFirstname(String firstname) {
		driver.findElementByXPath("//input[@name='firstName']").sendKeys(firstname);	
		return this;
	}
	public FindLeadPopupPage clickFindlead() throws InterruptedException {
	driver.findElementByXPath("//button[text()='Find Leads']").click();
	Thread.sleep(1000);
	return this;
	}
	
	public FindLeadPopupPage getFirstLeadID() {
	leadIDnew = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").getText();
	System.out.println(leadIDnew);
	return this;
	}
	
	public MergeLeadPage clickFirstlead() {
	driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
	allWindows = driver.getWindowHandles();
	allhandles = new ArrayList<String>(allWindows);
	driver.switchTo().window(allhandles.get(0));
	return new MergeLeadPage(driver);
	}

}
