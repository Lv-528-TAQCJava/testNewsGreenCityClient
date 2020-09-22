package com.ss.greencity;

import com.ss.greencity.pageobjects.EcoNewsListPO;
import com.ss.greencity.pageobjects.EcoNewsPO;
import com.ss.greencity.pageobjects.NewsCardPO;
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
    public static final String[] languages = {"En", "Ru", "Uk"};

    /**
     * Verifying that there are at least 100 news
     */
    @Test
    public void numberOfItemsFoundTest() {
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
    public void openFirstNews(String lang) {
        EcoNewsListPO newsList = new EcoNewsListPO(driver);
        newsList.getHeader().selectLanguage(lang);
        newsList.getFirstNewsCard().getClickableArea().click();

        EcoNewsPO pieceOfNews = new EcoNewsPO(driver);
        closeSignUpForm();
        String text = pieceOfNews.getNewsText();
        System.out.println("Length of news text: " + text.length() + "\t" + text.substring(0, Math.min(text.length(), 100)));
        Assert.assertTrue(lang + ": Verifying that news content is not empty", text.length() > 0);
    }

    /**
     * Verifying that date and author are equal in a news card and in news page
     * @param lang - Theory parameter, the language chosen
     */
    @Theory
    public void checkAuthorAndDate(String lang) {
        EcoNewsListPO newsList = new EcoNewsListPO(driver);
        newsList.getHeader().selectLanguage(lang);

        NewsCardPO card = newsList.getFirstNewsCard();
        String dateInCard = card.getDate().getText();
        String authorInCard = card.getAuthor().getText();
        card.getClickableArea().click();

        EcoNewsPO pieceOfNews = new EcoNewsPO(driver);
        closeSignUpForm();
        Assert.assertEquals(lang + ": Verifying that date is equal in a news card and in news page",
                dateInCard, pieceOfNews.getDate());
        Assert.assertTrue(lang + ": Verifying that author is equal in a news card and in news page",
                pieceOfNews.getAuthor().contains(authorInCard));

    }

}
