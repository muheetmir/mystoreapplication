package com.qa.automation.mystoreapp.testscript;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.qa.automation.mystoreapp.pages.CheckoutPage;
import com.qa.automation.mystoreapp.pages.HomePage;
import com.qa.automation.mystoreapp.pages.LoginPage;
import com.qa.automation.mystoreapp.pages.PaymentPage;
import com.qa.automation.mystoreapp.testsuite.TestSuiteBase;

public class MyStoreOrder extends TestSuiteBase{
	private ReportLogService report = new ReportLogServiceImpl(MyStoreOrder.class);
	LoginPage signin;
	HomePage selectitem;
	CheckoutPage btnchkout;
	PaymentPage paypage;
	
	@Test(priority=1)
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	public void signIntoMyStore(String os, String osVersion, String br, String browserVersion) {
		report.info("Opening browser: "+ br);
		browser.openURL("http://automationpractice.com/index.php", os, osVersion, br, browserVersion);
		browser.getWait().HardPause(2000);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
		signin=new LoginPage(browser);
		String mystoretitle=browser.getCurrentPageTitle();
		Verify.verifyString(mystoretitle,"My Store", "Verifying the login page title");
		browser.getWait().implicitWait(2000);
		signin.clickSignInLink();
		signin.enterUserName();
		signin.enterPassword();
		signin.clickSignInbtn();
		browser.getWait().HardPause(2000);
		signin.isLoginSuccessfull();
}
	
	@Test(priority=2)
	public void selectProductItem()
	{
		browser.getWait().implicitWait(3000);
		report.info("Adding item into cart");
		selectitem=new HomePage(browser);
		selectitem.clickHomeIcon();
		selectitem.clickTshirtsLink();
		browser.getWait().HardPause(3000);
		selectitem.mouseOverProduct();
		selectitem.clickOnMore();
		browser.getWait().HardPause(3000);
		selectitem.clickAddToCartBtn();
	}
	
	@Test(priority=3)
	public void performCheckout()
	{	
		report.info("Performing checkout on summary,address and shipping pages");
		btnchkout=new CheckoutPage(browser);
		browser.getWait().HardPause(3000);
		btnchkout.clickProceedToCheckOut();
		btnchkout.clickChkOutOnSummaryPage();
		btnchkout.checkOutAddress();
		browser.getWait().HardPause(3000);
		btnchkout.checkoutShipping();
		
	}
	
	@Test(priority=4)
	public void confirmOrder()
	{
		browser.getWait().implicitWait(2000);
		report.info("paying through check");
		paypage=new PaymentPage(browser);
		paypage.clickPayByCheck();
		report.info("confirming the order");
		paypage.clickConfirmOrder();
		paypage.verifyOrderPlaced();
		
	}
	
	
	
	
	
	
	

}
