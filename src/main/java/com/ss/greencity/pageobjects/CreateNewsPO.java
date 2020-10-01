package com.ss.greencity.pageobjects;

import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.InputBox;
import com.ss.greencity.pageelements.Label;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

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
        this.getNewsTagButton().click();
        return this;
    }
    public Button getEventTagButton(){
        return eventTagButton;
    }
    public CreateNewsPO clickEventTagButton(){
        this.getEventTagButton().click();
        return this;
    }
    public Button getEducationTagButton(){
        return educationTagButton;
    }
    public CreateNewsPO clickEducationTagButton(){
        this.getEducationTagButton().click();
        return this;
    }

    public Button getInitiativeTagButton(){
        return initiativeTagButton;
    }
    public CreateNewsPO clickInitiativeTagButton(){
        this.getInitiativeTagButton().click();
        return this;
    }
    public Button getAdsTagButton(){
        return adsTagButton;
    }
    public CreateNewsPO clickAdsTagButtonTagButton(){
        this.getAdsTagButton().click();
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
    public Button getCancelButton(){
        return  cancel;
    }
    public ConfirmCancelationPO clickCancelButton(){
        this.getCancelButton().click();
        return new ConfirmCancelationPO(driver);
    }
    public Button getPreviewButton(){
        return preview;
    }
    public PreviewNewsPO goToPreviewNewsPage(){
        this.getPreviewButton().click();
        return new PreviewNewsPO(driver);
    }
    public Button getPublishButton(){
        return publish;
    }
    public CreateNewsPO clickPublishButton(){
        this.getPublishButton().click();
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
