package com.ss.greencity.pageobjects;

import com.ss.greencity.locators.HeaderLocators;
import org.openqa.selenium.WebDriver;

/**
 * An additional functionality for any page object for a logged in user.
 * Use for pages which could be accessed by registered users.
 */
interface ILoggedInPO {
    default HeaderSignedInComponent getHeaderSignedIn(WebDriver driver) {
        HeaderSignedInComponent headerSignedIn = new HeaderSignedInComponent(driver);
        return headerSignedIn;
    }
}
