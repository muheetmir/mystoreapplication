package com.qa.automation.mystoreapp.testscript;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.qa.automation.mystoreapp.pages.AddToCartPage;
import com.qa.automation.mystoreapp.pages.CheckoutPage;
import com.qa.automation.mystoreapp.pages.HomePage;
import com.qa.automation.mystoreapp.pages.LoginPage;
import com.qa.automation.mystoreapp.pages.PaymentPage;
import com.qa.automation.mystoreapp.testsuite.TestSuiteBase;

/*
 * this class perform the actions for placing the order from signing into the application with the known user details 
 * and adding then selecting the product from home page and adding it into the cart and placing the order.
 */
public class MyStoreOrder extends TestSuiteBase{
	private ReportLogService report = new ReportLogServiceImpl(MyStoreOrder.class);
	LoginPage lp;				//declaring the ref for LoginPage class and instantiating in respective methods below
	HomePage hp;  				//declaring the ref for HomePage class and instantiating in respective methods below
	AddToCartPage addcartpg;	//declaring the ref for AddToCartPage class and instantiating in respective methods below
	CheckoutPage chkoutpg;		//declaring the ref for CheckoutPage class and instantiating in respective methods below
	PaymentPage paypage;		//declaring the ref for PaymentPage class and instantiating in respective methods below
	
	
// Launching the website and performing sign in with known credentials
	@Test(priority=1)
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	public void signIntoMyStore(String os, String osVersion, String br, String browserVersion) {
		report.info("Opening browser: "+ br);
		lp=new LoginPage(browser);
		browser.openURL("http://automationpractice.com/index.php", os, osVersion, br, browserVersion);
		browser.getWait().HardPause(2000);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
		String mystoretitle=browser.getCurrentPageTitle();
		Verify.verifyString(mystoretitle,"My Store", "Verifying the login page title");
		//browser.getWait().implicitWait(2000);
		lp.clickSignInLink();
		browser.getWait().HardPause(2000);
		lp.enterUserName();
		lp.enterPassword();
		lp.clickSignInbtn();
		hp=new HomePage(browser);
		browser.getWait().HardPause(3000);
		hp.isLoginSuccessfull();
}
	
// adding the item into cart
	@Test(priority=2)
	public void addToCart()
	{
		browser.getWait().implicitWait(3000);
		report.info("Adding item into cart");
		hp=new HomePage(browser);
		addcartpg=new AddToCartPage(browser);
		hp.clickHomeIcon();
		hp.clickTshirtsLink();
		browser.getWait().HardPause(3000);
		hp.clickOnProduct();
		browser.getWait().HardPause(3000);
		addcartpg.clickAddToCartBtn();
	}
	
// checking out the selected product
	@Test(priority=3)
	public void performCheckout()
	{	
		browser.getWait().implicitWait(2000);
		chkoutpg=new CheckoutPage(browser);
		browser.getWait().HardPause(3000);
		chkoutpg.clickProceedToCheckOut();
		chkoutpg.clickChkOutOnSummaryPage();
		chkoutpg.checkOutAddress();
		//browser.getWait().HardPause(3000);
		chkoutpg.checkoutShipping();
		
	}
	
// paying the order by check and confirming the order
	@Test(priority=4)
	public void confirmOrder()
	{
		browser.getWait().implicitWait(2000);
		paypage=new PaymentPage(browser);
		paypage.clickPayByCheck();
		paypage.clickConfirmOrder();
		paypage.verifyOrderPlaced();	
	}
	
}
