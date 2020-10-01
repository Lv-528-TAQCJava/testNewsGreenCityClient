package com.ss.greencity.pageobjects;

import com.ss.greencity.locators.EcoNewsLocators;
import com.ss.greencity.locators.NewsPageLocators;
import com.ss.greencity.pageelements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * The main part of a single piece of news page
 * https://ita-social-projects.github.io/GreenCityClient/#/news/3077
 */
public class EcoNewsArticlePO extends BasePageObject implements IAnonymousPO, ILoggedInPO {
    By newsTextSelector = NewsPageLocators.NEWS_TEXT.getPath();
    WebElement newsText;
    By dateSelector = NewsPageLocators.DATE.getPath();
    WebElement date;
    By authorSelector = NewsPageLocators.AUTHOR.getPath();
    WebElement author;


    public EcoNewsArticlePO(WebDriver driver) {
        super(driver);

    }

    public String getNewsText() {
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .presenceOfElementLocated(newsTextSelector));
        newsText = driver.findElement(newsTextSelector);
        return newsText.getText();
    }
    public String getDate() {
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .presenceOfElementLocated(dateSelector));
        date = driver.findElement(dateSelector);
        return date.getText();
    }
    public String getAuthor() {
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .presenceOfElementLocated(authorSelector));
        author = driver.findElement(authorSelector);
        return author.getText(); //Mind that this starts with "by..."
    }

}
