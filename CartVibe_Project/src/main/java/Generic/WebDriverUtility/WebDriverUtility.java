package Generic.WebDriverUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public WebDriver driver=null;
	public WebDriver launchBrowser(String browser) {
		if(browser.equals("chrome"))
			driver=new ChromeDriver();
		else if (browser.equals("firefox"))
			driver=new FirefoxDriver();
		else if(browser.equals("edge"))
			driver=new EdgeDriver();
		else
			driver=new ChromeDriver();
		return driver;		
	}
	
	public void maximizeTheBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void minimizeTheBrowser(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForElementToBeVisible(WebElement webElement) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
	public void select(WebElement webElement, String data) {
		Select sel=new Select(webElement);
		sel.selectByVisibleText(data);
	}
	
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void scrollDown(WebDriver driver,int a) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,"+a+")");	
	}
	
	public void mouseHover(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void switchToTabOnURL(WebDriver driver,String partialURL)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		while(it.hasNext())
		{
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(partialURL))
				break;
		}
	}
	

}
