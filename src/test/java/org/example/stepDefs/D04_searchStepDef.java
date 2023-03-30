package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P05_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Locale;

import static org.example.stepDefs.Hooks.driver;

public class D04_searchStepDef {
    @When("user search using product name {string}")
    public void userSearchUsingProductName(String string) {
        P05_homePage search = new P05_homePage(driver.get());
        search.setSearchField(string);
        search.clockOnSearchButton();
    }
    @Then("user could search successfully {string}")
    public void user_could_search_successfully(String string) {
        String currentUrl = driver.get().getCurrentUrl();
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(currentUrl.contains("https://demo.nopcommerce.com/search?q="));
        soft.assertAll();
        List<WebElement> searchProducts = driver.get().findElements(By.cssSelector("div[class=\"item-box\"]"));
        int noOfSearchResult = searchProducts.size();
        System.out.println("Number of search results" + " " + noOfSearchResult);
        for(int i=0 ; i<noOfSearchResult ; i++){
            List<WebElement> productTitle = driver.get().findElements(By.cssSelector("h2[class=\"product-title\"]"));
            String productTitleName= productTitle.get(i).getText().toLowerCase(Locale.ROOT);
            System.out.println("product title" + " " + productTitleName);
            SoftAssert soft2 = new SoftAssert();
            soft2.assertTrue(productTitleName.contains(string));
        }
    }
    @When("user search using sku name {string}")
    public void user_search_using_sku_name(String string) {
        P05_homePage search = new P05_homePage(driver.get());
        search.setSearchField(string);
        search.clockOnSearchButton();
    }
    @Then("user could search with sku successfully {string}")
    public void user_could_search_with_sku_successfully(String string){
        List<WebElement> searchProducts = driver.get().findElements(By.cssSelector("div[class=\"item-box\"]"));
        int noOfSearchResult = searchProducts.size();
        System.out.println("Number of search results" + " " + noOfSearchResult);
        for(int i=0 ; i<noOfSearchResult ; i++){
            List<WebElement> productTitle = driver.get().findElements(By.cssSelector("div[class=\"picture\"]"));
            productTitle.get(i).click();
            WebElement skuName =driver.get().findElement(By.cssSelector("div[class=\"sku\"]"));
            System.out.println("string is " + string + "the sku is : " + skuName.getText());
            SoftAssert soft = new SoftAssert();
            soft.assertTrue(skuName.getText().contains(string));
            soft.assertAll();
        }
    }
}
