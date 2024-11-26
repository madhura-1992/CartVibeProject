package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.WebDriverUtility.WebDriverUtility;

public class TodaysOrderPage {

	WebDriverUtility wLib=new WebDriverUtility();
	WebDriver driver;
	public TodaysOrderPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement searchTf;
	public WebElement getSearchTf() {
		return searchTf;
	}
	
	@FindBy(xpath="//a[@title='Update order']")
	private WebElement updateOrderIcon;
	
	public void clickOnUpdate() {
		Actions act=new Actions(driver);
		act.moveToElement(updateOrderIcon).click().perform();
	}
}
