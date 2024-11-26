package Admin;

import org.testng.annotations.Test;

import Generic.BaseUtility.BaseClass;
import ObjectRepository.DashboardPage_Admin;
import ObjectRepository.HomePage_Admin;
import ObjectRepository.LoginPage_Admin;
import ObjectRepository.TodaysOrderPage;
import ObjectRepository.UpdateOrderPage;

public class TodaysOrders_Delivered extends BaseClass{
	@Test(groups="systemTest")
	public void todaysOrdersToInProcessTest() throws Throwable {
	HomePage_Admin hpa=new HomePage_Admin(driver);
	hpa.getLoginLink().click();
	
	String Username=fLib.readDataFromPropertyFile("userName");
	String Password=fLib.readDataFromPropertyFile("password");
	LoginPage_Admin lpa=new LoginPage_Admin(driver);
	lpa.loginToApp(Username, Password);
	
	DashboardPage_Admin dpa=new DashboardPage_Admin(driver);
	dpa.getOrderMgtDd().click();
	dpa.clickTodaysOrders();
	
	String productName=eLib.readDataFromExcel("Products", 2, 2);
	TodaysOrderPage top=new TodaysOrderPage(driver);
	top.getSearchTf().sendKeys(productName);
	top.clickOnUpdate();
	
	wLib.switchToTabOnURL(driver, "admin/updateorder");
	
	UpdateOrderPage uop=new UpdateOrderPage(driver);
	String orderID=uop.getOrderID().getText();
	System.out.println(orderID);
	
	String status=eLib.readDataFromExcel("Products", 2, 11);
	String remark=eLib.readDataFromExcel("Products", 2, 12);
	try {
	uop.updateStatus(status,remark);
	try {
		wLib.switchToAlertAndAccept(driver);
	}catch(Exception e) {}
	}catch(Exception e) {}
	
	wLib.switchToTabOnURL(driver, "admin/todays-orders");
	dpa.logout();
	
	String message="You have successfully logout";
	String actMessage=lpa.getConfirmMessage().getText();
	boolean res=actMessage.contains(message);
	aLib.hardAssertBoolean(res);	
	}
}
