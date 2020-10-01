package com.ss.greencity.locators;

import org.openqa.selenium.By;

public enum CancelationPopupLocators implements Locator {

    CANCEL_BUTTON(By.cssSelector(".primary-global-button")),
    CONFIRM_BUTTON(By.cssSelector(".secondary-global-button"));
    CancelationPopupLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }

    private By path;
}
