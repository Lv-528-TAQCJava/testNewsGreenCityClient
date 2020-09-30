package com.ss.greencity.pageobjects;

import com.ss.greencity.locators.HeaderLocators;
import org.openqa.selenium.WebDriver;

/**
 * An additional functionality for any page object for a not logged in user.
 * Use for pages which could be accessed by anonymous users.
 */
interface IAnonymousPO {
    default HeaderAnonymousComponent getHeaderAnonymous(WebDriver driver) {
        HeaderAnonymousComponent headerAnon = new HeaderAnonymousComponent(driver);
        return headerAnon;
    }
}
