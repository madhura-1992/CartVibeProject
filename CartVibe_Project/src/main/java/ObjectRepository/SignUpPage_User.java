package ObjectRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.WebDriverUtility.WebDriverUtility;

public class SignUpPage_User extends WebDriverUtility{
	
	WebDriver driver;
	public SignUpPage_User(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="fullname")
	private WebElement fullNameTF;
	
	@FindBy(id="email")
	private WebElement emailAddressTF;
	
	@FindBy(id="contactno")
	private WebElement contactNoTF;
	
	@FindBy(id="password")
	private WebElement passwordTF;
	
	@FindBy(id="confirmpassword")
	private WebElement confirmPasswordTF;
	
	@FindBy(id="submit")
	private WebElement signUpBtn;
	
	public void signUp(String name, String email, String contact, String password)
	{
		fullNameTF.sendKeys(name);
		emailAddressTF.sendKeys(email);
		contactNoTF.sendKeys(contact);
		passwordTF.sendKeys(password);
		confirmPasswordTF.sendKeys(password);
		signUpBtn.click();
	}
	
	@FindBy(id="exampleInputEmail1")
	private WebElement emailAddLoginTF;
	
	@FindBy(id="exampleInputPassword1")
	private WebElement passwordLoginTF;
	
	@FindBy(xpath="//button[@name='login']")
	private WebElement loginBtn;
	
	public void login(String emailAddress, String pwd)
	{
		emailAddLoginTF.sendKeys(emailAddress);
		passwordLoginTF.sendKeys(pwd);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)");
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.scrollDown(driver,200);
		wLib.mouseHover(driver, loginBtn);
		loginBtn.click();
	}
	
}
