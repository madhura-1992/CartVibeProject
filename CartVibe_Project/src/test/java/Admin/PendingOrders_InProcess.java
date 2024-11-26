package Admin;

import org.testng.annotations.Test;

import Generic.BaseUtility.BaseClass;
import ObjectRepository.DashboardPage_Admin;
import ObjectRepository.HomePage_Admin;
import ObjectRepository.HomePage_User;
import ObjectRepository.LoginPage_Admin;
import ObjectRepository.OrderTrackingDetailsPage;
import ObjectRepository.PendingOrdersPage;
import ObjectRepository.ShoppingCartPage_User;
import ObjectRepository.SignUpPage_User;
import ObjectRepository.TrackYourOrderPage;
import ObjectRepository.UpdateOrderPage;

public class PendingOrders_InProcess extends BaseClass {
	@Test(groups="integrationTest")
	public void pendingOrdersToInProcessTest() throws Throwable {
	HomePage_Admin hpa=new HomePage_Admin(driver);
	hpa.getLoginLink().click();
	
	String Username=fLib.readDataFromPropertyFile("userName");
	String Password=fLib.readDataFromPropertyFile("password");
	LoginPage_Admin lpa=new LoginPage_Admin(driver);
	lpa.loginToApp(Username, Password);
	
	DashboardPage_Admin dpa=new DashboardPage_Admin(driver);
	dpa.getOrderMgtDd().click();
	dpa.clickPendingOrders();
	
	String productName=eLib.readDataFromExcel("Products", 4, 2);
	PendingOrdersPage pop=new PendingOrdersPage(driver);
	pop.getSearchTf().sendKeys(productName);
	
	pop.clickOnUpdate();
	
	wLib.switchToTabOnURL(driver, "admin/updateorder");
	
	UpdateOrderPage uop=new UpdateOrderPage(driver);
	String orderID=uop.getOrderID().getText();
	System.out.println(orderID);
	
	String status=eLib.readDataFromExcel("Products", 2, 9);
	String remark=eLib.readDataFromExcel("Products", 2, 10);
	try {
	uop.updateStatus(status,remark);
	try {
		wLib.switchToAlertAndAccept(driver);
	}catch(Exception e) {}
	}catch(Exception e) {}
	
	wLib.switchToTabOnURL(driver, "admin/todays-orders");
	dpa.logout();
	
	lpa.getBackToPortalLink().click();
	
	HomePage_User hpu=new HomePage_User(driver);
	hpu.getLoginLink().click();
	
	SignUpPage_User spu=new SignUpPage_User(driver);
	String EMAIL=eLib.readDataFromExcel("Users", 1, 1);
	String PASSWORD=eLib.readDataFromExcel("Users", 1, 3);
	spu.login(EMAIL, PASSWORD);
	
	hpu.getTrackOrderBtn().click();
	
	TrackYourOrderPage tyop=new TrackYourOrderPage(driver);
	tyop.trackOrder(orderID, EMAIL);
	
	ShoppingCartPage_User scpu=new ShoppingCartPage_User(driver);
	scpu.clickOnTrack();
	
	wLib.switchToTabOnURL(driver, "track-order.php");
	
	OrderTrackingDetailsPage otdp=new OrderTrackingDetailsPage(driver);
	
	String actStatus=otdp.getActStatus().getText();
	String actRemark=otdp.getActRemark().getText();
	
	System.out.println("actual "+actStatus);
	System.out.println("actual "+actRemark);
	System.out.println("exp "+status);
	System.out.println("exp "+remark);
	
	boolean res=actStatus.equalsIgnoreCase(status);
	boolean res1=actRemark.equalsIgnoreCase(remark);
	
	aLib.hardAssertBoolean(res);
	aLib.hardAssertBoolean(res1);
	//aLib.hardAssertEquals(actStatus, status);
	//aLib.hardAssertEquals(actRemark, remark);
	
	}
}
