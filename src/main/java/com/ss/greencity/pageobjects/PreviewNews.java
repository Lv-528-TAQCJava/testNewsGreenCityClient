package com.ss.greencity.pageobjects;

import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.Label;
import com.ss.greencity.pageelements.Link;
import org.openqa.selenium.WebDriver;

import static com.ss.greencity.locators.PreviewLocators.*;

public class PreviewNews extends BasePageObject {

    public PreviewNews(WebDriver driver){
        super(driver);
    }

    private Label title;
    private Label content;
    private Label sourceText;
    private Label sourceTitleText;

    private Link backToEditing;

    private Button newsTag;

    public String getTitleText(){
        title = new Label(driver.findElement(TITLE.getPath()));
        return title.getText();
    }
    public String getContentText(){
        content = new Label(driver.findElement(CONTENT.getPath()));
        return content.getText();
    }
    public String getSourceText(){
        sourceText = new Label(driver.findElement(SOURCE_TEXT.getPath()));
        return sourceText.getText();
    }
    public String getSourceTitleText(){
        sourceTitleText = new Label(driver.findElement(SOURCE_TITLE.getPath()));
        return sourceTitleText.getText();
    }
    public PreviewNews clickBackToEditingLink(){
        backToEditing = new Link(driver.findElement(BACK_TO_EDITING_LINK.getPath()));
        backToEditing.click();
        return this;
    }
    public Button getEducationTag(){
        newsTag = new Button(driver.findElement(TAGS_EDUCATION.getPath()));
        return newsTag;
    }

}

