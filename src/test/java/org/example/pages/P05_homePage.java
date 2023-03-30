package org.example.pages;

import io.cucumber.messages.types.Hook;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class P05_homePage extends PageBase{
    public P05_homePage(WebDriver webdriver) {
        super(webdriver);
    }
    // Locate Home page elements
    WebElement currencyDropDown = Hooks.driver.get().findElement(By.cssSelector("select[id=\"customerCurrency\"]"));
    Select currencyDropDownList = new Select(currencyDropDown);
    WebElement searchField = Hooks.driver.get().findElement(By.cssSelector("input[id=\"small-searchterms\"]"));
    WebElement searchButton = Hooks.driver.get().findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]"));
    WebElement computersHover = Hooks.driver.get().findElement(By.cssSelector("a[href=\"/computers\"]"));
    // Actions  on Home Page elements
    public void chooseEuroFromCurrencyDropDown(){
        currencyDropDownList.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");
    }
    public void setSearchField(String product){
        fillTextField(searchField , product);
    }
    public void clockOnSearchButton(){
        clickOnElement(searchButton);
    }
    // Hovers Actions
    public void activeComputersHoverAndClickOnDesktops() throws InterruptedException {
        Actions actions=new Actions(driver);
        actions.moveToElement(computersHover).perform();
        Thread.sleep(1000);
        WebElement desktopsSubCategory = Hooks.driver.get().findElement(By.cssSelector("a[href=\"/desktops\"]"));
        actions.moveToElement(desktopsSubCategory).click().build().perform();
    }
    public void activeComputersHoverAndClickOnNoteBook() throws InterruptedException {
        Actions actions=new Actions(driver);
        actions.moveToElement(computersHover).perform();
        Thread.sleep(1000);
        WebElement notebooksSubCategory = Hooks.driver.get().findElement(By.cssSelector("a[href=\"/notebooks\"]"));
        actions.moveToElement(notebooksSubCategory).click().build().perform();
    }
    public void activeComputersHoverAndClickOnSoftware() throws InterruptedException {
        Actions actions=new Actions(driver);
        actions.moveToElement(computersHover).perform();
        Thread.sleep(1000);
        WebElement softwareSubCategory = Hooks.driver.get().findElement(By.cssSelector("a[href=\"/software\"]"));
        actions.moveToElement(softwareSubCategory).click().build().perform();
    }

}
