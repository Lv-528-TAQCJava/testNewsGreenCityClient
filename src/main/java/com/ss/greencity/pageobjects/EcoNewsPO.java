package com.ss.greencity.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EcoNewsPO extends BasePageObject {
    By newsTextSelector = By.cssSelector("div.news-text");
    WebElement newsText;

    public EcoNewsPO(WebDriver driver) {
        super(driver);

    }

    public String getNewsText() {
        newsText = driver.findElement(newsTextSelector);
        return newsText.getText();
    }
}
