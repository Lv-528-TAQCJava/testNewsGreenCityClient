package com.ss.greencity;

import com.ss.greencity.pageobjects.EcoNewsListPO;
import com.ss.greencity.pageobjects.EcoNewsPO;
import com.ss.greencity.pageobjects.NewsCardPO;
import com.ss.greencity.pageobjects.SignUpPO;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Checks opening of news articles
 */
public class EcoNewsOpenNewsTest extends EcoNewsTestRunner {
    @Test
    public void numberOfItemsFoundTest() {
        EcoNewsListPO newsList = new EcoNewsListPO(driver);
        String numberOfItems = newsList.getItemsFound().getText();
        String ns = Arrays.asList(numberOfItems.split(" ")).get(0);
        int n = Integer.parseInt(ns);
        System.out.println("News found: " + ns);
        assertTrue("Verifying that there are at least 100 news",n >= 100);
    }

    @Test
    public void openFirstNews() {
        EcoNewsListPO newsList = new EcoNewsListPO(driver);
        newsList.getFirstNewsCard().getClickableArea().click();

        EcoNewsPO pieceOfNews = new EcoNewsPO(driver);
        closeSignUpForm();
        String text = pieceOfNews.getNewsText();
        System.out.println("Length of news text: " + text.length() + "\t" + text.substring(0, Math.min(text.length(), 100)));
        Assert.assertTrue("Verifying that news content is not empty", text.length() > 0);
    }

    @Test
    public void checkAuthorAndDate() {
        EcoNewsListPO newsList = new EcoNewsListPO(driver);
        NewsCardPO card = newsList.getFirstNewsCard();
        String dateInCard = card.getDate().getText();
        String authorInCard = card.getAuthor().getText();
        card.getClickableArea().click();

        EcoNewsPO pieceOfNews = new EcoNewsPO(driver);
        closeSignUpForm();
        Assert.assertEquals("Verifying that date is equal in a news card and in news page",
                dateInCard, pieceOfNews.getDate());
        Assert.assertTrue("Verifying that author is equal in a news card and in news page",
                pieceOfNews.getAuthor().contains(authorInCard));

    }

}
