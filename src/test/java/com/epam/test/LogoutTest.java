package com.epam.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.date.TestData;
import com.epam.pages.LoginPage;
import com.epam.pages.MainMailPage;

/**
 * @author kedr
 * 
 *         The test checks the Logout system
 */
public class LogoutTest {
	// Initialization driver
	private WebDriver driver = new FirefoxDriver();
	// Create an instance of the Main Mail page
	MainMailPage mailMailPlace = new MainMailPage(driver);
	// Create an instance of the login page
	LoginPage loginPlace = new LoginPage(driver);

	/**
	 * Actions before starting the test class
	 */
	@BeforeMethod
	public void startBrowser() {
		// Time waiting objects on the page
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// Open the window
		driver.manage().window().maximize();
		// Going to pages
		driver.get(TestData.url);
		// Enter login
		loginPlace.inputName(TestData.login);
		// Enter password
		loginPlace.inputPassword(TestData.password);
		// Log in
		loginPlace.pressButtonInput();
		// Go to home page mail
		loginPlace.pressButtonOpenMail();
	}

	/**
	 * Actions after the test class
	 */
	@AfterMethod
	public void closeBrowser() {
		// Close Browser
		driver.close();
	}

	/**
	 * The test checks the Logout system
	 */
	@Test
	public void logout() {
		System.out.println("Test 4 Logout from system");
		mailMailPlace.signOut();
		Assert.assertTrue(loginPlace.isUserNameDisplayed(), "Logon failure occurred");
	}
}
