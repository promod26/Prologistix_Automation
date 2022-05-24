package com.prologistix.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    WebDriver driver;
    @FindBy(name = "email")
    WebElement emailTextbox;

    @FindBy(name = "password")
    WebElement pwdTextbox;

    @FindBy(linkText = "Sign Up")
    WebElement signUpBtn;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public RegistrationForm signUp(){
        wait.until(ExpectedConditions.elementToBeClickable(emailTextbox));
        emailTextbox.sendKeys(faker.internet().emailAddress());
        pwdTextbox.sendKeys(faker.internet().password());
        signUpBtn.click();
        return new RegistrationForm(driver);
    }


}
