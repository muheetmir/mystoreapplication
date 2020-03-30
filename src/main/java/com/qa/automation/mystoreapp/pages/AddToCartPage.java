package com.qa.automation.mystoreapp.pages;

import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.qa.automation.mystoreapp.config.MyStoreAppConstants;
import com.qa.automation.mystoreapp.utilities.MyStoreUtility;

/**
 * It contains methods which are use to add the item into cart and it extends MyStoreUtility class.
 * @author mir.ali
 *
 */
public class AddToCartPage {
	Browser browser;
	
	JavascriptExecutor executor;
	private ReportLogService report=new ReportLogServiceImpl(AddToCartPage.class);

	static Properties addtocartprop=MyStoreUtility.loadProperties(MyStoreAppConstants.PROPERTIES_FILE);
	
	public AddToCartPage(Browser browser)
	{
		this.browser=browser;
	}
	
	
	// clicking on the add to cart button
	public void clickAddToCartBtn()
	{
		report.info("click on add to cart button");
		String btnaddtocart=addtocartprop.getProperty("btnaddtocart_name");
		browser.getClick().performClick(LocatorType.NAME, btnaddtocart);
		
	}
	
	// updating the quantity of the product selected on add to cart page
	public void updateQuantity(int quantity)
	{
		report.info("updating the item quantity");
		String qty=addtocartprop.getProperty("txtquantity");
		browser.getTextField().enterTextField(LocatorType.XPATH,qty,"quantity");
	}
	
	// updating the size of selected product at add to cart page.
	public void updateSize(String size)
	{
		report.info("updating the item size");
		String drpsize=addtocartprop.getProperty("drpitemsize");
		browser.getSelectDropDown().selectByVisibleText(LocatorType.XPATH, drpsize, size);
		
	}
	
	
	
	

	
	
	
	
	
}
