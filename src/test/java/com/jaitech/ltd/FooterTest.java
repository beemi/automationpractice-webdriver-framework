package com.jaitech.ltd;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FooterTest {

    private WebDriver driver;

    private final String HOST = "http://automationpractice.com/index.php";

    @BeforeClass
    public static void setUpClass() {

        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTests() {

        driver = new ChromeDriver();

        driver.navigate().to(HOST);
        Assert.assertEquals("My Store", driver.getTitle());
    }

    @Test
    public void testSignIn() {

        Assert.assertTrue(driver.findElement(By.id("newsletter-input")).isEnabled());

        final WebElement storeInformation = driver.findElement(By.id("block_contact_infos"));
        Assert.assertTrue(storeInformation.isDisplayed());
        Assert.assertTrue(storeInformation.getText().contains("support@seleniumframework.com"));
    }

    @After
    public void teardown() {

        if (driver != null) {
            driver.quit();
        }
    }

}
