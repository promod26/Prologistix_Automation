package com.prologistix.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegistrationForm extends BasePage {


    @FindBy(css = ".btn-text")
    WebElement closeModalBtn;

    @FindBy(id = "firstName")
    WebElement firstNameTextbox;

    @FindBy(name = "lastName")
    WebElement lastNameTextbox;

    @FindBy(name = "address")
    WebElement addressTextbox;

    @FindBy(name = "address2")
    WebElement address2Textbox;

    @FindBy(name = "city")
    WebElement cityTextbox;

    @FindBy(name = "state")
    WebElement stateDropdown;
    @FindBy(name = "zipcode")
    WebElement zipcodeTextbox;

    @FindBy(name = "ssn")
    WebElement ssnTextbox;

    @FindBy(name = "cellPhone")
    WebElement cellPhoneTextbox;

    @FindBy(name = "emergencyContactName")
    WebElement emergencyContactNameTextbox;

    @FindBy(name = "emergencyContactPhoneNumber")
    WebElement emergencyContactPhoneNumberTextbox;

    @FindBy(xpath = "//button[contains(.,'Continue')]")
    WebElement continueBtn;
    @FindBy(name = "desiredposition")
    WebElement desiredpositionTextbox;

    @FindBy(name = "minpay")
    WebElement minpayTextbox;

    @FindBy(name = "piStartTime")
    WebElement piStartTimeTextbox;

    @FindBy(name = "jobValidatorTemp")
    List<WebElement> jobValidatorTempTextbox;

    @FindBy(xpath = "//button[contains(.,'Next Step')]")
    WebElement nextStepBtn;

    public RegistrationForm(WebDriver driver) {
        super(driver);
    }

    public void closeModal() {
        wait.until(ExpectedConditions.visibilityOf(closeModalBtn));
        closeModalBtn.click();
    }

    public RegistrationForm fillPersonalInformation() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(firstNameTextbox));
        firstNameTextbox.sendKeys(faker.name().firstName());
        lastNameTextbox.sendKeys(faker.name().lastName());
        addressTextbox.sendKeys(faker.address().streetAddress());
        address2Textbox.sendKeys(faker.address().buildingNumber());
        cityTextbox.sendKeys(faker.address().city());
        Select state = new Select(stateDropdown);
        state.selectByVisibleText(faker.address().state());
        zipcodeTextbox.sendKeys(faker.address().zipCode());
        ssnTextbox.sendKeys("1234");
        cellPhoneTextbox.sendKeys(faker.number().digits(10));
        emergencyContactNameTextbox.sendKeys(faker.name().fullName());
        emergencyContactPhoneNumberTextbox.sendKeys(faker.number().digits(10));
        Thread.sleep(5000);
        continueBtn.click();
        return this;


    }

    public RegistrationForm quickQuestions() throws InterruptedException {
        desiredpositionTextbox.sendKeys(faker.job().position());
        minpayTextbox.sendKeys("20");
        piStartTimeTextbox.sendKeys("8:00AM");
        piStartTimeTextbox.sendKeys(Keys.ENTER);
        jobValidatorTempTextbox.stream().findAny().orElseThrow(null).click();
        Thread.sleep(5000);
        nextStepBtn.click();
        if (driver.findElements(By.xpath("//button[contains(.,'Yes')]")).size() > 0)
            driver.findElement(By.xpath("//button[contains(.,'Yes')]")).click();
        if (driver.findElements(By.xpath("//button[contains(.,'No, I am not')]")).size() > 0)
            driver.findElement(By.xpath("//button[contains(.,'No, I am not')]")).click();
        return this;
    }

    public RegistrationForm fillExprience() throws InterruptedException {
        driver.findElement(By.xpath("//label[contains(.,'Logistics')]/input")).click();
        nextStepBtn.click();
        driver.findElements(By.xpath("//label[contains(.,'no work')]/input")).get(0).click();
        continueBtn.click();
        driver.findElements(By.cssSelector("label .hidden-xs")).forEach(ele -> {
            if (ele.getText().equalsIgnoreCase("No"))
                ele.click();
        });

        driver.findElement(By.xpath("//button[contains(.,'Continue to Schedule Your Interview')]")).click();
        Thread.sleep(5000);
        return this;
    }

    public String successMsg() {
        return driver.findElement(By.cssSelector("h1.ng-binding")).getText();
    }
}
