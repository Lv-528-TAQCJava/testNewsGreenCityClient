package com.ss.greencity;

import com.ss.greencity.pageobjects.*;
import org.junit.Assert;
import org.junit.Test;

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
        HeaderSignedInComponent headerSignedInPO = new HeaderSignedInComponent(driver);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        headerSignedInPO.getNews().click();
        EcoNewsListPO newsListPO = new EcoNewsListPO(driver);
        newsListPO.getFirstNewsCard().getClickableArea().click();

        System.out.println("Add a new comment");
        CommentsPO commentsPO = new CommentsPO(driver);
        String timeNow = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(Calendar.getInstance().getTime());
        commentsPO.getCommentsInputbox().setData(timeNow);
        commentsPO.getCommentButton().click();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        commentsPO.refreshPage();
        String actualResult = commentsPO.getLastCommentText();
        Assert.assertEquals(timeNow, actualResult);

        System.out.println("Sign out");
        headerSignedInPO = new HeaderSignedInComponent(driver);
        headerSignedInPO.signOut();

        System.out.println("Go to Eco News, open the first news card");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HeaderAnonymousComponent headerAnonymousPO = new HeaderAnonymousComponent(driver);
        headerAnonymousPO.getNews().click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        newsListPO.getFirstNewsCard().getClickableArea().click();
        actualResult = commentsPO.getLastCommentText();
        Assert.assertEquals(timeNow, actualResult);
    }
}
