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
 *         The test checks the Logout system
 */
public class LogoutTest {
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
	@AfterClass
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
		Assert.assertTrue(loginPlace.isUserName(), "Logon failure occurred");
	}
}
