package com.epam.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.epam.Pages.DraftsMailPages;
import com.epam.Pages.LoginPages;
import com.epam.Pages.NewMailPages;
import com.epam.date.TestData;

/**
 * @author kedr
 * 
 *         The test checks the Logout system
 */
public class CreateAndSaveMessageTest {
    private WebDriver driver = new FirefoxDriver();// Initialization driver

    LoginPages loginPlace = new LoginPages(driver);// Create an instance of the
    // login page
    NewMailPages newMailPlace = new NewMailPages(driver);// Create an instance
							 // new mail page
    DraftsMailPages DraftsMailPlace = new DraftsMailPages(driver);// Create an
								  // instance
								  // drafts mail
								  // page

    /**
     * 
     * The input data for the test.
     * 
     * @return - the recipient, subject and text of the letter
     */
    @DataProvider
    public static Object[][] newMailData() {
	return new Object[][] { { "varchenko.nikita.v@mail.ru", "Test2", "Test3" },
		{ "varchenko.nikita.v@gmail.com", "Test2Test", "Test3Test" }

	};
    }

    /**
     * Actions before starting the test class
     */
    @BeforeClass
    public void startBrowser() {
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);// Time
									// waiting
									// objects
									// on
									// the
									// page
	driver.manage().window().maximize();// Open the window
	driver.get(TestData.url);// Going to pages
	loginPlace.inputName(TestData.login);// Enter login
	loginPlace.inputPassword(TestData.password);// Enter password
	loginPlace.pressButtonInput();// Log in
	loginPlace.pressButtonOpenMail();// Go to home page mail
    }

    /**
     * Actions after the test class
     */
    @AfterClass
    public void closeBrowser() {
	newMailPlace.signOut();// Sign Out
	driver.close();// Close Browser

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
    @Test(dataProvider = "newMailData")
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
	Assert.assertTrue(newMailPlace.isInfoSave(), "The letter is not saved");
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
    @Test(dataProvider = "newMailData", dependsOnMethods = "saveMailTest")
    public void checkDrafts(String to, String subject, String text) {
	System.out.println(
		"Test 3 Check stored emails\nRecipient = " + to + "\nSubject = " + subject + "\nText mail = " + text);
	newMailPlace.openDrafts();
	Assert.assertTrue(DraftsMailPlace.CheckForDrafts(subject, text),
		"The draft has not been preserved\nWith options:\nRecipient = " + to + "\nSubject = " + subject
			+ "\nText mail = " + text);
    }
}
