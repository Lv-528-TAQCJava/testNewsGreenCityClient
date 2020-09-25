package com.ss.greencity.locators;

import org.openqa.selenium.By;

public enum ProfileLocators implements Locator {
    USER_NAME_FIELD(By.cssSelector(".descriptions__name")),
    USER_LOCATION(By.cssSelector(".descriptions__location")),
    USER_CREDO(By.cssSelector(".details__credo")),
    EDIT_PROFILE_BUTTON(By.cssSelector("a > img[alt='edit icon']"))
    ;

    private By path;

    ProfileLocators(By path) {
        this.path=path;
    }

    @Override
    public By getPath() {
        return path;
    }
}