package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_dachBoard;
import io.cucumber.java.en.Given;
import org.example.pages.P02_register;
import org.example.pages.P03_registerConfirmation;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;

public class D01_registerStepDef {
    P01_dachBoard dashBoard = new P01_dachBoard(driver.get());
    @Given("user go to register page")
    public void goRegisterPage() {
        dashBoard.clickOnRegisterButton();
    }
    @When("user register with valid data")
    public void successfullyRegistration(){
        P02_register register = new P02_register(driver.get());
        String firstName = "automation";
        String lastName = "tester";
        String day="15";
        String month = "9";
        String year = "1998";
        String email = "test3@example.com";
        String password = "P@ssw0rd";
        register.selectMaleGender();
        register.setFirstNameField(firstName);
        register.setLastNameField(lastName);
        register.selectDateOfBirthDayDay(day);
        register.selectDateOfBirthDayMonth(month);
        register.selectDateOfBirthDayYear(year);
        register.setEmailField(email);
        register.setPasswordField(password);
        register.setConfirmPasswordField(password);
        register.clickOnRegisterButton();
    }
    @Then("user should register successfully")
    public void verifyRegistration(){
        P03_registerConfirmation register = new P03_registerConfirmation(driver.get());
        String expectedConfirmationMessage = "Your registration completed";
        String expectedRgbaMessageColor = "rgba(76, 177, 124, 1)";
        String actualConfirmationMessage= register.getConfirmationMessage();
        String actualMessageColor = register.getConfirmationMessageColor();
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(expectedConfirmationMessage , actualConfirmationMessage);
        soft.assertEquals(expectedRgbaMessageColor , actualMessageColor);
        soft.assertAll();
    }
}