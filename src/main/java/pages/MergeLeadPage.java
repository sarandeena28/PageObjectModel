package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;

public class MergeLeadPage extends ProjectSpecificMethods {
	public MergeLeadPage(ChromeDriver driver) {
		this.driver=driver;
	}
	
	public FindLeadPopupPage clickFromLead() {
		driver.findElementByXPath("//img[@alt='Lookup']").click();
		allWindows=driver.getWindowHandles();
		allhandles=new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
		return new FindLeadPopupPage(driver);
	}

	
	public FindLeadPopupPage clickToLead() {
	driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
	 allWindows = driver.getWindowHandles();
	 allhandles = new ArrayList<String>(allWindows);
	driver.switchTo().window(allhandles.get(1));
	return new FindLeadPopupPage(driver);
	}

	public MergeLeadPage clickMergeLead() {
	driver.findElementByXPath("//a[text()='Merge']").click();
	return this;
	}
	
	public MyLeadPage handleAlert() {
	driver.switchTo().alert().accept();
	return new MyLeadPage(driver);
	}
}
