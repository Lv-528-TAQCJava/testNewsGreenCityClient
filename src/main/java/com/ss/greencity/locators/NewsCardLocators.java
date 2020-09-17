package com.ss.greencity.locators;

import org.openqa.selenium.By;

public enum NewsCardLocators implements Locator {
    IMAGE(By.cssSelector("img.list-image-content")),
    CATEGORIES(By.cssSelector(".filter-tag>div")),
    HEADING(By.cssSelector(".title-list.word-wrap p")),
    TEXT(By.cssSelector(".list-text.word-wrap p")),
    DATE(By.xpath(".//p/img[@alt='calendar icon']/..")),
    AUTHOR(By.xpath(".//p/img[@alt='user icon']/..")),
    CLICKABLE_AREA(By.cssSelector("*>div")); //mind that this should be concatenated with '>' and the path to the news card

    NewsCardLocators(By path) {
        this.path = path;
    }

    private By path;
    @Override
    public By getPath() {
        return path;
    }
}
