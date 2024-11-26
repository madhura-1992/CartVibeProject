package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.WebDriverUtility.WebDriverUtility;

public class LoginPage_Admin extends WebDriverUtility{
	
	WebDriver driver;
	public LoginPage_Admin(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="inputEmail")
	private WebElement userNameTF;
	
	@FindBy(id="inputPassword")
	private WebElement passwordTF;
	
	@FindBy(name="submit")
	private WebElement loginBtn;
	
	public void loginToApp(String userName,String password)
	{
		userNameTF.sendKeys(userName);
		passwordTF.sendKeys(password);
		loginBtn.click();
	}
	
	@FindBy(xpath="//span[contains(text(),'Back to Portal')]")
	private WebElement backToPortalLink;
	public WebElement getBackToPortalLink() {
		return backToPortalLink;
	}
	
	@FindBy(xpath="//span[text()='You have successfully logout']")
	private WebElement confirmMessage;
	public WebElement getConfirmMessage() {
		return confirmMessage;
	}
	

}
