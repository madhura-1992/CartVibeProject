package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.WebDriverUtility.WebDriverUtility;

public class DashboardPage_User {
	WebDriver driver;
	public DashboardPage_User(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutLink;
	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	@FindBy(name="product")
	private WebElement searchTF;
	
	@FindBy(xpath="//button[@name='search']")
	private WebElement searchBtn;
	
	public void searchProduct(String name) throws Throwable {
		searchTF.sendKeys(name);
		searchBtn.click();
		Thread.sleep(3000);
	}
	
	@FindBy(xpath="//li[@class='add-cart-button btn-group']")
	private WebElement addToCartBtn;
		
	public void clickOnAddToCart() {
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.scrollDown(driver,800);
		Actions act=new Actions(driver);
		//act.scrollToElement(addToCartBtn).perform();
		act.moveToElement(addToCartBtn).click().perform();		
	}
	
	@FindBy(xpath="//a[text()='My Account']")
	private WebElement myAccountLink;
	public WebElement getMyAccountLink() {
		return myAccountLink;
	}
	
	
	
	
	
}
