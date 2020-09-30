package com.ss.greencity.pageobjects;

import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.InputBox;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.ss.greencity.locators.CommentsLocators.*;

public class CommentsPO extends BasePageObject {

    public CommentsPO(WebDriver driver) {
        super(driver);
    }

    public InputBox getCommentsInputbox() {
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .visibilityOfElementLocated(COMMENTS_INPUTBOX.getPath()));
        return new InputBox(driver.findElement(COMMENTS_INPUTBOX.getPath()));
    }

    public Button getCommentButton() {
        return new Button(driver.findElement(COMMENT_BUTTON.getPath()));
    }

    public String getLastCommentText() {
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .visibilityOfElementLocated(LAST_COMMENT.getPath()));
        return driver.findElement(LAST_COMMENT.getPath()).getText();
    }

    /**
     * Clicks comment button and waits until it's disabled
     * (at this time the new comment is supposed to be published)
     */
    public CommentsPO clickCommentButton() {
        getCommentButton().click();
        waitsSwitcher.setExplicitWait(ExpectedConditions.not(ExpectedConditions
                .elementToBeClickable(COMMENT_BUTTON.getPath())));
        return this;
    }
}

