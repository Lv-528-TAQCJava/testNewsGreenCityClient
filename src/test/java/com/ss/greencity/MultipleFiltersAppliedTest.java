package com.ss.greencity;

import com.ss.greencity.pageelements.Label;
import com.ss.greencity.pageobjects.EcoNewsListPO;
import com.ss.greencity.pageobjects.NewsCardComponent;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MultipleFiltersAppliedTest extends EcoNewsTestRunner {
    @Test
    public void multipleFiltersAppliedTest() {
        EcoNewsListPO news = new EcoNewsListPO(driver);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String[] tags = {"Education", "Initiatives"};
        news.getFilterButton(tags[0]).click();
        news.getFilterButton(tags[1]).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<NewsCardComponent> allNews = news.getAllNews();
        int correctlyTaggedCount = 0;

        for (NewsCardComponent newsCard : allNews) {
            boolean isTagsCorrect = false;
            for (Label tag : newsCard.getTags()) {
                for (String appliedTag : tags) {
                    if (tag.getText().equals(appliedTag.toUpperCase())) {
                        isTagsCorrect = true;
                        break;
                    }
                }
                if (isTagsCorrect) {
                    correctlyTaggedCount++;
                    break;
                }
            }
        }
        assertEquals("Count of correctly tagged news", allNews.size(), correctlyTaggedCount);
    }
}
