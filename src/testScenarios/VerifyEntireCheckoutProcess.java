package testScenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import automationTest.driver_connection;
import automationTest.registration;
import automationTest.checkoutprocess;

public class VerifyEntireCheckoutProcess extends driver_connection {

	registration registration;
	checkoutprocess checkout;
	String firstName = "test";
	String lastName = "lastTest";
	String emailAddress = System.currentTimeMillis() + "@gmail.com";
	String password = "password";

	@BeforeClass
	public void setUp() throws IOException {

	}

	@Test
	public void verifyCheckoutProcess() {
		try {
			getDriver();
			registration = new registration(driver);
			checkout = new checkoutprocess(driver);
			registration.registorUser(firstName, lastName, emailAddress, password);
			registration.clickOnLogout();
			registration.loginToApplication(emailAddress, password);
			checkout.checkoutProcess();

		} catch (Exception e) {
			registration.switchToDefaultContent();
			Assert.assertTrue(false, "verifyCheckout");
		} finally {
			driver.quit();
		}
	}
}