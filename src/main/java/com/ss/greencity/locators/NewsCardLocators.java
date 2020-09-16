package com.ss.greencity.locators;

import org.openqa.selenium.By;

public enum NewsCardLocators implements Locator {
    //IMAGE(By.cssSelector("")), //implement if necessary
    //CATEGORY(By.cssSelector("")), //implement if necessary
    //HEADING(By.cssSelector("")), //implement if necessary
    //TEXT(By.cssSelector("")), //implement if necessary
    //DATE(By.cssSelector("")), //implement if necessary
    //AUTHOR(By.cssSelector("")), //implement if necessary
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
