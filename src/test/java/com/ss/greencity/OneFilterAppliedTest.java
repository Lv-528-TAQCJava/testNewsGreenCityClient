package com.ss.greencity;

import com.ss.greencity.pageelements.Label;
import com.ss.greencity.pageobjects.EcoNewsListPO;
import com.ss.greencity.pageobjects.NewsCardComponent;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class OneFilterAppliedTest extends EcoNewsTestRunner {

    @Test
    public void oneFilterAppliedTest() {
        EcoNewsListPO news = new EcoNewsListPO(driver);
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        news.getFilterButton("Ads").click();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        List<NewsCardComponent> allnews = news.getAllNews();
        int correctlyTaggedCount = 0;

        for(NewsCardComponent newsCard: allnews) {
            for (Label tag : newsCard.getTags()) {
                if(tag.getText().equals("ADS")) {
                    correctlyTaggedCount++;
                    break;
                }
            }
        }
        assertEquals("Count of correctly tagged news", allnews.size(), correctlyTaggedCount);
    }
}
