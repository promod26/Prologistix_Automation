package com.prologistix.testSteps;

import java.util.Properties;

import com.prologistix.pages.RegistrationForm;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.prologistix.core.WebDriverManager;
import com.prologistix.pages.HomePage;
import com.prologistix.utils.PropertyUtils;

public class BaseTest {
	protected WebDriver driver;
	public HomePage homePage;
	public RegistrationForm registrationForm;

	public void loadConfig() {
		driver = WebDriverManager.getDriver();
		homePage = new HomePage(driver);
	}


}
