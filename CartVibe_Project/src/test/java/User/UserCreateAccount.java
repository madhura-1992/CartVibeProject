package User;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic.FileUtility.ExcelUtility;
import Generic.FileUtility.FileUtility;
import Generic.WebDriverUtility.WebDriverUtility;
import ObjectRepository.HomePage_User;
import ObjectRepository.SignUpPage_User;


public class UserCreateAccount {
	
	WebDriverUtility wLib=new WebDriverUtility();
	WebDriver driver=new ChromeDriver();
	FileUtility fLib=new FileUtility();
	SignUpPage_User sup=new SignUpPage_User(driver);
	HomePage_User hpu=new HomePage_User(driver);
	ExcelUtility eLib=new ExcelUtility();
	
	@Test(groups="smokeTest")
	public void userCreateAccountTest() throws Throwable {
		driver.get("http://49.249.28.218:8081/AppServer/Online_Shopping_Application/");
		hpu.getLoginLink().click();
		
		String name=eLib.readDataFromExcel("Users", 1, 0);
		String email=eLib.readDataFromExcel("Users", 1, 1);
		String contact=eLib.readDataFromExcel("Users", 1, 2);
		String password=eLib.readDataFromExcel("Users", 1, 3);
		try {
			sup.signUp(name, email, contact, password);
		}catch(Exception e) {}
	}

}
