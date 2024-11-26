package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.WebDriverUtility.WebDriverUtility;

public class HomePage_Admin extends WebDriverUtility{
	
	WebDriver driver;
	public HomePage_Admin(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Admin Login")
	private WebElement loginLink;

	public WebElement getLoginLink() {
		return loginLink;
	}
	
	
}
