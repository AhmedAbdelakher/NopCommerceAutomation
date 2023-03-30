package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Hooks {
    public static ThreadLocal<WebDriver> driver;

    @Before
    public void setDriverProperties() throws InterruptedException {
        driver = new ThreadLocal<>();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver(options));
            driver.get().get("https://demo.nopcommerce.com/");
            driver.get().manage().window().maximize();
            Thread.sleep(1000);
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.get().quit();
    }
}

