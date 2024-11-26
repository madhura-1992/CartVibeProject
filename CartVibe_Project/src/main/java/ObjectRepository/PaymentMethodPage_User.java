package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentMethodPage_User {
	
	WebDriver driver;
	public PaymentMethodPage_User(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	@FindBy(xpath="//input[@value='COD']")
	private WebElement CODRadioBtn;
	
	@FindBy(name="submit")
	private WebElement submitBtn;
	
	public void codAndSubmit() {
		CODRadioBtn.click();
		submitBtn.click();
	}
	
	@FindBy(xpath="//input[@value='Internet Banking']")
	private WebElement IBRadioBtn;
	
	public void IBAndSubmit() {
		IBRadioBtn.click();
		submitBtn.click();
	}
	
	
}
