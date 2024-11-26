package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.WebDriverUtility.WebDriverUtility;

public class DashboardPage_Admin extends WebDriverUtility{
	WebDriverUtility wLib=new WebDriverUtility();
	WebDriver driver;
	public DashboardPage_Admin(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='collapsed']")
	private WebElement orderMgtDd;
	public WebElement getOrderMgtDd() {
		return orderMgtDd;
	}
	
	@FindBy(xpath="//a[@href='pending-orders.php']")
	private WebElement pendingOrdersTab;
	
	public void clickPendingOrders() {
		Actions act=new Actions(driver);
		act.moveToElement(pendingOrdersTab).click().perform();
	}
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement downArrowIcon;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutTab;
	
	public void logout() {
		wLib.waitForPageToLoad(driver);
		//wLib.waitForElementToBeVisible(downArrowIcon);
		downArrowIcon.click();
		logoutTab.click();
	}
	
	@FindBy(xpath="//a[@href='todays-orders.php']")
	private WebElement todaysOrdersTab;
	
	public void clickTodaysOrders() {
		Actions act=new Actions(driver);
		act.moveToElement(todaysOrdersTab).click().perform();
	}
	

}
