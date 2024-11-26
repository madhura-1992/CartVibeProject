package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage_User {

	WebDriver driver;
	public ProductDetailsPage_User(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Animals Tales From Panchtantra']/ancestor::div[@class='product']/descendant::div[@class='action']")
	private WebElement addToCartBtn;
	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}
	
	@FindBy(xpath="//a[text()='Animals Tales From Panchtantra']")
	private WebElement prodNameLink;
	/*public WebElement getProdNameLink() {
		return prodNameLink;
	}*/
	
	public void moveAndClick() {
		Actions act=new Actions(driver);
		act.moveToElement(prodNameLink).perform();
		addToCartBtn.click();		
	}
}
