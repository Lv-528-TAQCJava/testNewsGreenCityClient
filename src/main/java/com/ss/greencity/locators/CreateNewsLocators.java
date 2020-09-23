package com.ss.greencity.locators;

import org.openqa.selenium.By;

public enum CreateNewsLocators implements Locator {
    ADS_BUTTON(By.xpath("//*[contains(text(), 'Ads')]")),
    AUTHOR(By.cssSelector("div.date > p:nth-of-type(2) > span:nth-of-type(2)")),
    CANCEL_BUTTON(By.xpath("//*[contains(text(), 'Cancel')]")),
    CONTENT(By.name("main-area")),
    CONTINUE_EDIT_BUTTON(By.cssSelector(".secondary-global-button")),
    DATE(By.cssSelector("div.date > p:nth-of-type(1) > span:nth-of-type(2)")),
    EDUCATION_BUTTON(By.xpath("//*[contains(text(), 'Education')]")),
    EVENTS_BUTTON(By.xpath("//*[contains(text(), 'Events')]")),
    INITIATIVE_BUTTON(By.xpath("//*[contains(text(), 'Initiative')]")),
    NEWS_BUTTON(By.xpath("//*[contains(text(), 'News')]")),
    PREVIEW_BUTTON(By.xpath("//*[contains(text(), 'Preview')]")),
    PUBLISH_BUTTON(By.xpath("//*[contains(text(), 'Publish')]")),
    SOURS_FIELD(By.cssSelector("input.ng-untouched.ng-pristine.ng-valid")),
    TITLE_FIELD(By.cssSelector("div.left-form-column > textarea.ng-untouched.ng-pristine.ng-invalid")),
    WARNING_CONTENT(By.cssSelector("textarea.ng-touched.ng-dirty.ng-invalid")),
    WARNING_SOURSE(By.cssSelector("input.ng-valid.field-warning.ng-dirty.ng-touched")),
    WARNING_TAGS(By.cssSelector("div.tags.ng-untouched.ng-pristine.ng-valid > p.warning")),
    YES_CANCEL_BUTTON(By.cssSelector("primary-global-button"));


    private By path;

    CreateNewsLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
