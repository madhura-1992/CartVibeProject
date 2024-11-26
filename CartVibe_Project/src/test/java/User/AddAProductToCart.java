package User;

import org.testng.annotations.Test;

import Generic.BaseUtility.BaseClass;
import ObjectRepository.DashboardPage_User;
import ObjectRepository.HomePage_User;
import ObjectRepository.ProductDetailsPage_User;
import ObjectRepository.SearchResultPage_User;
import ObjectRepository.ShoppingCartPage_User;
import ObjectRepository.SignUpPage_User;

public class AddAProductToCart extends BaseClass{

	@Test(groups="integrationTest")
	public void addAProductToCartTest() throws Throwable {
		HomePage_User hpu=new HomePage_User(driver);
		hpu.getLoginLink().click();
		
		SignUpPage_User spu=new SignUpPage_User(driver);
		String EMAIL=eLib.readDataFromExcel("Users", 1, 1);
		String PASSWORD=eLib.readDataFromExcel("Users", 1, 3);
		spu.login(EMAIL, PASSWORD);
		
		DashboardPage_User dpu=new DashboardPage_User(driver);
		String productName=eLib.readDataFromExcel("Products", 4, 2);
		dpu.searchProduct(productName);
		
		wLib.scrollDown(driver, 800);
		SearchResultPage_User srpu=new SearchResultPage_User(driver);
		srpu.getProductNameLink().click();
		
		wLib.scrollDown(driver, 1000);
		ProductDetailsPage_User pdpu=new ProductDetailsPage_User(driver);
		pdpu.moveAndClick();
		
		wLib.switchToAlertAndAccept(driver);
		
		String expProductName=eLib.readDataFromExcel("Products", 5, 2);
		ShoppingCartPage_User scpu=new ShoppingCartPage_User(driver);
		String actProductName=scpu.getProdName().getText();
		
		System.out.println("EPN "+expProductName);
		System.out.println("APN "+actProductName);
		boolean res=actProductName.contains(expProductName);
		aLib.hardAssertBoolean(res);
		
		String expPageName="Shopping Cart";
		String actPageName=scpu.getPageName().getText();
		boolean res1=actPageName.contains(expPageName);
		aLib.hardAssertBoolean(res1);
		
		
		
	}
}
