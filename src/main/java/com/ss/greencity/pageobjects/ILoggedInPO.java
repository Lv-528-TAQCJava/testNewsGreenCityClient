package com.ss.greencity.pageobjects;

import com.ss.greencity.locators.HeaderLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * An additional functionality for any page object for a logged in user.
 * Use for pages which could be accessed by registered users.
 */
interface ILoggedInPO {
    default HeaderSignedInPO getHeaderSignedIn(WebDriver driver) {
        HeaderSignedInPO headerSignedIn = new HeaderSignedInPO(driver.findElement(HeaderLocators.HEADER.getPath()));
        return headerSignedIn;
    }
}
