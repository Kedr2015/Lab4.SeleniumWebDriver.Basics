package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * @author kedr
 *
 *         New Mail page. Locators and work with them
 */
public class NewMailPage extends MainMailPage {
	/**
	 * @param driver
	 *            -webdriver Transfer driver instance in the constructor
	 */
	public NewMailPage(WebDriver driver) {
		super(driver);
	}

	// The recipient of the letter
	By toMail = By.xpath(".//*[@id='to']");
	// subject mail
	By subjectMail = By.xpath(".//*[@id='subject']");
	// Text mail
	By textMail = By.xpath(".//*[@id='compose_text']");
	// Conservation Letters to drafts
	By saveNewMailButton = By.xpath(".//div[@class='textfield']//a[@class='compose-save']");
	// The mark about saving
	By infoSave = By.xpath(
			".//div[@class='header clearfix']//span[@class='compose-draft-info'][contains(text() , 'сохранено')]");

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
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Checking mark about saving
	 */
	public boolean isInfoSaveInscription() {
		try {
			return driver.findElement(infoSave).isEnabled();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
