package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.WebDriverUtility.WebDriverUtility;

public class ShoppingCartPage_User {

	WebDriver driver;
	WebDriverUtility wLib=new WebDriverUtility();
	public ShoppingCartPage_User(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
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
	
	public void enterBillingAddress(String address, String state, String city, String pincode)
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
		wLib.scrollDown(driver, 500);
		updateBtn.click();
	}
	
	@FindBy(xpath="//textarea[@class='form-control unicase-form-control text-input' and @name='shippingaddress']")
	private WebElement shippingAddressTAF;
	
	@FindBy(id="shippingstate")
	private WebElement shippingStateTF;
	
	@FindBy(id="shippingcity")
	private WebElement shippingCityTF;
	
	@FindBy(id="shippingpincode")
	private WebElement shippingPincodeTF;
	
	@FindBy(name="shipupdate")
	private WebElement shippingUpdateBtn;
	
	@FindBy(xpath="//button[@name='ordersubmit']")
	private WebElement checkoutBtn;
	
	public void enterShippingAddress(String address, String state, String city, String pincode) throws Throwable
	{
		//wLib.waitForPageToLoad(driver);
		//wLib.waitForElementToBeVisible(shippingAddressTAF);
		shippingAddressTAF.clear();
		shippingAddressTAF.sendKeys(address);
		shippingStateTF.clear();
		shippingStateTF.sendKeys(state);
		shippingCityTF.clear();
		shippingCityTF.sendKeys(city);
		shippingPincodeTF.clear();
		shippingPincodeTF.sendKeys(pincode);
		wLib.scrollDown(driver, 500);
		shippingUpdateBtn.click();
		Thread.sleep(3000);
	}
	
	public void checkOut() {
		wLib.scrollDown(driver, 800);
		checkoutBtn.click();
	}
	
	@FindBy(xpath="//h4[@class='cart-product-description']/a[text()='Animals Tales From Panchtantra']")
	private WebElement prodName;

	public WebElement getProdName() {
		System.out.println("-- "+prodName);
		return prodName;
	}
	
	@FindBy(xpath="//li[contains(text(),'Shopping')]")
	private WebElement pageName;

	public WebElement getPageName() {
		return pageName;
	}
	
	@FindBy(xpath="//a[contains(text(),'Track')]")
	private WebElement trackLink;

	public void clickOnTrack() {
		Actions act=new Actions(driver);
		act.moveToElement(trackLink).click().perform();
	}
	
	
	
	
}
