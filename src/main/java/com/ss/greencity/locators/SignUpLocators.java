package com.ss.greencity.locators;

import org.openqa.selenium.By;

public enum SignUpLocators implements Locator {
    SIGN_UP_BTN(By.cssSelector(".sign-up-link.ng-star-inserted > div")),
    EMAIL_FIELD(By.cssSelector("input[name='email']")),
    USERNAME_FIELD(By.cssSelector("input[name='fistName']")),
    PASSWORD_FIELD(By.cssSelector("input[name='form-control password']")),
    CONFIRM_PASSWORD_FIELD(By.cssSelector("input[name='form-control password-confirm']")),
    SIGN_UP_USER_BTN(By.cssSelector("button.primary-global-button"));

    private By path;

    SignUpLocators(By path) {
        this.path=path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
