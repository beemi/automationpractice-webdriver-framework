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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleBrowserTest {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    private final String HOST = "http://automationpractice.com/index.php";

    @BeforeClass
    public static void setUpClass() {

        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTests() {

        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 3000);

        driver.navigate().to(HOST);
        Assert.assertEquals("My Store", driver.getTitle());
    }

    @Test
    public void testSignIn() {

        driver.findElement(By.className("login")).click();
        Assert.assertTrue(driver.findElement(By.id("email_create")).isDisplayed());

        final WebElement email_create = driver.findElement(By.id("email_create"));
        email_create.clear();
        email_create.sendKeys("test121321@gmail.com");
        driver.findElement(By.id("SubmitCreate")).submit();
    }

    @Test
    public void testContactUs() throws InterruptedException {

        driver.findElement((By.id("contact-link"))).click();
        Assert.assertEquals("Customer service - Contact us".toUpperCase(),
                            driver.findElement(By.tagName("h1")).getText().trim());

        //SEND MESSAGE

        //Subject heading
        WebElement element;
        Select subject_heading = new Select(driver.findElement(By.id("id_contact")));
        subject_heading.selectByVisibleText("Webmaster");

        Assert.assertEquals("If a technical problem occurs on this website"
                ,driver.findElement(By.id("desc_contact1")).getText().trim());

        // Enter email addess
        final WebElement email_addess =driver.findElement(By.id("email"));
        email_addess.clear();
        email_addess.sendKeys("test@test.com");

        // Enter order reference
        final WebElement order_reference = driver.findElement(By.id("id_order"));
        order_reference.clear();
        order_reference.sendKeys("TT23972837");

        // Enter Message
        driver.findElement(By.id("message")).sendKeys("TEST TEST TEST");

        // Click Send
        driver.findElement(By.id("submitMessage")).submit();
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("[class*='alert-success']"))));

        // Validate Alert success
        final WebElement  alert= driver.findElement(By.className("alert alert-success"));
        Assert.assertEquals("Your message has been successfully sent to our team.",alert.getText());
    }

    @After
    public void teardown() {

        if (driver != null) {
            driver.quit();
        }
    }

}
