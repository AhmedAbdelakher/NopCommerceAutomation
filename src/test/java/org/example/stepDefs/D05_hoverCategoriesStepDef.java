package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P05_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.Locale;

import static org.example.stepDefs.Hooks.driver;

public class D05_hoverCategoriesStepDef {
    @When("user select from computer hover category and choose desktop")
    public void userSelectFromHoverCategory() throws InterruptedException {
        P05_homePage hover = new P05_homePage(driver.get());
        hover.activeComputersHoverAndClickOnDesktops();
    }
    @Then("user should direct to desktop page")
    public void userShouldDirectedToDesktopPage(){
        WebElement pageTitle = driver.get().findElement(By.cssSelector("div[class=\"page-title\"]"));
        String desktopPageTitle = pageTitle.getText().toLowerCase(Locale.ROOT).trim();
        System.out.println(desktopPageTitle);
        String expectedPageTitle = "desktops";
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(desktopPageTitle.contains(expectedPageTitle));
    }

}
