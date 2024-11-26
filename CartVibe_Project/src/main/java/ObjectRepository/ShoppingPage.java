package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.WebDriverUtility.WebDriverUtility;

public class ShoppingPage {
	WebDriverUtility wLib=new WebDriverUtility();
	WebDriver driver;
	public ShoppingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Shipping / Billing Address']")
	private WebElement shipOrBillAddressLink;
	public WebElement getShipOrBillAddressLink() {
		return shipOrBillAddressLink;
	}
	
	@FindBy(xpath="//textarea[@name='billingaddress']")
	private WebElement billingAddressTAF;
	
	@FindBy(id="bilingstate")
	private WebElement billingStateTF;
	
	@FindBy(id="billingcity")
	private WebElement billingCityTF;
	
	@FindBy(id="billingpincode")
	private WebElement billingPincodeTF;
	
	@FindBy(name="update")
	private WebElement updateBtn;
	
	public void updateBillingAddress(String address, String state, String city, String pincode)
	{
		System.out.println(address);
		billingAddressTAF.clear();
		billingAddressTAF.sendKeys(address);
		billingStateTF.clear();
		billingStateTF.sendKeys(state);
		billingCityTF.clear();
		billingCityTF.sendKeys(city);
		billingPincodeTF.clear();
		billingPincodeTF.sendKeys(pincode);
		System.out.println(pincode);
		wLib.scrollDown(driver, 800);
		updateBtn.click();
	}
	
	@FindBy(name="//a[text()='Home' and @class='dropdown-toggle']")
	private WebElement homeTab;
	
	public void clickOnHomeTab() {
		Actions act=new Actions(driver);
		act.moveToElement(homeTab).click().perform();
	}
	
}
