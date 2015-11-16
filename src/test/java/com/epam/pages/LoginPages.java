package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * @author kedr
 *
 *         Login page. Locators and work with them
 */
public class LoginPages {
	private WebDriver driver;// webdriver

	/**
	 * Transfer driver instance in the constructor
	 * 
	 * @param driver
	 *            -webdriver
	 */
	public LoginPages(WebDriver driver) {
		this.driver = driver;
	}

	// Locator field name
	By userNameLocator = By.xpath("//input[@name='login'][@title='Логин']");
	// Locator field password
	By userPasswordXpath = By.xpath("//input[@name='password'][@title='Пароль']");
	// Bbutton input
	By loginButton = By.cssSelector(".lovesearchbutton");
	// Button opening page box
	By openMailButton = By.xpath("//div[@class='post']//h2/a");

	/**
	 * The method checks the opening of the login page
	 * 
	 * @return - The presence of the name field on the page
	 */
	public boolean isUserName() {
		try {
			return driver.findElement(userNameLocator).isDisplayed();
		} catch (NoSuchElementException e) {
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
