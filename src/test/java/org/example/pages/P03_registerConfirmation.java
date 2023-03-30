package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class P03_registerConfirmation extends PageBase{
    public P03_registerConfirmation(WebDriver webdriver) {
        super(webdriver);
    }
    //locate confirmation message
    By confirmationMessage = By.cssSelector("div[class=\"result\"]");
    public String getConfirmationMessage(){
        return confirmationMessage.findElement(driver).getText();
    }
    public String getConfirmationMessageColor(){
        String messageColor = confirmationMessage.findElement(driver).getCssValue("color");
        String rGbaColor = Color.fromString(messageColor).asRgba();
        return rGbaColor;
    }
}
