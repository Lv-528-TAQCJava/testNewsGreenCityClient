package com.ss.greencity.locators;

import org.openqa.selenium.By;

public enum SignInLocators implements Locator {
    SIGN_IN_BTN(By.cssSelector("li.sign-in-link.tertiary-global-button.last-nav-item")),
    EMAIL_FIELD(By.cssSelector("input[name='email']")),
    PASSWORD_FIELD(By.cssSelector("input[name='form-control password-signin']")),
    SIGN_IN_USER_BTN(By.cssSelector("button.primary-global-button")),
    GOOGLE_SIGN_IN_BTN(By.cssSelector("div.google-sign-in-block > button")),
    EMAIL_ALERT_MESSAGE(By.xpath("//div[contains(text(),'e-mail')]")),
    EMPTY_EMAIL_FIELD_ALERT_MESSAGE(By.xpath("//div[contains(text(),'Email is required')]")),
    EMPTY_PASSWORD_FIELD_ALERT_MESSAGE(By.xpath("//div[contains(text(),'Password is required')]")),
    PASSWORD_LENGTH_ALERT_MESSAGE(By.xpath("//div[contains(text(),'8 characters')]")),
    INCORRECT_EMAIL_OR_PASSWORD_ALERT_MASSAGE(By.xpath("//div[contains(text(),'Bad email or password')]"));


    private By path;

    SignInLocators(By path) {
        this.path=path;
    }

    @Override
    public By getPath() {
        return path;
    }
}