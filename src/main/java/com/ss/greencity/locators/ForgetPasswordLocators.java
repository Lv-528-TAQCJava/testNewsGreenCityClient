package com.ss.greencity.locators;

import org.openqa.selenium.By;

public enum  ForgetPasswordLocators implements Locator {
    FORGET_PASSWORD_LABEL(By.cssSelector("app-restore-password > div > div > div.right-side > h1"))
    ;


    private By path;

    ForgetPasswordLocators(By path) {
        this.path=path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
