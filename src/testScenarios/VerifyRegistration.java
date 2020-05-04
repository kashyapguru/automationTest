package testScenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import automationTest.driver_connection;
import automationTest.registration;

public class VerifyRegistration extends driver_connection{

	registration registration;
	String firstName = "test";
	String lastName = "lastTest";
	String emailAddress = System.currentTimeMillis() + "@gmail.com";
	String password = "password";
	
	@BeforeClass
	public void setUp() throws IOException {
		
	}

	@Test
	public void verifyRegistration() {
		try {
			getDriver();
			registration = new registration(driver);
			registration.registorUser(firstName, lastName, emailAddress, password);
		} catch (Exception e) {
			registration.switchToDefaultContent();
			Assert.assertTrue(false, "verifyRegistration");
		} finally {
			driver.quit();
		}
	}
}