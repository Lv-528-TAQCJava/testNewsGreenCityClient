package com.ss.greencity.locators;

import org.openqa.selenium.By;

public enum CreateNewsLocators implements Locator {
    TITLE_FIELD(By.cssSelector("div.left-form-column > textarea.ng-untouched.ng-pristine.ng-invalid")),
    NEWS_BUTTON(By.cssSelector("button.ng-star-inserted:nth-of-type(1)")),
    EVENTS_BUTTON(By.cssSelector("button.ng-star-inserted:nth-of-type(2)")),
    EDUCATION_BUTTON(By.cssSelector("button.ng-star-inserted:nth-of-type(3)")),
    INITIATIVE_BUTTON(By.cssSelector("button.ng-star-inserted:nth-of-type(4)")),
    ADS_BUTTON(By.cssSelector("button.ng-star-inserted:nth-of-type(5)")),
    SOURS_FIELD(By.cssSelector("input.ng-untouched.ng-pristine.ng-valid")),
    //div[contains(text(),'8 characters')
    ATHOR(By.cssSelector("div.date > p:nth-of-type(2) > span:nth-of-type(2)")),
    DATE(By.cssSelector("div.date > p:nth-of-type(1) > span:nth-of-type(2)")),
    CANCEL_BUTTON(By.cssSelector("div.submit-buttons > button:nth-of-type(1)")),
    PREVIEW_BUTTON(By.cssSelector("div.submit-buttons > button:nth-of-type(2)")),
    PUBLISH_BUTTON(By.cssSelector("div.submit-buttons > button:nth-of-type(3)")),
    CONTINUE_EDIT_BUTTON(By.cssSelector(".secondary-global-button")),
    YES_CANCEL_BUTTON(By.cssSelector("primary-global-button")),
    CONTENT(By.name("main-area"));



    private By path;

    CreateNewsLocators(By path) {
        this.path=path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
