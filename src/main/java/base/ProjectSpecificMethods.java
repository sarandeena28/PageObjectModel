package base;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcel;

public class ProjectSpecificMethods {
	public  ChromeDriver driver;
	public String excelFileName;
	public Set<String> allWindows;
	public List<String> allhandles; 
	public static String leadIDnew;
	public static ExtentReports extent;
	public static ExtentHtmlReporter reporter;
	public static ExtentTest tc1,node;
	public String testName,testDesc,testAuthor,testCategory;
	@BeforeSuite
	public void startReport() {
		reporter=new ExtentHtmlReporter("./reports/result.html");
		reporter.setAppendExisting(true);
		extent=new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@BeforeClass
	public void testDetails() {
		 tc1=extent.createTest(testName,testDesc);
		tc1.assignAuthor(testAuthor);
		tc1.assignCategory(testCategory);
	}
	
	public long takeSnap() throws IOException {
		Long randNum=(long)(Math.random()*99999999L);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target=new File("./snaps/img"+ randNum +".png");
		FileUtils.copyFile(source, target);
		return randNum;
	}
	public void reportStep(String msg,String status) throws IOException
	{
		if(status.equalsIgnoreCase("pass")) {
			node.pass(msg,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
		}
		else if(status.equalsIgnoreCase("fail"))
		{
			node.fail(msg,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
		}
	}
	@BeforeMethod
	public void startApp() {
		node=tc1.createNode(testName);
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException{
		ReadExcel read=new ReadExcel();
		String[][] readData = read.readData(excelFileName);
		return readData;
	}
	@AfterMethod
	public void close() {
		driver.close();
	}
	@AfterSuite
	public void stopReport() {
		extent.flush();
	}
	
	
}
