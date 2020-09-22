package com.ss.greencity.locators;

import org.openqa.selenium.By;

public enum SignInLocators implements Locator {
    SIGN_IN_BTN(By.cssSelector("li.sign-in-link.tertiary-global-button.last-nav-item")),
    EMAIL_FIELD(By.cssSelector("input[name='email']")),
    PASSWORD_FIELD(By.cssSelector("input[name='form-control password']")),
    SIGN_IN_USER_BTN(By.cssSelector("button.primary-global-button")),
    GOOGLE_SIGN_IN_BTN(By.cssSelector("div.google-sign-in-block > button")),
    EMAIL_ALERT_MESSAGE(By.xpath("//div[contains(text(),'e-mail')]")),
  //  EMAIL_ALERT_MESSAGE(By.cssSelector("div.validation-email-error.ng-star-inserted > div")),
    CLOSE_FORM_BUTTON(By.cssSelector("img.cross-btn"));

    private By path;

    SignInLocators(By path) {
        this.path=path;
    }

    @Override
    public By getPath() {
        return path;
    }
}