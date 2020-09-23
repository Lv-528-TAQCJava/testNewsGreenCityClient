package com.ss.greencity.pageobjects;

import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.InputBox;
import com.ss.greencity.pageelements.Label;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static com.ss.greencity.locators.CreateNewsLocators.*;

public class CreateNewsPO extends BasePageObject {

    public CreateNewsPO(WebDriver driver){
        super(driver);
    }
    public CreateNewsPO clickNewsButton(){
        Button newsButton = new Button(driver.findElement(NEWS_BUTTON.getPath()));
        newsButton.click();
        return this;
    }
    public CreateNewsPO clickEventsButton(){
        Button events = new Button(driver.findElement(EVENTS_BUTTON.getPath()));
        events.click();
        return this;
    }
    public CreateNewsPO clickEducationButton(){
        Button education = new Button(driver.findElement(EDUCATION_BUTTON.getPath()));
        education.click();
        return this;
    }
    public CreateNewsPO clickInitiativeButton(){
        Button initiative = new Button(driver.findElement(INITIATIVE_BUTTON.getPath()));
        initiative.click();
        return this;
    }
    public CreateNewsPO clickAdsButton(){
        Button ads = new Button(driver.findElement(ADS_BUTTON.getPath()));
        ads.click();
        return this;
    }
    public String getDate(){
        Label date = new Label(driver.findElement(DATE.getPath()));
        return date.getText();
    }
    public String getAuthor(){
        Label author = new Label(driver.findElement(AUTHOR.getPath()));
        return author.getText();
    }
    public CreateNewsPO clickCancelButton(){
        Button cancel = new Button(driver.findElement(CANCEL_BUTTON.getPath()));
        cancel.click();
        return this;
    }
    public CreateNewsPO clickPreviewButton(){
        Button preview = new Button(driver.findElement(PREVIEW_BUTTON.getPath()));
        preview.click();
        return this;
    }
    public CreateNewsPO clickPublishButton(){
        Button publish = new Button(driver.findElement(PUBLISH_BUTTON.getPath()));
        publish.click();
        return this;
    }
    public CreateNewsPO clickContinueEditingButton(){
        Button continueEditing = new Button(driver.findElement(CONTINUE_EDIT_BUTTON.getPath()));
        continueEditing.click();
        return this;
    }
    public CreateNewsPO clickYesCancelButton(){
        Button yesCancel = new Button(driver.findElement(YES_CANCEL_BUTTON.getPath()));
        yesCancel.click();
        return this;
    }
    public CreateNewsPO setTitleField(String value){
        InputBox titleField = new InputBox(driver.findElement(TITLE_FIELD.getPath()));
        titleField.click();
        titleField.setData(value);
        return this;
    }
    public CreateNewsPO setSourceField(String value){
        InputBox sourceField = new InputBox(driver.findElement(SOURS_FIELD.getPath()));
        sourceField.click();
        sourceField.setData(value);
        return this;
    }
    public CreateNewsPO setContentField(String value){
        InputBox contentField = new InputBox(driver.findElement(CONTENT.getPath()));
        contentField.click();
        contentField.setData(value);
        return this;
    }
    public Label getSourceWarning(){
        Label warningSource = new Label(driver.findElement(WARNING_SOURSE.getPath()));
        return warningSource;
    }
    public boolean isSourceWarningPresent() {
        try {
            getSourceWarning();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public Label getContentWarning(){
        Label contentWarning = new Label(driver.findElement(WARNING_CONTENT.getPath()));
        return contentWarning;
    }
    public boolean isContentWarningPresent() {
        try {
            getContentWarning();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public Label getTagsWarning(){
        Label tagsWarning = new Label(driver.findElement(WARNING_TAGS.getPath()));
        return tagsWarning;
    }
    public boolean isTagsWarningPresent() {
        try {
            getTagsWarning();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isPublishButtonEnable(){
        boolean isEnable = driver.findElement(PUBLISH_BUTTON.getPath()).isEnabled();
        return isEnable;
    }

}
