package User;

import org.testng.annotations.Test;

import Generic.BaseUtility.BaseClass;
import ObjectRepository.DashboardPage_User;
import ObjectRepository.HomePage_User;
import ObjectRepository.OrdersPage_User;
import ObjectRepository.PaymentMethodPage_User;
import ObjectRepository.ShoppingCartPage_User;
import ObjectRepository.SignUpPage_User;

public class PlaceOrderByInternetBanking extends BaseClass{

	@Test(groups="systemTest")
	public void placeOrderByIBtest() throws Throwable {
		HomePage_User hpu=new HomePage_User(driver);
		hpu.getLoginLink().click();
		
		SignUpPage_User spu=new SignUpPage_User(driver);
		String EMAIL=eLib.readDataFromExcel("Users", 1, 1);
		String PASSWORD=eLib.readDataFromExcel("Users", 1, 3);
		spu.login(EMAIL, PASSWORD);
		
		DashboardPage_User dpu=new DashboardPage_User(driver);
		String productName=eLib.readDataFromExcel("Products", 2, 2);
		dpu.searchProduct(productName);
		dpu.clickOnAddToCart();
		//Thread.sleep(5000);
		try {
			wLib.switchToAlertAndAccept(driver);
		}catch(Exception e) {}
		
		ShoppingCartPage_User scpu=new ShoppingCartPage_User(driver);
		String address=eLib.readDataFromExcel("Users", 1, 4);
		String state=eLib.readDataFromExcel("Users", 1, 5);
		String city=eLib.readDataFromExcel("Users", 1, 6);
		String pincode=eLib.readDataFromExcel("Users", 1, 7);
		scpu.enterBillingAddress(address, state, city, pincode);
		try {
		wLib.switchToAlertAndAccept(driver);
		}catch(Exception e) {}
		
		scpu.enterShippingAddress(address, state, city, pincode);
		try {
			wLib.switchToAlertAndAccept(driver);
		}catch(Exception e) {}
		scpu.checkOut();
		
		PaymentMethodPage_User pmpu=new PaymentMethodPage_User(driver);
		pmpu.IBAndSubmit();
		
		OrdersPage_User opu=new OrdersPage_User(driver);
		String proName=opu.getProdName().getText();
		System.out.println("proName: "+proName);
		System.out.println("productName: "+productName);
		boolean res1=proName.contains(productName);
		System.out.println(res1);
		aLib.hardAssertBoolean(res1);
		String expPageName="Shopping Cart";
		String actPageName=opu.getPageName().getText();
		boolean res=expPageName.contains(actPageName);
		aLib.hardAssertBoolean(res);
		
	}
}
