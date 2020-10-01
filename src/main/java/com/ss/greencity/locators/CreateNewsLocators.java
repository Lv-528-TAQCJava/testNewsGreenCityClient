package com.ss.greencity.locators;

import org.openqa.selenium.By;

public enum CreateNewsLocators implements Locator {
    ADS_BUTTON(By.xpath("//*[contains(text(), 'Ads')]")),
    AUTHOR(By.xpath("//*[contains(text(), 'Author:')]/following-sibling::span")),
    CANCEL_BUTTON(By.xpath("//*[contains(text(), 'Cancel')]")),
    CONTENT(By.name("main-area")),
    DATE(By.xpath("//*[contains(text(), 'Date:')]/following-sibling::span")),
    EDUCATION_BUTTON(By.xpath("//*[contains(text(), 'Education')]")),
    EVENTS_BUTTON(By.xpath("//*[contains(text(), 'Events')]")),
    INITIATIVE_BUTTON(By.xpath("//*[contains(text(), 'Initiative')]")),
    NEWS_BUTTON(By.xpath("//*[contains(text(), 'News')]")),
    PREVIEW_BUTTON(By.xpath("//*[contains(text(), 'Preview')]")),
    PUBLISH_BUTTON(By.xpath("//*[contains(text(), 'Publish')]")),
    SOURS_FIELD(By.xpath("//*[@class='left-form-column']//input")),
    TITLE_FIELD(By.xpath("//*[@class='left-form-column']/textarea")),
    WARNING_CONTENT(By.cssSelector("textarea.ng-invalid.ng-dirty.ng-touched")),
    WARNING_SOURCE(By.cssSelector("input.ng-valid.ng-dirty.ng-touched.field-warning")),
    WARNING_TAGS(By.cssSelector("div.tags.ng-untouched.ng-pristine.ng-valid > p.warning")),
    PICTURE_UPLOAD_LINK(By.xpath("//*[@class='centered']//label"));


    private By path;

    CreateNewsLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
