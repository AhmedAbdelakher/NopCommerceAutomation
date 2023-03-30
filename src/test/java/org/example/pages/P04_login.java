package org.example.pages;

import org.apache.hc.client5.http.impl.async.H2AsyncClientBuilder;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P04_login extends PageBase{
    public P04_login(WebDriver webdriver) {
        super(webdriver);
    }
    // locate login element
    WebElement loginEmailField = Hooks.driver.get().findElement(By.cssSelector("input[id=\"Email\"]"));
    WebElement passwordField = Hooks.driver.get().findElement(By.cssSelector("input[id=\"Password\"]"));
    WebElement loginButton = Hooks.driver.get().findElement(By.cssSelector("button[class=\"button-1 login-button\"]"));
    // Login Actions
    public void setEmailField(String email){
        fillTextField(loginEmailField , email);
    }
    public void setPasswordField(String password){
        fillTextField(passwordField , password);
    }
    public void clickOnLoginButton(){
        clickOnElement(loginButton);
    }
}
