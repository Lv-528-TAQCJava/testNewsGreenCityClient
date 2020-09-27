package com.ss.greencity;

import com.ss.greencity.locators.EcoNewsLocators;
import com.ss.greencity.pageobjects.EcoNewsListPO;
import com.ss.greencity.pageobjects.EcoNewsPO;
import com.ss.greencity.pageobjects.NewsCardPO;
import com.ss.greencity.util.Languages;
import com.ss.greencity.util.PopUpWindowsCloser;
import com.ss.greencity.util.WaitsSwitcher;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .presenceOfElementLocated(EcoNewsLocators.FIRST_NEWS_CARD.getPath()));
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
        newsList.getHeaderAnonymous(newsList.getDriver()).selectLanguage(lang);
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .presenceOfElementLocated(EcoNewsLocators.FIRST_NEWS_CARD.getPath()));
        newsList.getFirstNewsCard().getClickableArea().click();

        EcoNewsPO pieceOfNews = new EcoNewsPO(driver);
        //PopUpWindowsCloser.closeSignUpForm(driver); //the form doesn't appear anymore
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
        newsList.getHeaderAnonymous(newsList.getDriver()).selectLanguage(lang);
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .presenceOfElementLocated(EcoNewsLocators.FIRST_NEWS_CARD.getPath()));

        NewsCardPO card = newsList.getFirstNewsCard();
        String dateInCard = card.getDate().getText();
        String authorInCard = card.getAuthor().getText();
        card.getClickableArea().click();

        EcoNewsPO pieceOfNews = new EcoNewsPO(driver);
        //PopUpWindowsCloser.closeSignUpForm(driver);
        Assert.assertEquals(lang.getCode() + ": Verifying that date is equal in a news card and in news page",
                dateInCard, pieceOfNews.getDate());
        Assert.assertTrue(lang.getCode() + ": Verifying that author is equal in a news card and in news page",
                pieceOfNews.getAuthor().contains(authorInCard));

    }

}
