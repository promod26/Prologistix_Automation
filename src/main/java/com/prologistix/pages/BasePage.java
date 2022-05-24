package com.prologistix.pages;

import com.github.javafaker.Faker;
import com.prologistix.constant.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    Faker faker;
    WebDriverWait wait;
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        faker = new Faker();
        wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        PageFactory.initElements(driver, this);
    }
}
