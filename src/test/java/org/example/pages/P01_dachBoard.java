package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P01_dachBoard extends PageBase{
    // create constructor
    public P01_dachBoard(WebDriver webdriver) {
        super(webdriver);
    }
    // Locate elements in DashBoard page
    WebElement registerButton = Hooks.driver.get().findElement(By.className("ico-register"));
    WebElement loginButton = Hooks.driver.get().findElement(By.cssSelector("a[class=\"ico-login\"]"));
    // Actions on web elements
    public void clickOnRegisterButton(){
        clickOnElement(registerButton);
    }
    public void clickOnLoginButton(){
        clickOnElement(loginButton);
    }
}
