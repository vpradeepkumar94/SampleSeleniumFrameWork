package com.tests.demoqa;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.datatables.demoqa.DataTable;
import com.pagegenerator.demoqa.Page;
import com.pojos.demoqa.Customer;
import com.testbase.demoqa.BrowserFactory;
import com.utils.demoqa.Utils;

public class TC_RegistrationPage extends BrowserFactory {

	private final Logger Log = Utils.getLogger(TC_RegistrationPage.class);

	@Test(description = "Verifies whether Register  link is displayed")
	public void TC001_navigateToRegisterPage() {

		boolean actualValue = Page.registrationPage.isRegistrationFormOpened();
		
		Log.info("Registration Page navigated");
		
		Assert.assertTrue(actualValue);
	}

	@Parameters({ "DataTableFileName" })
	@Test(description = "Get the Customer details from Data table in Pojo form and fill the Registration form")
	public void TC002_fillRegistrationForm(String DataTableFileName) {

		final String customerId = "TC001";

		Customer customer = null;
		try {
			customer = DataTable.readExcelFile(DataTableFileName, customerId);
		} catch (IOException e) {
			System.out.println("Unable to get data from excel file.Please see log for more details");
			Log.error("Error occured while retrieving data from excel " + e);
		}
		Log.info("Obtained Customer details form Data Table");
		
		Page.registrationPage.fillRegistrationForm(customer);
	
		Assert.assertTrue(Page.registrationPage.isFormSubmittedSuccesfully());

	}

}
