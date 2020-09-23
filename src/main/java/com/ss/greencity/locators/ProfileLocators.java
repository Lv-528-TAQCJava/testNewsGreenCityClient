package com.ss.greencity.locators;

import org.openqa.selenium.By;

public enum ProfileLocators implements Locator {
    USER_NAME_FIELD(By.cssSelector("div.details__descriptions > h3"))
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