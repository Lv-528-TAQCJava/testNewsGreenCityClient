package com.ss.greencity.pageobjects;

import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.InputBox;
import com.ss.greencity.pageelements.Label;
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
    private Button continueEditing;
    private Button yesCancel;

    private Label date;
    private Label author;
    private Label warningSource;
    private Label contentWarning;
    private Label tagsWarning;
    private Label pictureUpload;



    public CreateNewsPO(WebDriver driver){
        super(driver);
    }

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


    public Button getNewsTagButton(){
        newsTagButton = new Button(driver.findElement(NEWS_BUTTON.getPath()));
        return newsTagButton;
    }
    public CreateNewsPO clickNewsTagButton(){
        this.getNewsTagButton().click();
        return this;
    }
    public Button getEventTagButton(){
        eventTagButton = new Button(driver.findElement(EVENTS_BUTTON.getPath()));
        return eventTagButton;
    }
    public CreateNewsPO clickEventTagButton(){
        this.getEventTagButton().click();
        return this;
    }
    public Button getEducationTagButton(){
        educationTagButton = new Button(driver.findElement(EDUCATION_BUTTON.getPath()));
        return educationTagButton;
    }
    public CreateNewsPO clickEducationTagButton(){
        this.getEducationTagButton().click();
        return this;
    }

    public Button getInitiativeTagButton(){
        initiativeTagButton = new Button(driver.findElement(INITIATIVE_BUTTON.getPath()));
        return initiativeTagButton;
    }
    public CreateNewsPO clickInitiativeTagButton(){
        this.getInitiativeTagButton().click();
        return this;
    }
    public Button getAdsTagButton(){
        adsTagButton = new Button(driver.findElement(ADS_BUTTON.getPath()));
        return adsTagButton;
    }
    public CreateNewsPO clickAdsTagButtonTagButton(){
        this.getAdsTagButton().click();
        return this;
    }

    public Label getDateLabel(){
        date = new Label(driver.findElement(DATE.getPath()));
        return date;
    }
    public String getDateText(){
        return this.getDateLabel().getText();
    }
    public Label getAuthorLabel(){
        author = new Label(driver.findElement(AUTHOR.getPath()));
        return author;
    }
    public String getAuthorText(){
        return this.getAuthorLabel().getText();
    }
    public Button getCancelButton(){
        cancel = new Button(driver.findElement(CANCEL_BUTTON.getPath()));
        return  cancel;
    }
    public ConfirmCancelationPO clickCancelButton(){
        this.getCancelButton().click();
        return new ConfirmCancelationPO(driver);
    }
    public Button getPreviewButton(){
        preview = new Button(driver.findElement(PREVIEW_BUTTON.getPath()));
        return preview;
    }
    public PreviewNews goToPreviewNewsPage(){
        this.getPreviewButton().click();
        return new PreviewNews(driver);
    }
    public Button getPublishButton(){
        publish = new Button(driver.findElement(PUBLISH_BUTTON.getPath()));
        return publish;
    }
    public CreateNewsPO clickPublishButton(){
        this.getPublishButton().click();
        return this;
    }
    public boolean isEnablePublishButton(){
        return this.getPublishButton().isEnable();
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
