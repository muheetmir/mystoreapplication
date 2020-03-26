package com.qa.automation.mystoreapp.pages;

import java.util.Properties;
import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.qa.automation.mystoreapp.config.MyStoreAppConstants;
import com.qa.automation.mystoreapp.helper.MyStoreAppHelper;

public class PaymentPage extends MyStoreAppHelper{
	Browser browser;
	
	private ReportLogService report=new ReportLogServiceImpl(PaymentPage.class);

	static Properties paymentprop=loadProperties(MyStoreAppConstants.loginpagefile);
	
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
	
	

	
	
	
	
	
}
