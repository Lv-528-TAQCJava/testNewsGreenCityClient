package com.ss.greencity;

import com.ss.greencity.locators.EcoNewsLocators;
import com.ss.greencity.locators.HeaderLocators;
import com.ss.greencity.locators.NewsPageLocators;
import com.ss.greencity.pageelements.Link;
import com.ss.greencity.pageobjects.EcoNewsListPO;
import com.ss.greencity.pageobjects.EcoNewsPO;
import com.ss.greencity.pageobjects.Error404PO;
import com.ss.greencity.util.Languages;
import com.ss.greencity.util.WaitsSwitcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

/**
 * Check whether pages specified in DataPoints has no
 */
//@RunWith(Theories.class)
public class BrokenLinksTest extends EcoNewsTestRunner {
    @DataPoints
    public static final String[] pagesToCheck = {
            "https://ita-social-projects.github.io/GreenCityClient/#/news",
            "https://ita-social-projects.github.io/GreenCityClient/#/welcome",
            "https://ita-social-projects.github.io/GreenCityClient/#/news/3129"
    };

    @Override
    @Before
    public void setUp() {
        //Since we use different URLs in different methods, there is no need to start always from Eco news page
    }

    //@Theory //doesn't work well, some pages have content with links that loads later
    public void noBrokenLinksTest(String pageUrl) {
        System.out.println("Checking links on page " + pageUrl);
        driver.navigate().to(pageUrl);
        WaitsSwitcher.sleep(4);
        Error404PO page = new Error404PO(driver);
        ArrayList<Link> links = page.getAllLinks();
        noBrokenLinks(links);
    }

    @Test
    public void noBrokenLinksAtEcoNewsTest() {
        driver.navigate().to("https://ita-social-projects.github.io/GreenCityClient/#/news");
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .presenceOfElementLocated(EcoNewsLocators.FIRST_NEWS_CARD.getPath()));
        EcoNewsListPO newsList = new EcoNewsListPO(driver);
        ArrayList<Link> links = newsList.getAllLinks();
        noBrokenLinks(links);
    }

    @Test
    public void noBrokenLinksAtNewsPageTest() {
        driver.navigate().to("https://ita-social-projects.github.io/GreenCityClient/#/news/3129");
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .presenceOfElementLocated(NewsPageLocators.NEWS_TEXT.getPath()));
        EcoNewsPO newsPage = new EcoNewsPO(driver);
        ArrayList<Link> links = newsPage.getAllLinks();
        noBrokenLinks(links);
    }

    @Test
    public void noBrokenLinksAtWelcomeTest() {
        driver.navigate().to("https://ita-social-projects.github.io/GreenCityClient/#/welcome");
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("div.main-event div.main-event")));
        Error404PO welcomePage = new Error404PO(driver); //using this since no page object for Welcome page created
        ArrayList<Link> links = welcomePage.getAllLinks();
        noBrokenLinks(links);
    }

    /**
     * A method with reused logic
     */
    private void noBrokenLinks(ArrayList<Link> links) {
        ArrayList<String> hrefs = new ArrayList<>();
        for(Link link : links) {
            hrefs.add(link.getReference());
        }
        for(String href : hrefs) {
            System.out.println("\t Checking presence of page: " + href);
            driver.navigate().to(href);
            Error404PO error404 = new Error404PO(driver);
            Assert.assertTrue("Verifying that page " + href + " exists", error404.pageExists());
        }
    }
}
