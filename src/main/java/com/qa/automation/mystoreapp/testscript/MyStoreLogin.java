package com.qa.automation.mystoreapp.testscript;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.ui.seleniuminterfaces.IKeys.KeyType;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.qa.automation.mystoreapp.pages.LoginPage;
import com.qa.automation.mystoreapp.testsuite.TestSuiteBase;

public class MyStoreLogin extends TestSuiteBase{
	private ReportLogService report = new ReportLogServiceImpl(MyStoreLogin.class);
	LoginPage signin;
	
	@Test
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	public void signIntoMyStore(String os, String osVersion, String br, String browserVersion) {
		// write your first test script here
		// sample
		report.info("Opening browser: "+ br);
		browser.openURL("http://automationpractice.com/index.php?controller=authentication&back=my-account", os, osVersion, br, browserVersion);
		browser.getWait().HardPause(2000);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
		String mystoretitle=browser.getCurrentPageTitle();
		//Verify.verifyString(mystoretitle,"My Store", "Verifying the login page title");
			
		//signin.clickSignInLink();
		//browser.getWait().HardPause(3000);
		//browser.getTextField().enterTextField(LocatorType.ID, "email", "test");
		//browser.getClick().performClick(LocatorType.XPATH, "//li[contains(@id,'category-thumbnail')]//following::li//child::a[text()='T-shirts']");
		
		browser.getWait().HardPause(4000);
		signin.enterUserName();
		signin.enterPassword();
		signin.clickSignInbtn();

	}
	
	

}
