package utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LeranExtendReport {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Step1:Create Physical Report
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./reports/result.html");
		//step2:To get History
		reporter.setAppendExisting(true);
		
		//Step3:create actual Report Data
		ExtentReports extent=new ExtentReports();
		//step4:Attach the extent data to the physical report
		extent.attachReporter(reporter);
		//step5: Create Testcase with details
		ExtentTest tc1=extent.createTest("CreateLead","CreateLead with mandatory Information");
		
		tc1.assignAuthor("Saran");
		tc1.assignCategory("Regression Test");
		
		//Step6: Test step status
		tc1.pass("Lead created succesfully",MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/HomeScreen.png").build());
		extent.flush();
		
		
		
		
		
		

	}

}
