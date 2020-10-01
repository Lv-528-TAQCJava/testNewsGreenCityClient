package com.ss.greencity.locators;

import org.openqa.selenium.By;

public enum  ForgetPasswordLocators implements Locator {
    FORGET_PASSWORD_LABEL(By.cssSelector("app-restore-password > div > div > div.right-side > h1")),
    EMAIL_FIELD(By.cssSelector("input[name='email']")),
    EMAIL_ERROR_MESSAGE(By.cssSelector("div[class='validation-email-error ng-star-inserted']")),
    SUBMIT_LOGIN_BTN(By.cssSelector("button[class='send-btn primary-global-button']")),
    GOOGLE_SIGN_IN_BTN(By.cssSelector("button[class='google-sign-in']")),
    SIGN_IN_LINK(By.cssSelector("a[class='sign-in-link']"));



    private By path;

    ForgetPasswordLocators(By path) {
        this.path=path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
