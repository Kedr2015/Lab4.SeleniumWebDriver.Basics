package com.epam.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.epam.date.TestData;
import com.epam.pages.DraftsMailPage;
import com.epam.pages.LoginPage;
import com.epam.pages.MainMailPage;
import com.epam.pages.NewMailPage;

/**
 * @author kedr
 * 
 *         The test checks the Logout system
 */
public class CreateAndSaveMessageTest {

	private WebDriver driver;
	MainMailPage mailMailPlace;
	LoginPage loginPlace;

	// Create an instance new mail page
	NewMailPage newMailPlace;
	// Create an instance drafts mail page
	DraftsMailPage DraftsMailPlace;

	/**
	 * Actions before starting the test class
	 */
	@BeforeTest
	public void startBrowser() {
		// Initialization driver
		driver = new FirefoxDriver();
		// Create an instance new mail page
		newMailPlace = new NewMailPage(driver);
		// Create an instance drafts mail page
		DraftsMailPlace = new DraftsMailPage(driver);
		// Create an instance of the login page
		loginPlace = new LoginPage(driver);

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
	@AfterTest
	public void closeBrowser() {
		// Sign Out
		newMailPlace.signOut();
		// Close Browser
		driver.close();

	}

	/**
	 * To validate the creation and preservation of his letters
	 * 
	 * @param to
	 *            - recipient
	 * @param subject
	 *            - subject mail
	 * @param text
	 *            - text of the letter
	 */
	@Test(dataProvider = "newMailData", dataProviderClass = TestData.class)
	public void saveMailTest(String to, String subject, String text) {
		System.out.println("Test 2.1 Create a new message");
		newMailPlace.pressButtonNewMail();
		Assert.assertTrue(newMailPlace.isFieldTo(), "Page to create a new letter is not open");
		System.out.println("Test 2.2 Fill in the fields and save the result\nRecipient = " + to + "\nSubject = "
				+ subject + "\nText mail = " + text);
		newMailPlace.inputToMail(to);
		newMailPlace.inputSubjectMail(subject);
		newMailPlace.inputTextMail(text);
		newMailPlace.saveMail();
		Assert.assertTrue(newMailPlace.isInfoSaveInscription(), "The letter is not saved");
	}

	/**
	 * Check previously saved letter
	 * 
	 * @param to
	 *            - recipient
	 * @param subject
	 *            - subject mail
	 * @param text
	 *            - text of the letter
	 */
	@Test(dataProvider = "newMailData", dependsOnMethods = "saveMailTest", dataProviderClass = TestData.class)
	public void checkDrafts(String to, String subject, String text) {
		System.out.println(
				"Test 3 Check stored emails\nRecipient = " + to + "\nSubject = " + subject + "\nText mail = " + text);
		newMailPlace.openDrafts();
		Assert.assertTrue(DraftsMailPlace.checkForDrafts(subject, text),
				"The draft has not been preserved\nWith options:\nRecipient = " + to + "\nSubject = " + subject
						+ "\nText mail = " + text);
	}
}
