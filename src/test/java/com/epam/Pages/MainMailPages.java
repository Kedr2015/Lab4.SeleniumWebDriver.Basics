package com.epam.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

/**
 * @author kedr
 *
 *         Main Mail page. Locators and work with them
 */
public class MainMailPages {

    public WebDriver driver;// webdriver

    /**
     * @param driver
     *            Transfer driver instance in the constructor
     */
    public MainMailPages(WebDriver driver) {
	this.driver = driver;
    }

    By exitButton = By.xpath(".//a[@class='qwh_logout']");// Button exit
    By newMailButton = By.xpath(".//div[@id='left_Menu']//a[@href='/compose']");// Button
										// New
										// Mail
    By goToDraftsButton = By.xpath(".//a[2][@href='/~Draft;']");// Button go to
								// Drafts

    /**
     * Sign Out
     */
    public void signOut() {
	driver.findElement(exitButton).click();
	checkDialogBox();
    }

    /**
     * The method checks the opening of the Main Mail page
     * 
     * @return - The presence of the Button New Mail on the page
     */
    public boolean isNewMail() {
	try {
	    return driver.findElement(newMailButton).isDisplayed();
	} catch (RuntimeException e) {
	    return false;
	}
    }

    /**
     * Create a new message
     */
    public void pressButtonNewMail() {
	driver.findElement(newMailButton).click();
	checkDialogBox();
    }

    /**
     * Go to page drafts
     */
    public void openDrafts() {
	driver.findElement(goToDraftsButton).click();
	checkDialogBox();
    }

    /**
     * Bypass dialog
     */
    private void checkDialogBox() {
	try {
	    Alert alert = driver.switchTo().alert();
	    alert.accept();
	} catch (NoAlertPresentException ex) {
	}
    }
}
