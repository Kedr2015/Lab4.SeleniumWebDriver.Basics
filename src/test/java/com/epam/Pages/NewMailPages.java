package com.epam.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author kedr
 *
 *         New Mail page. Locators and work with them
 */
public class NewMailPages extends MainMailPages {
    /**
     * @param driver
     *            -webdriver Transfer driver instance in the constructor
     */
    public NewMailPages(WebDriver driver) {
	super(driver);
    }

    By toMail = By.xpath(".//*[@id='to']");// The recipient of the letter
    By subjectMail = By.xpath(".//*[@id='subject']");// subject mail
    By textMail = By.xpath(".//*[@id='compose_text']");// Text mail
    By saveNewMailButton = By.xpath(".//div[@class='textfield']//a[@class='compose-save']");// Conservation
											    // Letters
											    // to
											    // drafts
    By infoSave = By.xpath(
	    ".//div[@class='header clearfix']//span[@class='compose-draft-info'][contains(text() , 'сохранено')]");// The
														   // mark
														   // about
														   // saving

    /**
     * Enter a destination
     * 
     * @param to
     *            - recipient
     */
    public void inputToMail(String to) {

	driver.findElement(toMail).sendKeys(to);
    }

    /**
     * Enter subject
     * 
     * @param subject
     *            - subject mail
     */
    public void inputSubjectMail(String subject) {

	driver.findElement(subjectMail).sendKeys(subject);
    }

    public void inputTextMail(String text) {

	driver.findElement(textMail).sendKeys(text);
    }

    /**
     * Save mail
     */
    public void saveMail() {

	driver.findElement(saveNewMailButton).click();
    }

    /**
     * The method checks the opening of the New Mail page
     * 
     * @return - The presence of the field To on the page
     */
    public boolean isFieldTo() {
	try {
	    return driver.findElement(toMail).isDisplayed();
	} catch (RuntimeException e) {
	    return false;
	}
    }

    /**
     * Checking mark about saving
     */
    public boolean isInfoSave() {
	try {
	    return driver.findElement(infoSave).isEnabled();
	} catch (RuntimeException e) {
	    return false;
	}
    }

}
