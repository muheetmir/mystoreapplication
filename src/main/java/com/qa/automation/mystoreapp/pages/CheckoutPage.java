package com.qa.automation.mystoreapp.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.ui.seleniuminterfaces.ICheckBox.SelectType;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.qa.automation.mystoreapp.config.MyStoreAppConstants;
import com.qa.automation.mystoreapp.helper.MyStoreAppHelper;

public class CheckoutPage extends MyStoreAppHelper{
	Browser browser;
	
	JavascriptExecutor executor;
	private ReportLogService report=new ReportLogServiceImpl(CheckoutPage.class);

	static Properties checkoutprop=loadProperties(MyStoreAppConstants.propertiesfile);
	
	public CheckoutPage(Browser browser)
	{
		this.browser=browser;
	}
	
	public void clickProceedToCheckOut()
	{
		WebElement proceedtochkoutbtn=browser.getDriver().findElement(By.xpath("//a[contains(@class,'button-medium')]"));
		executor=(JavascriptExecutor)browser.getDriver();
		executor.executeScript("arguments[0].click();",proceedtochkoutbtn);
	}
	
	public void clickChkOutOnSummaryPage()
	{
		String chkoutsummarybtn=checkoutprop.getProperty("summarycheckout_xpath");
		browser.getClick().performClick(LocatorType.XPATH, chkoutsummarybtn);	
	}
	
	public void checkOutAddress()
	{
		String chkoutaddress=checkoutprop.getProperty("checkoutaddress_name");
		browser.getClick().performClick(LocatorType.NAME, chkoutaddress);
	}
	
	public void checkoutShipping()
	{	
		String termsofservice=checkoutprop.getProperty("Termsofservice_id");
		browser.getWait().HardPause(2000);
		browser.getCheckBox().clickCheckBoxById(LocatorType.ID, termsofservice, SelectType.CHECK);
		String chkoutshipping=checkoutprop.getProperty("checkoutshipping_name");
		browser.getClick().performClick(LocatorType.NAME, chkoutshipping);
	}
	
	
	

	
	
	
	
	
}
