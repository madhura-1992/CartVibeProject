package Generic.BaseUtility;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Generic.AssertUtility.AssertUtility;
import Generic.FileUtility.ExcelUtility;
import Generic.FileUtility.FileUtility;
import Generic.WebDriverUtility.UtilityClassObject;
import Generic.WebDriverUtility.WebDriverUtility;

public class BaseClass {
	public static WebDriver sdriver=null;
	public WebDriver driver;
	
	public FileUtility fLib=new FileUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public AssertUtility aLib=new AssertUtility();

	@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void configBC(String browser) throws Throwable {
		Reporter.log("==Launch the Browser==",true);
		String BROWSER=System.getProperty(browser,fLib.readDataFromPropertyFile("browser"));
		driver=wLib.launchBrowser(BROWSER);
		UtilityClassObject.setDriver(driver);
		sdriver=driver;
		wLib.maximizeTheBrowser(driver);
	}
	
	@BeforeMethod(alwaysRun=true)
	public void configBM() throws Throwable {
		String URL=fLib.readDataFromPropertyFile("url");
		driver.get(URL);
	}
	
	@AfterClass(alwaysRun = true)
	public void configAC() {
		Reporter.log("==Close the Browser==",true);
		driver.quit();
	}
}
