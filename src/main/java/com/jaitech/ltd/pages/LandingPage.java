package com.jaitech.ltd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    private final WebDriver driver;

    // block_contact_infos
    private final By footerBy = By.id("block_contact_infos");

    public LandingPage(final WebDriver driver) {

        this.driver = driver;
    }

    /**
     * Check footer has displayed.
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

}
