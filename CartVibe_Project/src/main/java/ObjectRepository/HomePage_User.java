package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.WebDriverUtility.WebDriverUtility;

public class HomePage_User extends WebDriverUtility{
	
	WebDriver driver;
	public HomePage_User(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement loginLink;
	public WebElement getLoginLink() {
		return loginLink;
	}
	
	@FindBy(xpath = "//span[text()='Track Order']")
	private WebElement trackOrderBtn;
	public WebElement getTrackOrderBtn() {
		return trackOrderBtn;
	}
	
}
