package com.qa.automation.mystoreapp.pages;

import java.util.Properties;



import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

import com.qa.automation.mystoreapp.config.MyStoreAppConstants;
import com.qa.automation.mystoreapp.utilities.MyStoreUtility;

/**
 * this class contains the methods to perform the acitons on Sign in page of MyStore application
 * @author mir.ali
 *
 */
public class LoginPage extends MyStoreUtility {
		
	 Browser browser;
		
		
private ReportLogService report=new ReportLogServiceImpl(LoginPage.class);

static Properties page=loadProperties(MyStoreAppConstants.PROPERTIES_FILE);

	public LoginPage(Browser browser)
	{
			this.browser=browser;
	}
	public void clickSignInLink()
	{	
		report.info("clicking on sign in link");
		String signinlink=page.getProperty("signinLink");
		browser.getClick().performClick(LocatorType.XPATH, signinlink);	
	}
	public void enterUserName()
	{
		report.info("enter the user name");
		String username=page.getProperty("username_id");
		browser.getTextField().enterTextField(LocatorType.ID, username,"testapple063@gmail.com");
	}
	public void enterPassword()
	{	
		report.info("enter the password");
		String password=page.getProperty("password_id");
		browser.getTextField().enterTextField(LocatorType.ID, password, "product3109!");
	}
	
	public void clickSignInbtn()
	{
		report.info("click on sign in button");
		String signbtn=page.getProperty("btnsignin");
		browser.getClick().performClick(LocatorType.XPATH, signbtn);
		report.info("sign  in button is clicked");
	}
	
	
	
}
