package com.ss.greencity.locators;

import org.openqa.selenium.By;

public enum CommentsLocators implements Locator {

    COMMENTS_INPUTBOX(By.cssSelector(".wrapper-comment textarea")),
    COMMENT_BUTTON(By.cssSelector(".wrapper-comment button")),
    LAST_COMMENT(By.xpath("//div[@class='comment-body-wrapper ng-star-inserted'][1]/div[@class='comment-main-text']/p[@class='comment-text ng-star-inserted']"));

    private By path;

    CommentsLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
