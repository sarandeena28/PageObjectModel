package pages;

import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class FindLeadPage extends ProjectSpecificMethods {
	
	public static String leadID;
	
	public FindLeadPage(ChromeDriver driver) {
		this.driver=driver;
	}
	
	public FindLeadPage clickPhone() {
		driver.findElementByXPath("//span[text()='Phone']").click();
		return this;
	}
	
	public FindLeadPage enterPhonenumber(String Phonenumber) {
	driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys(Phonenumber);
	return this;
	}
	
	public FindLeadPage clickFindLeads() throws InterruptedException {
	driver.findElementByXPath("//button[text()='Find Leads']").click();
	Thread.sleep(2000);
	return this;
	}
	public FindLeadPage enterLeadID(){
	driver.findElementByXPath("//input[@name='id']").sendKeys(leadID);
	return new FindLeadPage(driver);
	}
	public FindLeadPage enterMergeLeadID(){
		driver.findElementByXPath("//input[@name='id']").sendKeys(leadIDnew);
		return new FindLeadPage(driver);
		}
	
	public FindLeadPage VerfiyDeletedLeadID() {
		String text = driver.findElementByClassName("x-paging-info").getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
		return this;
	}
	
	public FindLeadPage VerfiyMergeLeadID() {
		String text1 = driver.findElementByClassName("x-paging-info").getText();
		if (text1.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
		
		return this;
	}
	
	public ViewLeadPage clickFirstLead() {
	leadID = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").getText();
	driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
	return new ViewLeadPage(driver);
	}
}
