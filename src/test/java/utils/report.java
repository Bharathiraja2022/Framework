package utils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class report {
ExtentReports extent;
ExtentTest test;
String desc="";
String author="";
String category="";
@BeforeSuite
protected void startReport() {
	ExtentSparkReporter reporter=new ExtentSparkReporter("./TestReport.html");
extent=new ExtentReports();
extent.attachReporter(reporter);

}
@AfterSuite
protected void stopReport()
{
	extent.flush();
}

@BeforeClass
void createTest()
{
	 test= extent.createTest("desc");
	test.assignAuthor("author");
	test.assignCategory("category");
	
	
}

void step(String status,String description)
{
	switch(status.toLowerCase())
	{
	case "pass" :
		test.pass(description);
		break;
	case "fail" :
		test.fail(description);
		break;
	case "info" :
		test.info(description);
		break;
	case "debug" :
		test.pass(description);
		break;
	}
}

}
