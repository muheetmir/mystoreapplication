package com.qa.automation.mystoreapp.pages;

import java.util.Properties;
import org.openqa.selenium.WebElement;
import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.qa.automation.mystoreapp.config.MyStoreAppConstants;
import com.qa.automation.mystoreapp.utilities.MyStoreUtility;

/**
 * this class contains the methods to register a member.
 * @author mir.ali
 *
 */
public class RegistrationPage {
	
	private ReportLogService report = new ReportLogServiceImpl(RegistrationPage.class);
	public static Properties props =MyStoreUtility.loadProperties(MyStoreAppConstants.REGISTRATION_PROPERTIES);	
	Browser browser;
	public RegistrationPage(Browser browser) {
		this.browser = browser;	
	}

	
	  //All the below get methods are used to get the data from file which is used as part of test data
	 
		
	private WebElement getEmailAddress() {
		return browser.getFindFromBrowser().findElementByXpath(props.getProperty("txtemailAddress"));		
	}
	
	private WebElement getCreateAccountButton() {
		return browser.getFindFromBrowser().findElementByXpath(props.getProperty("btnCreateAnAccount"));		
	}
	
	private WebElement getGender() {
		return browser.getFindFromBrowser().findElementByXpath(props.getProperty("rdGender"));		
	}
	private WebElement getCustomerFirstName() {
		return browser.getFindFromBrowser().findElementByXpath(props.getProperty("txtCustomerFirstname"));		
	}
	
	private WebElement getCustomerLastName() {
		return browser.getFindFromBrowser().findElementByXpath(props.getProperty("txtCustomerLastname"));		
	}

	private WebElement getPassword() {
		return browser.getFindFromBrowser().findElementByXpath(props.getProperty("txtPassword"));		
	}

		
	private WebElement getAddress1() {
		return browser.getFindFromBrowser().findElementByXpath(props.getProperty("txtAddress1"));		
	}
	
	
	private WebElement getCity() {
		return browser.getFindFromBrowser().findElementByXpath(props.getProperty("txtCity"));		
	}
	
	private WebElement getPostCode() {
		return browser.getFindFromBrowser().findElementByXpath(props.getProperty("txtPostCode"));		
	}
	
	private WebElement getMobileNumber() {
		return browser.getFindFromBrowser().findElementByXpath(props.getProperty("txtMobilenumber"));		
	}
	
	private WebElement getAlias() {
		return browser.getFindFromBrowser().findElementByXpath(props.getProperty("txtAlias"));		
	}
	
	private WebElement getRegister() {
		return browser.getFindFromBrowser().findElementByXpath(props.getProperty("btnRegister"));		
	}

	/**
	 * this method enters the text into email address field
	 * @param emailAddress read the data from file and enter into the emailaddress field
	 */
public void enterEmailAddress(String emailAddress) {
	report.info("Enter Email Address");
	browser.getWait().implicitWait(20000);
	getEmailAddress().sendKeys(emailAddress);
}

/**
 * this method clicks on the create account button
 */

public void clickOnCreateAccountButton() {
	report.info("Click on create button");
	browser.getWait().implicitWait(20000);
	getCreateAccountButton().click();
}

/**
 * this method clicks on one of the gender radio buton
 */
public void clickGenderRadioButton() {
	report.info("Click on create button");
	browser.getWait().implicitWait(20000);
	getGender().click();
}
/**
 * this method enter the text into First name text field
 * @param firstname read the first name from file and enters into the field.
 */

public void enterCustomerFirstName(String firstname) {
	report.info("Enter Customer First name");
	browser.getWait().implicitWait(20000);
	getCustomerFirstName().sendKeys(firstname);
}
/**
 * this method enters the text into last name field.
 * @param lastname reads the data from file and enters into the field
 */

public void enterCustomerLastName(String lastname) {
	report.info("Enter Customer Last name");
	browser.getWait().implicitWait(20000);
	getCustomerLastName().sendKeys(lastname);
}
/**
 * this method enters the text into the password field
 * @param password reads the data form fiel and enters into field
 */
public void enterPassword(String password) {
	report.info("Enter Customer Password");
	browser.getWait().implicitWait(20000);
	getPassword().sendKeys(password);
}

/**
 * this method selects the respective day by selecting the days drop down.
 */
public void selectDays() {
	report.info("Select Day");
	browser.getWait().implicitWait(20000);
	browser.getSelectDropDown().selectByIndex(LocatorType.ID, "days", 4);

}

/**
 * this method selects the respective month by selecting the months drop down.
 */
public void selectMonths() {
	report.info("Select Month");
	browser.getWait().implicitWait(20000);
	browser.getSelectDropDown().selectByIndex(LocatorType.ID, "months", 4);

}

/**
 * this method selects the respective year by selecting the years drop down.
 */
public void selectYears() {
	report.info("Select Year");


browser.getSelectDropDown().selectByIndex(LocatorType.ID, "years", 4);

}

/**
 * this method enter text into address field
 * @param address read the data from file.
 */
public void enterAddress1(String address) {
	report.info("Enter Address1");
	browser.getWait().implicitWait(20000);
	getAddress1().sendKeys(address);
}

/**
 * this method enters city into the city field
 * @param city reads the data from file
 */
public void enterCity(String city) {
	report.info("Enter City");
	browser.getWait().implicitWait(20000);
	getCity().sendKeys(city);
}

/**
 * this method enters the text into state field.
 */
public void enterState() {
	report.info("Enter State");
	browser.getWait().implicitWait(20000);
	browser.getSelectDropDown().selectByIndex(LocatorType.ID, "id_state", 3);
}

/**
 * this method enters the text into the country field
 */
public void enterCountry() {
	report.info("Enter Country");
	browser.getWait().implicitWait(20000);
	browser.getSelectDropDown().selectByIndex(LocatorType.ID, "id_country", 1);	
}

/**
 * this method enters the text into the mobile number field
 * @param mobilenumber read the data from file
 */
public void enterMobileNumber(String mobilenumber) {
	report.info("Enter Mobile number");
	browser.getWait().implicitWait(20000);
	getMobileNumber().sendKeys(mobilenumber);
}

/**
 * this method enters the text into post code field
 * @param postcode read the data from file.
 */
public void enterPostCode(String postcode) {
	report.info("Enter Post coder");
	browser.getWait().implicitWait(20000);
	getPostCode().sendKeys(postcode);
}

/**
 * this method enter the text into Alias field
 * @param alias read the data from file
 */
public void enterAlias(String alias) {
	report.info("Enter Alias");
	browser.getWait().implicitWait(20000);
	getAlias().sendKeys(alias);
}

/**
 * this method clicks on register button
 */
public void clickOnRegisterButton() {
	report.info("Enter Register Button");
	browser.getWait().implicitWait(20000);
	getRegister().click();
}



}
