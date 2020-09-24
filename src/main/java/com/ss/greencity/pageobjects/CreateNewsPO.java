package com.ss.greencity.pageobjects;

import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.InputBox;
import com.ss.greencity.pageelements.Label;
import org.openqa.selenium.WebDriver;

import static com.ss.greencity.locators.CreateNewsLocators.*;

public class CreateNewsPO extends BasePageObject {

    public CreateNewsPO(WebDriver driver){
        super(driver);
    }

    private InputBox titleField;
    private InputBox contentField;
    private InputBox sourceField;

    private Button newsButton;
    private Button events;
    private Button education;
    private Button initiative;
    private Button ads;
    private Button cancel;
    private Button preview;
    private Button publish;
    private Button continueEditing;
    private Button yesCancel;

    private Label date;
    private Label author;
    private Label warningSource;
    private Label contentWarning;
    private Label tagsWarning;
    private Label pictureUpload;


    public InputBox getTitleInputBox(){
        titleField = new InputBox(driver.findElement(TITLE_FIELD.getPath()));
        return titleField;
    }
    public CreateNewsPO setTitle(String value){
        this.getTitleInputBox().click().setData(value);
        return this;
    }
    public String getTitleText(){
        return this.getTitleInputBox().getAttribute("value");
    }
    public InputBox getSourceInputBox(){
        sourceField = new InputBox(driver.findElement(SOURS_FIELD.getPath()));
        return sourceField;
    }
    public CreateNewsPO setSource(String value){
        this.getSourceInputBox().click().setData(value);
        return this;
    }
    public String getSourceText(){
        return this.getSourceInputBox().getAttribute("value");
    }
    public InputBox getContentInputBox(){
        contentField = new InputBox(driver.findElement(CONTENT.getPath()));
        return contentField;
    }
    public CreateNewsPO setContent(String value){
        this.getContentInputBox().click().setData(value);
        return this;
    }
    public String getContentText(){
        return this.getContentInputBox().getAttribute("value");
    }


    public CreateNewsPO clickNewsTagButton(){
        newsButton = new Button(driver.findElement(NEWS_BUTTON.getPath()));
        newsButton.click();
        return this;
    }
    public CreateNewsPO clickEventTagButton(){
        events = new Button(driver.findElement(EVENTS_BUTTON.getPath()));
        events.click();
        return this;
    }
    public CreateNewsPO clickEducationTagButton(){
        education = new Button(driver.findElement(EDUCATION_BUTTON.getPath()));
        education.click();
        return this;
    }
    public CreateNewsPO clickInitiativeTagButton(){
        initiative = new Button(driver.findElement(INITIATIVE_BUTTON.getPath()));
        initiative.click();
        return this;
    }
    public CreateNewsPO clickAdsTagButton(){
        ads = new Button(driver.findElement(ADS_BUTTON.getPath()));
        ads.click();
        return this;
    }
    public String getDateText(){
        date = new Label(driver.findElement(DATE.getPath()));
        return date.getText();
    }
    public String getAuthorText(){
        author = new Label(driver.findElement(AUTHOR.getPath()));
        return author.getText();
    }
    public CreateNewsPO clickCancelButton(){
        cancel = new Button(driver.findElement(CANCEL_BUTTON.getPath()));
        cancel.click();
        return this;
    }
    public CreateNewsPO clickPreviewButton(){
        preview = new Button(driver.findElement(PREVIEW_BUTTON.getPath()));
        preview.click();
        return this;
    }
    public CreateNewsPO clickPublishButton(){
        publish = new Button(driver.findElement(PUBLISH_BUTTON.getPath()));
        publish.click();
        return this;
    }
    public CreateNewsPO clickContinueEditingButton(){
        continueEditing = new Button(driver.findElement(CONTINUE_EDIT_BUTTON.getPath()));
        continueEditing.click();
        return this;
    }
    public CreateNewsPO clickYesCancelButton(){
        yesCancel = new Button(driver.findElement(YES_CANCEL_BUTTON.getPath()));
        yesCancel.click();
        return this;
    }

    public Label getSourceWarning(){
        warningSource = new Label(driver.findElement(WARNING_SOURCE.getPath()));
        return warningSource;
    }

    public Label getContentWarning(){
        contentWarning = new Label(driver.findElement(WARNING_CONTENT.getPath()));
        return contentWarning;
    }

    public Label getTagsWarning(){
        tagsWarning = new Label(driver.findElement(WARNING_TAGS.getPath()));
        return tagsWarning;
    }

    public Label getPictureUploadLink(){
        pictureUpload = new Label(driver.findElement(PICTURE_UPLOAD_LINK.getPath()));
        return pictureUpload;
    }

}
