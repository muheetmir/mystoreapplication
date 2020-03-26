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
import com.qa.automation.mystoreapp.helper.MyStoreAppHelper;

public class AddToCartPage extends MyStoreAppHelper{
	Browser browser;
	
	JavascriptExecutor executor;
	private ReportLogService report=new ReportLogServiceImpl(AddToCartPage.class);

	static Properties addtocartprop=loadProperties(MyStoreAppConstants.loginpagefile);
	
	public AddToCartPage(Browser browser)
	{
		
		this.browser=browser;
	}
	
	public void mouseOverProduct()
	{
		WebElement productitem=browser.getDriver().findElement(By.xpath("//div[@class='product-container']"));
		browser.getMouse().mouseHover(productitem);
	}
	
	public void clickOnMore()
	{
		String btnmore=addtocartprop.getProperty("btnmore_xpath");
		browser.getClick().performClick(LocatorType.XPATH, btnmore);
	}
	
	public void clickAddToCartBtn()
	{
		String btnaddtocart=addtocartprop.getProperty("btnaddtocart_name");
		browser.getClick().performClick(LocatorType.NAME, btnaddtocart);
	}
	
	
	
	

	
	
	
	
	
}
