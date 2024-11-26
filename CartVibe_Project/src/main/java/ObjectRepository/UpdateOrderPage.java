package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.WebDriverUtility.WebDriverUtility;

public class UpdateOrderPage {
	
	WebDriverUtility wLib=new WebDriverUtility();
	WebDriver driver;
	public UpdateOrderPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//b[text()='order Id:']/ancestor::tr/child::td[@class='fontkink']")
	private WebElement orderID;
	public WebElement getOrderID() {
		return orderID;
	}

	@FindBy(xpath="//select[@name='status']")
	private WebElement statusDd;
	
	@FindBy(xpath="//textarea[@name='remark']")
	private WebElement remarkTAF;
	
	@FindBy(xpath="//input[@name='submit2']")
	private WebElement updateBtn;
	
	public void updateStatus(String statusData,String remarkData) {
		wLib.select(statusDd, statusData);
		remarkTAF.sendKeys(remarkData);
		wLib.scrollDown(driver, 2000);
		Actions act=new Actions(driver);
		act.moveToElement(updateBtn).click().perform();
	}
	

}
