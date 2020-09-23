package com.ss.greencity;

import com.ss.greencity.pageobjects.EcoNewsListPO;
import com.ss.greencity.pageobjects.EcoNewsPO;
import com.ss.greencity.pageobjects.NewsCardPO;
import com.ss.greencity.util.Languages;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Checks opening of news articles
 */
@RunWith(Theories.class)
public class EcoNewsOpenNewsTest extends EcoNewsTestRunner {
    @DataPoints
    public static final Languages[] languages = {Languages.ENGLISH, Languages.RUSSIAN, Languages.UKRAINIAN};

    /**
     * Verifying that there are at least 100 news
     */
    @Test
    public void numberOfItemsFoundTest() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        EcoNewsListPO newsList = new EcoNewsListPO(driver);
        String numberOfItems = newsList.getItemsFound().getText();
        String ns = Arrays.asList(numberOfItems.split(" ")).get(0);
        int n = Integer.parseInt(ns);
        System.out.println("News found: " + ns);
        assertTrue("Verifying that there are at least 100 news",n >= 100);
    }

    /**
     * Verifying that news content is not empty
     * @param lang - Theory parameter, the language chosen
     */
    @Theory
    public void openFirstNews(Languages lang) {
        EcoNewsListPO newsList = new EcoNewsListPO(driver);
        newsList.getHeaderAnonymous().selectLanguage(lang);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        newsList.getFirstNewsCard().getClickableArea().click();

        EcoNewsPO pieceOfNews = new EcoNewsPO(driver);
        closeSignUpForm();
        String text = pieceOfNews.getNewsText();
        System.out.println("Length of news text: " + text.length() + "\t" + text.substring(0, Math.min(text.length(), 100)));
        Assert.assertTrue(lang.getCode() + ": Verifying that news content is not empty", text.length() > 0);
    }

    /**
     * Verifying that date and author are equal in a news card and in news page
     * @param lang - Theory parameter, the language chosen
     */
    @Theory
    public void checkAuthorAndDate(Languages lang) {
        EcoNewsListPO newsList = new EcoNewsListPO(driver);
        newsList.getHeaderAnonymous().selectLanguage(lang);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        NewsCardPO card = newsList.getFirstNewsCard();
        String dateInCard = card.getDate().getText();
        String authorInCard = card.getAuthor().getText();
        card.getClickableArea().click();

        EcoNewsPO pieceOfNews = new EcoNewsPO(driver);
        closeSignUpForm();
        Assert.assertEquals(lang.getCode() + ": Verifying that date is equal in a news card and in news page",
                dateInCard, pieceOfNews.getDate());
        Assert.assertTrue(lang.getCode() + ": Verifying that author is equal in a news card and in news page",
                pieceOfNews.getAuthor().contains(authorInCard));

    }

}
