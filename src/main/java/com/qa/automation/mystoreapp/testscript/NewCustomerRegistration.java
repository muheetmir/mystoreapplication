package com.qa.automation.mystoreapp.testscript;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

import com.qa.automation.mystoreapp.dataprovider.ExcelReader;
import com.qa.automation.mystoreapp.pages.HomePage;
import com.qa.automation.mystoreapp.pages.LoginPage;
import com.qa.automation.mystoreapp.pages.RegistrationPage;


import com.qa.automation.mystoreapp.config.MyStoreAppConstants;
import com.qa.automation.mystoreapp.testsuite.TestSuiteBase;

/*
 * this class is used to register a new member
 */
public class NewCustomerRegistration extends TestSuiteBase{

	private ReportLogService report = new ReportLogServiceImpl(NewCustomerRegistration.class); 
	ExcelReader testData = new ExcelReader();
	RegistrationPage regpage ;
	LoginPage lp;
	HomePage hp;

	String testDataFilePath = MyStoreAppConstants.TESTDATA_EXCELFILE_PATH; // path of the excel file
	String testDataSheetName = "Registration"; // name of the sheet in excel file.
	
// launching the application.
	@BeforeClass
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	public void openMyStoreShoppingPage(String os, String osVersion, String br, String browserVersion)  {		
		
		regpage = new RegistrationPage(browser);
		lp=new LoginPage(browser);
		report.info("Opening browser: "+ br);
		browser.openURL("http://automationpractice.com/index.php", os, osVersion, br, browserVersion);
		browser.getWait().HardPause(2000);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
		hp=new HomePage(browser);
	
	

	}

	@DataProvider(name = "testdata")
	public Object[][] getTestData() {
		Object[][] testdata1=testData.Registrationdata(testDataFilePath, testDataSheetName);
		return testdata1;
	}

 // this method will read the data from excel file and perform actions on fields on registration page by using data provider.
	
	@Test(dataProvider = "testdata")
	public void RegisterMember(String emailAddress,String firstname, String lastname, String password,String address,String city,String postcode,String mobilenumber) {

		report.info("Register a new customer ");
		browser.getWait().implicitWait(500);
		lp.clickSignInLink();
		regpage.enterEmailAddress(emailAddress);
		regpage.clickOnCreateAccountButton();
		regpage.enterCustomerFirstName(firstname);
		regpage.enterCustomerLastName(lastname);
		regpage.enterPassword(password);
		regpage.selectDays();
		regpage.selectMonths();
		regpage.selectYears();
		regpage.enterAddress1(address);
		regpage.enterCity(city);
		regpage.enterState();
		regpage.enterPostCode(postcode);
		regpage.enterCountry();
		regpage.enterMobileNumber(mobilenumber);
		regpage.clickOnRegisterButton();
		hp.clickSignOut();

	}		  

}
