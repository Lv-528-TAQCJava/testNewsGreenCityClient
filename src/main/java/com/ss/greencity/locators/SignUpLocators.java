package com.ss.greencity.locators;

import org.openqa.selenium.By;

public enum SignUpLocators implements Locator {
    IMAGE_PANEL(By.cssSelector("div.main-image > img")),
    EMAIL_FIELD(By.cssSelector("input[name='email']")),
    USERNAME_FIELD(By.cssSelector("input[name='fistName']")),
    PASSWORD_FIELD(By.cssSelector("input[name='form-control password']")),
    CONFIRM_PASSWORD_FIELD(By.cssSelector("input[name='form-control password-confirm']")),
    SIGN_UP_USER_BTN(By.cssSelector("button.primary-global-button")),
    EMAIL_ALERT_MESSAGE(By.xpath("//div[contains(text(),'e-mail')]")),
    EMPTY_EMAIL_FIELD_ALERT_MESSAGE(By.xpath("//div[contains(text(),'Email is required')]")),
    EMPTY_USERNAME_FIELD_ALERT_MESSAGE(By.xpath("//div[contains(text(),'User name is required')]")),
    EMPTY_PASSWORD_FIELD_ALERT_MESSAGE(By.xpath("//div[contains(text(),'Password is required')]")),
    USERNAME_ALERT_MESSAGE(By.xpath(("//div[contains(text(),'name')]"))),
    PASSWORD_FIELD_ALERT_MESSAGE(By.xpath("//div[contains(text(),'8 characters')]")),
    CONFIRM_PASSWORD_ALERT_MESSAGE(By.xpath("//div[contains(text(),'match')]")),
    SIGNED_UP_USER_MESSAGE(By.xpath("//div/h1[contains(text(),'Welcome back!')]")),
    CLOSE_FORM_BUTTON(By.cssSelector("img.cross-btn"));

    private By path;

    SignUpLocators(By path) {
        this.path=path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
