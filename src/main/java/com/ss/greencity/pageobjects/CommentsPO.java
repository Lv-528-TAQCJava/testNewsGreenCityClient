package com.ss.greencity.pageobjects;

import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.InputBox;
import org.openqa.selenium.WebDriver;

import static com.ss.greencity.locators.CommentsLocators.*;

public class CommentsPO extends BasePageObject {

    public CommentsPO(WebDriver driver) {
        super(driver);
    }

    public InputBox getCommentsInputbox() {
        return new InputBox(driver.findElement(COMMENTS_INPUTBOX.getPath()));
    }

    public Button getCommentButton() {
        return new Button(driver.findElement(COMMENT_BUTTON.getPath()));
    }

    public String getLastCommentText(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElement(LAST_COMMENT.getPath()).getText();
    }
}

