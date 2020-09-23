package com.ss.greencity.pageobjects;

import com.ss.greencity.locators.EcoNewsLocators;
import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.InputBox;
import com.ss.greencity.pageelements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The main part of a single piece of news page
 * https://ita-social-projects.github.io/GreenCityClient/#/news/3077
 */
public class EcoNewsPO extends BasePageObject {
    By newsTextSelector = By.cssSelector("div.news-text");
    WebElement newsText;
    By dateSelector = By.cssSelector("div.news-info-date");
    WebElement date;
    By authorSelector = By.cssSelector("div.news-info-author");
    WebElement author;


    public EcoNewsPO(WebDriver driver) {
        super(driver);

    }

    public String getNewsText() {
        newsText = driver.findElement(newsTextSelector);
        return newsText.getText();
    }
    public String getDate() {
        date = driver.findElement(dateSelector);
        return date.getText();
    }
    public String getAuthor() {
        author = driver.findElement(authorSelector);
        return author.getText(); //Mind that this starts with "by..."
    }
    public EcoNewsPO clickCreateNewsButton(){
        Button createNews = new Button(driver.findElement(EcoNewsLocators.CREATE_NEWS.getPath()));
        createNews.click();
        return this;
    }
    public EcoNewsPO clickEcoNewsButton(){
        Button ecoNewsButton = new Button((driver.findElement(EcoNewsLocators.NEWS_BUTTON.getPath())));
        ecoNewsButton.click();
        return this;
    }

}
