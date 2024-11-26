package Generic.ListenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Generic.BaseUtility.BaseClass;
import Generic.WebDriverUtility.UtilityClassObject;


public class ListenerImplementationClass implements ISuiteListener,ITestListener{
	public ExtentReports report;
	public ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO,result.getMethod().getMethodName()+"==>STARTED<==");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,result.getMethod().getMethodName()+"==>COMPLETED<==");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		
		TakesScreenshot eDriver=(TakesScreenshot)BaseClass.sdriver;
		String filePath=eDriver.getScreenshotAs(OutputType.BASE64);
		
		String time=new Date().toString().replaceAll(" ", "_").replaceAll(":", "_");
		
		test.addScreenCaptureFromBase64String(filePath,testName+"_"+time);
		test.log(Status.FAIL,result.getMethod().getMethodName()+"==>FAILED<==");
		
		test.log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onStart(ISuite suite) {
		//Report configuration
		String time=new Date().toString().replaceAll(":", "-");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CartVibe TestSuite Results");
		spark.config().setReportName("CartVibe Report");
		spark.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(spark);		
	}

	@Override
	public void onFinish(ISuite suite) {
		//Report backup
		report.flush();		
	}

}
