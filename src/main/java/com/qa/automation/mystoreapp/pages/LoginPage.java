package com.qa.automation.mystoreapp.pages;

import java.util.Properties;



import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.falcon.automation.verifyresult.VerificationManager;
import com.google.common.base.Verify;
import com.qa.automation.mystoreapp.config.MyStoreAppConstants;
import com.qa.automation.mystoreapp.helper.MyStoreAppHelper;




public class LoginPage extends MyStoreAppHelper {
		
	 Browser browser;
		
		
private ReportLogService report=new ReportLogServiceImpl(LoginPage.class);

	static Properties page=loadProperties(MyStoreAppConstants.propertiesfile);


		
	public LoginPage(Browser browser)
	{
			this.browser=browser;
	}
	
	public void clickSignInLink()
	{	
		report.info("sign into the application");
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
		String signbtn=page.getProperty("signinbtn_id");
		browser.getClick().performClick(LocatorType.ID, signbtn);
	}
	
	public void isLoginSuccessfull()
	{
		String uname=page.getProperty("user_first_last_name_xpath");
		String first_last_name=browser.getFindFromBrowser().findElementByXpath(uname).getText();
		VerificationManager.verifyString(first_last_name, "aaa zzz", "verifying user first and last name");
	}
	
	
}
