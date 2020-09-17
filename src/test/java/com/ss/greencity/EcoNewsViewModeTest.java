package com.ss.greencity;

import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageobjects.EcoNewsListPO;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

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
    }


}
