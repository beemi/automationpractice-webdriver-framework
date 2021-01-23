package com.jaitech.ltd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    private final WebDriver driver;

    // block_contact_infos
    private final By footerBy = By.id("block_contact_infos");

    // newsletter-input
    private final By newsLetterBy = By.id("newsletter-input");

    //submitNewsletter
    private final By submitNewsletter = By.name("submitNewsletter");

    // newsletter send notification
    private final By alertSuccessBy = By.cssSelector("p[class='alert alert-success']");


    public LandingPage(final WebDriver driver) {

        this.driver = driver;
    }

    /**
     * Check footer has displayed.
     *
     * @return true if footer has displayed.
     */
    public boolean isFooterDisplayed() {

        return driver.findElement(footerBy).isDisplayed();
    }

    /**
     * Get Stored footer information.
     *
     * @return footer information.
     */
    public String getStoreInformation() {

        return driver.findElement(footerBy).getText();
    }

    /**
     * Enter newletter email address and submit
     *
     * @param email - user email address
     */
    public void enterNewsLetter(final String email) {

        driver.findElement(newsLetterBy).sendKeys(email);
        driver.findElement(submitNewsletter).click();
    }

    /**
     * Check the alert has been displayed.
     *
     * @return - true if alert has been displayed.
     */
    public boolean hasAlertDisplayed() {

        return driver.findElement(alertSuccessBy).isDisplayed();
    }

    /**
     * Get the alert text from notification.
     *
     * @return - alert text.
     */
    public String getAlertText() {

        return driver.findElement(alertSuccessBy).getText();
    }


}
