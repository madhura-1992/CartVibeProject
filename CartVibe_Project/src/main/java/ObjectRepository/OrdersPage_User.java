package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.WebDriverUtility.WebDriverUtility;

public class OrdersPage_User {
	
	WebDriver driver;
	WebDriverUtility wLib=new WebDriverUtility();
	public OrdersPage_User(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'Dell Inspiron')]")
	private WebElement prodName;

	public WebElement getProdName() {
		return prodName;
	}
	
	@FindBy(xpath="//li[contains(text(),'Shopping')]")
	private WebElement pageName;

	public WebElement getPageName() {
		return pageName;
	}
	
}
