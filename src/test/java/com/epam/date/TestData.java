package com.epam.date;

import org.testng.annotations.DataProvider;

/**
 * @author kedr Test data for authorization
 */
public class TestData {
	// Website address
	public static String url = "http://qip.ru/";
	// user login
	public static String login = "epamtestselenium";
	// user password
	public static String password = "TestEPAM1";

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

}
