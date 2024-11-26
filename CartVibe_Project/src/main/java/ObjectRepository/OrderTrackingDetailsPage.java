package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.WebDriverUtility.WebDriverUtility;

public class OrderTrackingDetailsPage {

	WebDriver driver;
	WebDriverUtility wLib=new WebDriverUtility();
	public OrderTrackingDetailsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//b[text()='Status:']/ancestor::tr/child::td[@class='fontkink']")
	private WebElement actStatus;
	public WebElement getActStatus() {
		return actStatus;
	}
	
	@FindBy(xpath="//b[text()='Remark:']/ancestor::tr/child::td[@class='fontkink']")
	private WebElement actRemark;
	public WebElement getActRemark() {
		return actRemark;
	}
	
	
	
}
