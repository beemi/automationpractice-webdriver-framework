package com.jaitech.ltd;

import com.jaitech.ltd.pages.LandingPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class NewsLetterTest extends BaseTest {

    @Test
    public void testSignIn() throws InterruptedException {

        LandingPage landingPage = new LandingPage(driver);

        Assert.assertTrue(landingPage.isFooterDisplayed());
        landingPage.enterNewsLetter("testtestq21@test.com");
        Thread.sleep(1000);

        Assert.assertTrue(landingPage.hasAlertDisplayed());
        Assert.assertTrue(landingPage.getAlertText()
                                     .contains("Newsletter : You have successfully subscribed to this newsletter."));
    }

}
