package com.ss.greencity.locators;

import org.openqa.selenium.By;

public enum PreviewLocators implements Locator {

    AUTHOR(By.cssSelector(".news-info-author")),
    BACK_TO_EDITING_LINK(By.cssSelector(".button-text")),
    CONTENT(By.cssSelector(".news-text-content.word-wrap")),
    DATE(By.cssSelector(".news-info-date")),
    SOURCE_TEXT(By.cssSelector(".source-text.word-wrap")),
    SOURCE_TITLE(By.cssSelector(".source-title")),
    TAGS_ADS(By.xpath("//*[@class = 'tags']/div[contains(text(), 'ads')]")),
    TAGS_EDUCATION(By.xpath("//*[@class = 'tags']/div[contains(text(), 'education')]")),
    TAGS_EVENTS(By.xpath("//*[@class = 'tags']/div[contains(text(), 'events')]")),
    TAGS_INITIATIVES(By.xpath("//*[@class = 'tags']/div[contains(text(), 'initiatives')]")),
    TAGS_NEWS(By.xpath("//*[@class = 'tags']/div[contains(text(), ' news')]")),
    TITLE(By.cssSelector(".news-title.word-wrap"));


    private By path;

    PreviewLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
