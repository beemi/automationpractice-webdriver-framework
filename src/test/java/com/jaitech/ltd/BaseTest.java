package com.jaitech.ltd;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected WebDriver driver;
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

    @After
    public void teardown() {

        if (driver != null) {
            driver.quit();
        }
    }

}
