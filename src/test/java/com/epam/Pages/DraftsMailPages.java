package com.epam.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author kedr Drafts Mail page. Locators and work with them
 */
public class DraftsMailPages extends MainMailPages {
    /**
     * @param driver
     *            -webdriver Transfer driver instance in the constructor
     */
    public DraftsMailPages(WebDriver driver) {
	super(driver);
    }

    private String identificationDraft = ".//div[@class='figlist']//div[@class='theme']/a[text()='%s']/span[text()='- %s']";// Mask
															    // Search
															    // saved
															    // messages

    /**
     * The method checks the messages on the page for the input parameters
     * 
     * @param subject
     *            - subject mail
     * @param text
     *            - text mail
     * @return - Availability of posts on the page
     */
    public boolean CheckForDrafts(String subject, String text) {
	try {
	    return driver.findElement(By.xpath(String.format(identificationDraft, subject, text))).isEnabled();
	} catch (RuntimeException e) {
	    return false;
	}
    }

}
