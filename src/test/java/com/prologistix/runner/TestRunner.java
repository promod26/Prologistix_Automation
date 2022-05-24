package com.prologistix.runner;

import com.prologistix.core.WebDriverManager;
import com.prologistix.utils.PropertyUtils;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Properties;


@CucumberOptions(
        features = {"src/test/java/com/prologistix/tests/"},
        glue = {"com.prologistix.testSteps"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

    public Properties property;
    public WebDriver driver;
    public String appUrl;

    @BeforeSuite
    public void loadConfig() {
        property = PropertyUtils.getProperty();
        appUrl = property.getProperty("app.url");

        driver = WebDriverManager.getDriver();
        driver.navigate().to(appUrl);
    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver = WebDriverManager.getDriver();
        driver.close();
        driver.quit();
    }

}