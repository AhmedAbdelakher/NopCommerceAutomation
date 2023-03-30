package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;

public class P02_register extends PageBase{
    // create constructor
    public P02_register(WebDriver webdriver) {
        super(webdriver);
    }
    // Locate elements in register page
    WebElement maleGender = Hooks.driver.get().findElement(By.cssSelector("input[id=\"gender-male\"]"));
    WebElement femaleGender = Hooks.driver.get().findElement(By.cssSelector("input[id=\"gender-female\"]"));
    WebElement firstNameField = Hooks.driver.get().findElement(By.cssSelector("input[id=\"FirstName\"]"));
    WebElement lastNameField = Hooks.driver.get().findElement(By.cssSelector("input[id=\"LastName\"]"));
    Select dateOfBirthDay = new Select(Hooks.driver.get().findElement(By.cssSelector("select[name=\"DateOfBirthDay\"]")));
    Select dateOfBirthMonth = new Select(Hooks.driver.get().findElement(By.cssSelector("select[name=\"DateOfBirthMonth\"]")));
    Select dateOfBirthYear = new Select(Hooks.driver.get().findElement(By.cssSelector("select[name=\"DateOfBirthYear\"]")));
    WebElement passwordField = Hooks.driver.get().findElement(By.cssSelector("input[id=\"Password\"]"));
    WebElement confirmPasswordField = Hooks.driver.get().findElement(By.cssSelector("input[id=\"ConfirmPassword\"]"));
    WebElement emailField = Hooks.driver.get().findElement(By.cssSelector("input[id=\"Email\"]"));
    WebElement registerButton = Hooks.driver.get().findElement(By.cssSelector("button[id=\"register-button\"]"));

    // Actions on web elements
    public void selectMaleGender(){
        clickOnElement(maleGender);
    }
    public void selectFemaleGender(){
        clickOnElement(femaleGender);
    }
    public void setFirstNameField(String firstName){
        fillTextField(firstNameField ,firstName);
    }
    public void setLastNameField(String lastName){
        fillTextField(lastNameField , lastName);
    }
    public void selectDateOfBirthDayDay(String value){
        dateOfBirthDay.selectByValue(value);
    }
    public void selectDateOfBirthDayMonth(String value){
        dateOfBirthMonth.selectByValue(value);
    }
    public void selectDateOfBirthDayYear(String value){
        dateOfBirthYear.selectByValue(value);
    }
    public void setPasswordField(String password){
        fillTextField(passwordField , password);
    }
    public void setConfirmPasswordField(String password){
        fillTextField(confirmPasswordField , password);
    }
    public void setEmailField(String email){
        fillTextField(emailField , email);
    }
    public void clickOnRegisterButton(){
        clickOnElement(registerButton);
    }
}
