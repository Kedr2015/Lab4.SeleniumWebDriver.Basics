package com.epam.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.epam.date.TestData;
import com.epam.pages.LoginPage;
import com.epam.pages.MainMailPage;

/**
 * @author kedr
 * 
 *         The test checks the authorization system
 */
public class LoginTest {

	private WebDriver driver;
	MainMailPage mailMailPlace;
	LoginPage loginPlace;

	/**
	 * Actions before starting the test class
	 */
	@BeforeTest
	public void startBrowser() {
		// Initialization driver
		driver = new FirefoxDriver();
		// Create an instance of the Main Mail page
		mailMailPlace = new MainMailPage(driver);
		// Create an instance of the login page
		loginPlace = new LoginPage(driver);
		// Time waiting objects on the page
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// Open the window
		driver.manage().window().maximize();
		// Going to pages
		driver.get(TestData.url);
	}

	/**
	 * Actions after the test class
	 */
	@AfterTest
	public void closeBrowser() {
		// Sign Out
		mailMailPlace.signOut();
		// Close Browser
		driver.close();

	}

	/**
	 * The test checks the authorization system
	 */
	@Test
	public void authTest() {
		System.out.println(
				"Test 1 Authorize in system\nUser = " + TestData.login + " and password = " + TestData.password);
		loginPlace.inputName(TestData.login);
		loginPlace.inputPassword(TestData.password);
		loginPlace.pressButtonInput();
		loginPlace.pressButtonOpenMail();
		Assert.assertTrue(mailMailPlace.isNewMailDisplayed(), "Logon failure occurred");
	}

}
