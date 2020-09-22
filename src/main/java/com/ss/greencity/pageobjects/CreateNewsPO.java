package com.ss.greencity.pageobjects;

import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.InputBox;
import com.ss.greencity.pageelements.Label;
import org.openqa.selenium.WebDriver;

import static com.ss.greencity.locators.CreateNewsLocators.*;

public class CreateNewsPO extends BasePageObject {

    private InputBox title;
    private Button newsButton;
    private Button events;
    private Button education;
    private Button initiative;
    private Button ads;
    private Label date;
    private Label author;
    private Button cancel;
    private Button preview;
    private Button publish;
    private Button continueEdit;
    private Button yesCancel;

    public CreateNewsPO(WebDriver driver){
        super(driver);
    }
    public InputBox getTitleField(){
        title = new InputBox(driver.findElement(TITLE_FIELD.getPath()));
        return title;
    }
    public CreateNewsPO clickNewsButton(){
        newsButton = new Button(driver.findElement(NEWS_BUTTON.getPath()));
        newsButton.click();
        return this;
    }
    public CreateNewsPO clickEventsButton(){
        events = new Button(driver.findElement(EVENTS_BUTTON.getPath()));
        events.click();
        return this;
    }
    public CreateNewsPO clickEducationButton(){
        education = new Button(driver.findElement(EDUCATION_BUTTON.getPath()));
        education.click();
        return this;
    }
    public CreateNewsPO clickInitiativeButton(){
        initiative = new Button(driver.findElement(INITIATIVE_BUTTON.getPath()));
        initiative.click();
        return this;
    }
    public CreateNewsPO getAdsButton(){
        ads = new Button(driver.findElement(TITLE_FIELD.getPath()));
        ads.click();
        return this;
    }
    public String getDate(){
        date = new Label(driver.findElement(DATE.getPath()));
        return date.getText();
    }
    public String getAuthor(){
        author = new Label(driver.findElement(ATHOR.getPath()));
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
    public CreateNewsPO clickContinueEditButton(){
        continueEdit = new Button(driver.findElement(CONTINUE_EDIT_BUTTON.getPath()));
        continueEdit.click();
        return this;
    }
    public CreateNewsPO clickYesCancelButton(){
        yesCancel = new Button(driver.findElement(YES_CANCEL_BUTTON.getPath()));
        yesCancel.click();
        return this;
    }

}
