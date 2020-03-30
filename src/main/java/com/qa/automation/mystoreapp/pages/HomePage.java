package com.qa.automation.mystoreapp.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.verifyresult.VerificationManager;
import com.qa.automation.mystoreapp.config.MyStoreAppConstants;
import com.qa.automation.mystoreapp.utilities.MyStoreUtility;
/**
 * it contains methods which are used to perform actions on home page elements.
 * @author mir.ali
 *
 */
public class HomePage extends MyStoreUtility{
	Browser browser;
	JavascriptExecutor js;
	
	static Properties homepageprop=loadProperties(MyStoreAppConstants.PROPERTIES_FILE);
	
	public HomePage(Browser browser)
	{
		
		this.browser=browser;
	}
	
	//verifying the user authentication after login 
	public void isLoginSuccessfull()
	{
		String uname=homepageprop.getProperty("user_first_last_name_xpath");
		String fn_ln=browser.getFindFromBrowser().findElementByXpath(uname).getText();
		VerificationManager.verifyString(fn_ln, "aaa zzz", "verifying user first and last name");
	}
	
	//clicking on home icon button
	public void clickHomeIcon()
	{
		
		String homeicon=homepageprop.getProperty("homepageicon_xpath");
		browser.getClick().performClick(LocatorType.XPATH, homeicon);	
	}
	
	// clicking on T-shirts link
	public void clickTshirtsLink()
	{
		
		String tshirtlink=homepageprop.getProperty("T-shirts_link_xpath");
		browser.getClick().performClick(LocatorType.XPATH, tshirtlink);
	}
	
	// Hover mouse over the product
	public void clickOnProduct()
	{	
		browser.getWait().HardPause(2000);
		String prditem=homepageprop.getProperty("product_item_xpath");
		WebElement productitem=browser.getDriver().findElement(By.xpath("//div[@class='product-container']"));
		browser.getMouse().mouseHover(productitem);
		browser.getClick().performClick(LocatorType.XPATH, prditem);
	}
	
	
	
	//click on sign out
	public void clickSignOut()
	{
		String signout=homepageprop.getProperty("btnsignout");
		browser.getClick().performClick(LocatorType.XPATH, signout);
	}
	
	
	

	
	
	
	
	
}
