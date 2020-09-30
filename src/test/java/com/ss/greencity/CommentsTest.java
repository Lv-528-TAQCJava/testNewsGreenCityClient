package com.ss.greencity;

import com.ss.greencity.pageobjects.*;
import com.ss.greencity.util.WaitsSwitcher;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CommentsTest extends EcoNewsTestRunner {

    @Test
    public void addComment() {
        System.out.println("Sign in");
        SignInPO signInPO = new SignInPO(driver);
        signInPO.clickSignInButton()
                .setEmail("aliejua@gmail.com")
                .setPassword("Aa12345_")
                .clickSignInUserButton();

        System.out.println("Go to Eco News, open the first news card");
        HeaderSignedInComponent HeaderSignedInComponent = new HeaderSignedInComponent(driver);

        HeaderSignedInComponent.getNews().click();
        EcoNewsListPO newsListPO = new EcoNewsListPO(driver);
        newsListPO.getFirstNewsCard().getClickableArea().click();

        System.out.println("Add a new comment");
        CommentsPO commentsPO = new CommentsPO(driver);
        String timeNow = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(Calendar.getInstance().getTime());
        commentsPO.getCommentsInputbox().setData(timeNow);
//        commentsPO.getCommentButton().click();
//        try {
//            Thread.sleep(15000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        commentsPO.clickCommentButton(); //the wait is implemented here
        commentsPO.refreshPage();
        String actualResult = commentsPO.getLastCommentText();
        Assert.assertEquals(timeNow, actualResult);

        System.out.println("Sign out");
        HeaderSignedInComponent = new HeaderSignedInComponent(driver);
        HeaderSignedInComponent.signOut();

        System.out.println("Go to Eco News, open the first news card");

        HeaderAnonymousComponent HeaderAnonymousComponent = new HeaderAnonymousComponent(driver);
        HeaderAnonymousComponent.getNews().click();

        newsListPO.getFirstNewsCard().getClickableArea().click();
        actualResult = commentsPO.getLastCommentText();
        Assert.assertEquals(timeNow, actualResult);
    }
}
