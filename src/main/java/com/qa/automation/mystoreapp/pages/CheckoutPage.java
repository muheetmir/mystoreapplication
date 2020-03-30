package com.qa.automation.mystoreapp.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.qa.automation.mystoreapp.config.MyStoreAppConstants;
import com.qa.automation.mystoreapp.utilities.MyStoreUtility;

/**
 * this class contains the elements of checkout page and methods to perform checkout for placing the order
 * and it extends the MyStoreUtility class
 * @author mir.ali
 *
 */
public class CheckoutPage extends MyStoreUtility{
	Browser browser;
	JavascriptExecutor executor;
	private ReportLogService report=new ReportLogServiceImpl(CheckoutPage.class);

	static Properties checkoutprop=loadProperties(MyStoreAppConstants.PROPERTIES_FILE);
	
	public CheckoutPage(Browser browser)
	{
		this.browser=browser;
	}
	
	public void clickProceedToCheckOut()
	{
		report.info("click on proceed to checkout button");
		WebElement proceedtochkoutbtn=browser.getDriver().findElement(By.xpath("//a[contains(@class,'button-medium')]"));
		executor=(JavascriptExecutor)browser.getDriver();
		executor.executeScript("arguments[0].click();",proceedtochkoutbtn);
	}
	
	public void clickChkOutOnSummaryPage()
	{	
		report.info("clicking on proceed to checkout button on summary page");
		String chkoutsummarybtn=checkoutprop.getProperty("summarycheckout_xpath");
		browser.getClick().performClick(LocatorType.XPATH, chkoutsummarybtn);	
	}
	
	public void checkOutAddress()
	{
		report.info("click on proceed to checkout button on address page");
		String chkoutaddress=checkoutprop.getProperty("checkoutaddress_name");
		browser.getClick().performClick(LocatorType.NAME, chkoutaddress);
	}
	
	public void checkoutShipping()
	{	
		String termsofservice=checkoutprop.getProperty("chkboxTermsofservice");
		browser.getWait().HardPause(2000);
		report.info("Accept the terms and conditions");
		browser.getClick().performClick(LocatorType.XPATH, termsofservice);
		report.info("click on checkout button");
		String chkoutshipping=checkoutprop.getProperty("checkoutshipping_name");
		browser.getClick().performClick(LocatorType.NAME, chkoutshipping);
	}
	
	
	

	
	
	
	
	
}
