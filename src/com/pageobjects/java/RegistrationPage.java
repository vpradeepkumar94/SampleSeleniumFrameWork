package com.pageobjects.java;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pojos.demoqa.Customer;
import com.testbase.demoqa.BrowserFactory;
import com.testbase.demoqa.DropDown;

public class RegistrationPage extends BrowserFactory {

	private final WebDriver driver = super.driver;

	@FindBy(how = How.ID, using = "q")
	private WebElement txtFirstName;
	@FindBy(how = How.CSS, using = "css")
	private WebElement txtLastName;
	@FindBy(how = How.CSS, using = "css")
	private WebElement txtAge;
	@FindBy(how = How.CSS, using = "css")
	private WebElement txtGender;
	@FindBy(how = How.CSS, using = "css")
	private WebElement txtMobileNumber;
	@FindBy(how = How.CSS, using = "css")
	private WebElement radiobtnVoterId;
	@FindBy(how = How.LINK_TEXT, using = "Register")
	private WebElement registrationLink;
	@FindBy(how = How.TAG_NAME, using = "h2")
	private WebElement formSubmitedSuccessfullyMessage;

	@FindBys({@FindBy(how =How.CLASS_NAME,using = "checkbox_5[]")})
	private List<WebElement> checkbox;
	@FindBys({@FindBy(how =How.CLASS_NAME,using = "radio_4[]")})
	private List<WebElement> gender;
	@FindBy(how =How.CLASS_NAME,using = "dropdown_6_5[]")
	private WebElement country;

	public void fillRegistrationForm(Customer customer) {

		txtFirstName.sendKeys(customer.getFirstName());
		txtLastName.sendKeys(customer.getLastName());
		txtAge.sendKeys(Integer.toString(customer.getAge() ) );
		
		super.selectFromDropDown(country, customer.getCountry(), DropDown.VISBILE_TEXT);
		
		super.selectCheckBox(checkbox, customer.getHobby());
		
		super.selectFromRadioButton(gender, customer.getGender());
	}

	public boolean isRegistrationFormOpened() {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(registrationLink));

		try {
			return registrationLink.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public boolean isFormSubmittedSuccesfully() {
		
		String message  = formSubmitedSuccessfullyMessage.getText();
		return (message.contains("Form Submitted Successfully") )? true : false ;
	}

}
