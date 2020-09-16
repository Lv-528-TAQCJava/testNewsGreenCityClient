package com.ss.greencity;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Checks opening of news articles
 */
public class EcoNewsOpenNewsTest extends EcoNewsTestRunner {
    @Test
    public void openFirstNews() {
        WebElement firstNews = driver.findElements(allNewsCards).get(0);
        firstNews.click();
        WebElement newsContent = driver.findElement(By.cssSelector("div.news-content"));
        String text = newsContent.getText();
        Assert.assertTrue("Verifying that news content is not empty", text.length() > 0);
    }
}
