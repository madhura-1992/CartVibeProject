package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage_User {

	WebDriver driver;
	public SearchResultPage_User(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='My First Box of Books']")
	private WebElement productNameLink;
	public WebElement getProductNameLink() {
		return productNameLink;
	}
	
}
