package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.WebDriverUtility.WebDriverUtility;

public class TrackYourOrderPage {
	WebDriverUtility wLib=new WebDriverUtility();
	WebDriver driver;
	public TrackYourOrderPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='orderid']")
	private WebElement orderIdTf;
	
	@FindBy(xpath = "//input[@id='exampleBillingEmail1']")
	private WebElement registeredEmailTf;
	
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement trackBtn;
	
	public void trackOrder(String id,String email) {
		orderIdTf.sendKeys(id);
		registeredEmailTf.sendKeys(email);
		wLib.scrollDown(driver, 500);
		trackBtn.click();
	}
	
}
