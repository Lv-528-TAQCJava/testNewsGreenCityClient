package com.ss.greencity;

import com.ss.greencity.pageobjects.EcoNewsListPO;
import com.ss.greencity.pageobjects.NewsCardComponent;
import org.junit.Assert;
import org.junit.Test;

/**
 * Verifies that news can be displayed in gallery or list view mode.
 */

public class EcoNewsViewModeTest extends EcoNewsTestRunner {

    @Test
    public void getNewsDefaultView() {
        EcoNewsListPO newsList = new EcoNewsListPO(driver);
        String classAttribute = newsList.getGalleryViewButton().getAttribute("class");
        Assert.assertEquals("gallery-view gallery-view-active", classAttribute);
    }

    @Test
    public void setNewsView() {
        EcoNewsListPO newsList = new EcoNewsListPO(driver);
        newsList.getListViewButton().click();
        String classAttribute = newsList.getListViewButton().getAttribute("class");
        Assert.assertEquals("list-view list-view-active", classAttribute);
        NewsCardComponent news = newsList.getFirstNewsCard();
        Assert.assertEquals("list-view-li-active ng-star-inserted", news.getClassName());
    }

    @Test
    public void listViewAfterRefresh() {
        EcoNewsListPO newsList = new EcoNewsListPO(driver);
        newsList.getListViewButton().click();
        newsList.refreshPage();
        String classAttribute = newsList.getListViewButton().getAttribute("class");
        Assert.assertEquals("list-view list-view-active", classAttribute);
    }

    @Test
    public void galleryViewAfterRefresh() {
        EcoNewsListPO newsList = new EcoNewsListPO(driver);
        newsList.refreshPage();
        String classAttribute = newsList.getGalleryViewButton().getAttribute("class");
        Assert.assertEquals("gallery-view gallery-view-active", classAttribute);
    }
}
