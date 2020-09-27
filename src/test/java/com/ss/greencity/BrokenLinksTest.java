package com.ss.greencity;

import com.ss.greencity.pageelements.Link;
import com.ss.greencity.pageobjects.EcoNewsListPO;
import com.ss.greencity.pageobjects.Error404PO;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

public class BrokenLinksTest extends EcoNewsTestRunner {
    @Test
    public void noBrokenLinksTest() {
        EcoNewsListPO newsList = new EcoNewsListPO(driver);
        ArrayList<Link> links = newsList.getAllLinks();
        for(Link link : links) {
            String href = link.getReference();
            System.out.println(href);
            driver.navigate().to(href);
            Error404PO error404 = new Error404PO(driver);
            Assert.assertTrue("Verifying that page " + href + " exists", error404.pageExists());
            //driver.navigate().back();
        }
    }
}
