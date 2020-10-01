package com.ss.greencity.pageobjects;

import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.InputBox;
import com.ss.greencity.pageelements.Label;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.ss.greencity.locators.CreateNewsLocators.*;

public class CreateNewsPO extends BasePageObject implements IAnonymousPO, ILoggedInPO {

    private InputBox titleField;
    private InputBox contentField;
    private InputBox sourceField;

    private Button newsTagButton;
    private Button eventTagButton;
    private Button educationTagButton;
    private Button initiativeTagButton;
    private Button adsTagButton;
    private Button cancel;
    private Button preview;
    private Button publish;

    private Label date;
    private Label author;
    private Label warningSource;
    private Label contentWarning;
    private Label tagsWarning;
    private Label pictureUpload;


    public CreateNewsPO(WebDriver driver){
        super(driver);
        init();
    }
    private void init(){
        titleField = new InputBox(driver.findElement(TITLE_FIELD.getPath()));
        sourceField = new InputBox(driver.findElement(SOURS_FIELD.getPath()));
        contentField = new InputBox(driver.findElement(CONTENT.getPath()));

        newsTagButton = new Button(driver.findElement(NEWS_BUTTON.getPath()));
        eventTagButton = new Button(driver.findElement(EVENTS_BUTTON.getPath()));
        educationTagButton = new Button(driver.findElement(EDUCATION_BUTTON.getPath()));
        initiativeTagButton = new Button(driver.findElement(INITIATIVE_BUTTON.getPath()));
        adsTagButton = new Button(driver.findElement(ADS_BUTTON.getPath()));

        date = new Label(driver.findElement(DATE.getPath()));
        author = new Label(driver.findElement(AUTHOR.getPath()));

        cancel = new Button(driver.findElement(CANCEL_BUTTON.getPath()));
        preview = new Button(driver.findElement(PREVIEW_BUTTON.getPath()));
        publish = new Button(driver.findElement(PUBLISH_BUTTON.getPath()));

    }

    public InputBox getTitleInputBox(){
      waitsSwitcher.setExplicitWait(ExpectedConditions
                .visibilityOfElementLocated(TITLE_FIELD.getPath()));
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
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .visibilityOfElementLocated(SOURS_FIELD.getPath()));
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
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .visibilityOfElementLocated(CONTENT.getPath()));
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


    public Button getNewsTagButton(){
        return newsTagButton;
    }
    public CreateNewsPO clickNewsTagButton(){
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .visibilityOfElementLocated(NEWS_BUTTON.getPath()));
        newsButton = new Button(driver.findElement(NEWS_BUTTON.getPath()));
        newsButton.click();
        return this;
    }
    public Button getEventTagButton(){
        return eventTagButton;
    }
    public CreateNewsPO clickEventTagButton(){
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .visibilityOfElementLocated(EVENTS_BUTTON.getPath()));
        events = new Button(driver.findElement(EVENTS_BUTTON.getPath()));
        events.click();
        return this;
    }
    public Button getEducationTagButton(){
        return educationTagButton;
    }
    public CreateNewsPO clickEducationTagButton(){
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .visibilityOfElementLocated(EDUCATION_BUTTON.getPath()));
        education = new Button(driver.findElement(EDUCATION_BUTTON.getPath()));
        education.click();
        return this;
    }

    public Button getInitiativeTagButton(){
        return initiativeTagButton;
    }
    public CreateNewsPO clickInitiativeTagButton(){
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .visibilityOfElementLocated(INITIATIVE_BUTTON.getPath()));
        initiative = new Button(driver.findElement(INITIATIVE_BUTTON.getPath()));
        initiative.click();
        return this;
    }
    public CreateNewsPO clickAdsTagButton(){
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .visibilityOfElementLocated(ADS_BUTTON.getPath()));
        ads = new Button(driver.findElement(ADS_BUTTON.getPath()));
        ads.click();
        return this;
    }

    public Label getDateLabel(){
        return date;
    }
    public String getDateText(){
        return this.getDateLabel().getText();
    }
    public Label getAuthorLabel(){
        return author;
    }
    public String getAuthorText(){
        return this.getAuthorLabel().getText();
    }
    public Button getPreviewButton(){
        return preview;
    }
    public Button getPublishButton(){
        return publish;
    }
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .visibilityOfElementLocated(DATE.getPath()));
        date = new Label(driver.findElement(DATE.getPath()));
        return date.getText();
    }
    public String getAuthorText(){
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .visibilityOfElementLocated(AUTHOR.getPath()));
        author = new Label(driver.findElement(AUTHOR.getPath()));
        return author.getText();
    }
    public CreateNewsPO clickCancelButton(){
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .visibilityOfElementLocated(CANCEL_BUTTON.getPath()));
        cancel = new Button(driver.findElement(CANCEL_BUTTON.getPath()));
        cancel.click();
        return this;
    }
    public PreviewNewsPO goToPreviewNewsPage(){
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .visibilityOfElementLocated(PREVIEW_BUTTON.getPath()));
        preview = new Button(driver.findElement(PREVIEW_BUTTON.getPath()));
        preview.click();
        return new PreviewNewsPO(driver);
    }
    public CreateNewsPO clickPublishButton(){
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .visibilityOfElementLocated(EDUCATION_BUTTON.getPath()));
        publish = new Button(driver.findElement(PUBLISH_BUTTON.getPath()));
        publish.click();
        return this;
    }

    public Label getSourceWarning(){
       try{
            warningSource = new Label(driver.findElement(WARNING_SOURCE.getPath()));
        }catch (NoSuchElementException e){
        }
        return warningSource;
    }

    public Label getContentWarning(){
        try{
            contentWarning = new Label(driver.findElement(WARNING_CONTENT.getPath()));
        }catch (NoSuchElementException e){
        }
        return contentWarning;
    }

    public Label getTagsWarning(){
        try{
            tagsWarning = new Label(driver.findElement(WARNING_TAGS.getPath()));
        }catch (NoSuchElementException e){
        }
        return tagsWarning;
    }

    public Label getPictureUploadLink(){
        try{
            pictureUpload = new Label(driver.findElement(PICTURE_UPLOAD_LINK.getPath()));
        }catch (NoSuchElementException e){
        }
        return pictureUpload;
    }


}
