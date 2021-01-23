package com.jaitech.ltd;

import com.jaitech.ltd.constants.Constants;
import com.jaitech.ltd.pages.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FooterPageObjectTest {

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

        LandingPage landingPage = new LandingPage(driver);

        Assert.assertTrue(landingPage.isFooterDisplayed());
        Assert.assertTrue(landingPage.getStoreInformation().contains(Constants.supportEmail));
    }

    @After
    public void teardown() {

        if (driver != null) {
            driver.quit();
        }
    }

}
