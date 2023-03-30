package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P05_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class D03_currenciesStepDef {
    @When("user choose Euro currency from dropdown list")
    public void userChooseEuroCurrencyFromDropdownList() throws InterruptedException {
        P05_homePage currency = new P05_homePage(driver.get());
        currency.chooseEuroFromCurrencyDropDown();
    }

    @Then("user change the currency successfully")
    public void userChangeTheCurrencySuccessfully() {
        List<WebElement> actualPrice = driver.get().findElements(By.cssSelector("span[class=\"price actual-price\"]"));
        for (int i =0 ; i<actualPrice.size() ; i++){
            String price = actualPrice.get(i).getText();
            Assert.assertTrue(price.contains("€"));
        }
    }
}
