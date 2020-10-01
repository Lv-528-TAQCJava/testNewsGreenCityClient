package com.ss.greencity.pageobjects;

import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.Label;
import com.ss.greencity.pageelements.Link;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static com.ss.greencity.locators.PreviewLocators.*;

public class PreviewNewsPO extends BasePageObject {

    public PreviewNewsPO(WebDriver driver){
        super(driver);
    }

    private Label title;
    private Label content;
    private Label source;
    private Label sourceTitle;
    private Label date;
    private Label author;

    private Link backToEditing;

    private Button newsTag;
    private Button publishButton;

    public Label getTitleLabel(){
        title = new Label(driver.findElement(TITLE.getPath()));
        return this.title;
    }
    public Label getContentLabel(){
        content = new Label(driver.findElement(CONTENT.getPath()));
        return this.content;
    }
    public Label getSourceLabel(){
        source = new Label(driver.findElement(SOURCE_TEXT.getPath()));
        return this.source;
    }
    public Label getSourceTitleLabel(){
        sourceTitle = new Label(driver.findElement(SOURCE_TITLE.getPath()));
        return this.sourceTitle;
    }
    public Label getDateLabel(){
        date = new Label(driver.findElement(DATE.getPath()));
        return this.date;
    }
    public Label getAuthorLabel(){
        author = new Label(driver.findElement(AUTHOR.getPath()));
        return this.author;
    }
    public Link getBackToEditingLink(){
        backToEditing = new Link(driver.findElement(BACK_TO_EDITING_LINK.getPath()));
        return this.backToEditing;
    }
    public CreateNewsPO clickBackToEditingLink(){
        this.getBackToEditingLink().click();
        return new CreateNewsPO(driver);
    }
    public Button getEducationTag(){
        try{
            newsTag = new Button(driver.findElement(TAGS_EDUCATION.getPath()));
        }catch (NoSuchElementException e){
        }
        return newsTag;
    }

    public Button getPublishButton(){
        try{
            publishButton = new Button(driver.findElement(PUBLISH_BUTTON.getPath()));
        }catch (NoSuchElementException e){
        }
        return publishButton;
    }

}

