package com.ss.greencity.pageobjects;

import com.ss.greencity.locators.HeaderLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * An additional functionality for any page object for a not logged in user.
 * Use for pages which could be accessed by anonymous users.
 */
interface IAnonymousPO {
    default HeaderAnonymousPO getHeaderAnonymous(WebDriver driver) {
        HeaderAnonymousPO headerAnon = new HeaderAnonymousPO(driver.findElement(HeaderLocators.HEADER.getPath()));
        return headerAnon;
    }
}
