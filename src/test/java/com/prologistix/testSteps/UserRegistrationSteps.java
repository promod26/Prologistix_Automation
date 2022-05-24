package com.prologistix.testSteps;


import com.prologistix.pages.HomePage;
import com.prologistix.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserRegistrationSteps extends BaseTest {
    @Given("^verify app is up and running$")
    public void verify_app_is_up_and_running() throws Throwable {
        loadConfig();
        registrationForm = homePage.signUp();
    }

    @Given("^I want to create my profile with prologistix$")
    public void i_want_to_create_my_profile_with_prologistix() throws Throwable {
        registrationForm.closeModal();
        registrationForm.fillPersonalInformation().quickQuestions().fillExprience();

    }

    @When("I fill registration form")
    public void i_fill_registration_form() {
        assertThat(registrationForm.successMsg().trim(),is(equalTo("We have multiple job opportunities matching your profile! Please schedule your interview!")));
    }

    @Then("I should be registered successfully")
    public void i_should_be_registered_successfully() {
    }

}
