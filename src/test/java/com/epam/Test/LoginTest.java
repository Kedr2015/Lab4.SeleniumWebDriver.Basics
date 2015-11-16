package com.epam.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.Pages.LoginPages;
import com.epam.Pages.MainMailPages;
import com.epam.date.TestData;

/**
 * @author kedr
 * 
 *         The test checks the authorization system
 */
public class LoginTest {
	// Initialization driver
	private WebDriver driver = new FirefoxDriver();
	// Create an instance of the Main Mail page
	MainMailPages mailMailPlace = new MainMailPages(driver);
	// Create an instance of the login page
	LoginPages loginPlace = new LoginPages(driver);

	/**
	 * Actions before starting the test class
	 */
	@BeforeClass
	public void startBrowser() {
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
	@AfterClass
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
		Assert.assertTrue(mailMailPlace.isNewMail(), "Logon failure occurred");
	}

}
