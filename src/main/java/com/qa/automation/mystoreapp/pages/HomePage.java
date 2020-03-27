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

public class HomePage extends MyStoreAppHelper{
	Browser browser;
	
	JavascriptExecutor executor;
	private ReportLogService report=new ReportLogServiceImpl(HomePage.class);

	static Properties homepageprop=loadProperties(MyStoreAppConstants.propertiesfile);
	
	public HomePage(Browser browser)
	{
		
		this.browser=browser;
	}
	
	public void clickHomeIcon()
	{
		String homeicon=homepageprop.getProperty("homepageicon_xpath");
		browser.getClick().performClick(LocatorType.XPATH, homeicon);	
	}
	
	public void clickTshirtsLink()
	{
		String tshirtlink=homepageprop.getProperty("T-shirts_link_xpath");
		browser.getClick().performClick(LocatorType.XPATH, tshirtlink);
	}
	
	public void mouseOverProduct()
	{
		WebElement productitem=browser.getDriver().findElement(By.xpath("//div[@class='product-container']"));
		browser.getMouse().mouseHover(productitem);
	}
	
	public void clickOnMore()
	{
		String btnmore=homepageprop.getProperty("btnmore_xpath");
		browser.getClick().performClick(LocatorType.XPATH, btnmore);
	}
	
	public void clickAddToCartBtn()
	{	
		String btnaddtocart=homepageprop.getProperty("btnaddtocart_name");
		browser.getClick().performClick(LocatorType.NAME, btnaddtocart);
	}
	
	
	
	

	
	
	
	
	
}
