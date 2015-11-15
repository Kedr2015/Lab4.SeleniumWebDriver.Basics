package com.epam.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author kedr
 *
 *         Login page. Locators and work with them
 */
public class LoginPages {
    private WebDriver driver;//webdriver

    /**
     * Transfer driver instance in the constructor
     * 
     * @param driver
     *            -webdriver
     */
    public LoginPages(WebDriver driver) {
	this.driver = driver;
    }

    By userNameLocator = By.xpath("//input[@name='login'][@title='Логин']");// Locator
									    // field
									    // name
    By userPasswordXpath = By.xpath("//input[@name='password'][@title='Пароль']");// Locator
										  // field
										  // password
    By loginButton = By.cssSelector(".lovesearchbutton");// Bbutton input
    By openMailButton = By.xpath("//div[@class='post']//h2/a");// Button opening
							       // page box

    /**
     * The method checks the opening of the login page
     * 
     * @return - The presence of the name field on the page
     */
    public boolean isuserName() {
	try {
	    return driver.findElement(userNameLocator).isDisplayed();
	} catch (RuntimeException e) {
	    return false;
	}
    }

    /**
     * 
     * The method of login.
     * 
     * @param name
     *            - user password
     */
    public void inputName(String name) {

	driver.findElement(userNameLocator).sendKeys(name);
    }

    /**
     * The method of entering a password
     * 
     * @param password
     *            - user password
     */
    public void inputPassword(String password) {
	driver.findElement(userPasswordXpath).sendKeys(password);
    }

    /**
     * Clicking on the Login
     */
    public void pressButtonInput() {
	driver.findElement(loginButton).click();
    }

    /**
     * Clicking on mail
     */
    public void pressButtonOpenMail() {
	driver.findElement(openMailButton).click();
    }

}
