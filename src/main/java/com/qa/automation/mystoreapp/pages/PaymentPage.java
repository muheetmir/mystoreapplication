package com.qa.automation.mystoreapp.pages;

import java.util.Properties;
import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.falcon.automation.verifyresult.VerificationManager;
import com.qa.automation.mystoreapp.config.MyStoreAppConstants;
import com.qa.automation.mystoreapp.helper.MyStoreAppHelper;

public class PaymentPage extends MyStoreAppHelper{
	Browser browser;
	
	private ReportLogService report=new ReportLogServiceImpl(PaymentPage.class);

	static Properties paymentprop=loadProperties(MyStoreAppConstants.propertiesfile);
	
	public PaymentPage(Browser browser)
	{
		this.browser=browser;
	}
	
	public void clickPayByCheck()
	{
		String chequepay=paymentprop.getProperty("chequepay_link_xpath");
		browser.getClick().performClick(LocatorType.XPATH, chequepay);
	}
	
	public void clickConfirmOrder()
	{
		String confirmorder=paymentprop.getProperty("confirmorderbtn_xpath");
		browser.getClick().performClick(LocatorType.XPATH, confirmorder);
	}
	
	public void verifyOrderPlaced()
	{
		String confirmordertext=paymentprop.getProperty("orderplacedmessage_xpath");
		String ordermesssage= browser.getFindFromBrowser().findElementByXpath(confirmordertext).getText();
		VerificationManager.verifyString(ordermesssage, "Your order on My Store is complete.", "verify order confirmaiton");
	}
	
	

	
	
	
	
	
}
