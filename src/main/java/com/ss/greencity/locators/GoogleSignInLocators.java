package com.ss.greencity.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public enum GoogleSignInLocators implements Locator {
    EMAIL_PHONE_FIELD(By.xpath("//*[@id=\"identifierId\"]")),
    EMAIL_NEXT_BTN(By.id("identifierNext")),
    PASSWORD_FIELD(By.xpath("//input[@name='password']")),
    PASSWORD_NEXT_BTN(By.id("passwordNext"));




    private By path;

    GoogleSignInLocators(By path) {
        this.path=path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
