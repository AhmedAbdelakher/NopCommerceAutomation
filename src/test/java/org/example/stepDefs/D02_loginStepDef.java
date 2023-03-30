package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_dachBoard;
import org.example.pages.P04_login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;

public class D02_loginStepDef {
    @Given("user go to login page")
    public void user_go_to_login_page() {
        P01_dachBoard login = new P01_dachBoard(driver.get());
        login.clickOnLoginButton();
    }
    @When("user enter valid data")
    public void user_enter_valid_data() {
        String userEmail = "test3@example.com";
        String userPassword = "P@ssw0rd";
        P04_login login = new P04_login(driver.get());
        login.setEmailField(userEmail);
        login.setPasswordField(userPassword);
    }

    @When("user enter invalid data")
    public void user_enter_invalid_data() {
        String userEmail = "wrong@example.com";
        String userPassword = "P@ssw0rd";
        P04_login login = new P04_login(driver.get());
        login.setEmailField(userEmail);
        login.setPasswordField(userPassword);
    }

    @And("user press on login button")
    public void user_press_on_login_button() {
        P04_login login = new P04_login(driver.get());
        login.clickOnLoginButton();
    }
    @Then("user login to the system successfully")
    public void userLoginSuccessfully(){
        String expectedCurrentUrl = "https://demo.nopcommerce.com/";
        String actualCurrentUrl = driver.get().getCurrentUrl();
        boolean muAccount = driver.get().findElement(By.cssSelector("a[class=\"ico-account\"]")).isDisplayed();
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(expectedCurrentUrl , actualCurrentUrl);
        soft.assertTrue(muAccount);
        soft.assertAll();
    }

    @Then("user could not login to the system")
    public void user_could_not_login_to_the_system() {
        WebElement errorMessage = driver.get().findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]"));
        String actualErrorMessage = errorMessage.getText();
        String actualErrorMessageColor = errorMessage.getCssValue("color");
        String hexColor = Color.fromString(actualErrorMessageColor).asHex();
        String expectedErrorMessage = "Login was unsuccessful.";
        String expectedErrorMessageColor = "#e4434b";
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
        soft.assertEquals(expectedErrorMessageColor ,hexColor);
        soft.assertAll();
    }
}
