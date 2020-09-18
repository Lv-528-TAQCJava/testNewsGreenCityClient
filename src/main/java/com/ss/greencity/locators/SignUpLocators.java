package com.ss.greencity.locators;

import org.openqa.selenium.By;

public enum SignUpLocators implements Locator {
    SIGN_UP_BTN(By.xpath("/html/body/app-root/app-header/div/div/div/div[2]/div[2]/ul/li[4]/div/span")),
    EMAIL_FIELD(By.cssSelector("input[name='email']")),
    USERNAME_FIELD(By.cssSelector("input[name='fistName']")),
    PASSWORD_FIELD(By.cssSelector("input[name='form-control password']")),
    CONFIRM_PASSWORD_FIELD(By.cssSelector("input[name='form-control password-confirm']")),
    SIGN_UP_USER_BTN(By.cssSelector("button.primary-global-button")),
    EMAIL_ALERT_MESSAGE(By.cssSelector(" Please check that your e-mail address is indicated correctly "));

    private By path;

    SignUpLocators(By path) {
        this.path=path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
