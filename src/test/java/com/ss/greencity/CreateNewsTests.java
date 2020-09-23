package com.ss.greencity;

import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageobjects.CreateNewsPO;
import com.ss.greencity.pageobjects.EcoNewsPO;
import com.ss.greencity.pageobjects.HeaderPO;
import com.ss.greencity.pageobjects.SignInPO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CreateNewsTests extends EcoNewsTestRunner {
    CreateNewsPO createNewsPO = new CreateNewsPO(driver);
    EcoNewsPO ecoNewsPO = new EcoNewsPO(driver);
    SignInPO signInPO = new SignInPO(driver);

    @Before
    public void signInWithCorrectData(){

        signInPO.clickSignInButton();
        signInPO.setEmail("denys.skurskyi@gmail.com")
                .setPassword("AaBb_123")
                .clickSignInUserButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ecoNewsPO.clickEcoNewsButton();
        ecoNewsPO.clickCreateNewsButton();
    }

    @Test
    public void sourceFieldValidLinkTest(){
        createNewsPO.setSourceField("htlm");
        createNewsPO.setContentField("1");
        createNewsPO.getSourceWarning();
        Assert.assertEquals(true, createNewsPO.isSourceWarningPresent());
    }
    @Test
    public void sourceFieldInvalidLinkTest(){
        createNewsPO.setSourceField("http://")
                .setContentField("1")
                .getSourceWarning();
        Assert.assertEquals(false, createNewsPO.isSourceWarningPresent());
    }
    @Test
    public void contentFieldInvalidDataTest(){
        createNewsPO.setContentField("Less then 20");
        Assert.assertEquals(true, createNewsPO.isContentWarningPresent());
    }
    @Test
    public void contentFieldValidDataTest(){
        createNewsPO.setContentField("Valid: more than 20 symbols");
        Assert.assertEquals(false, createNewsPO.isContentWarningPresent());
    }
    @Test
    public void moreThan3TagsTest(){
        createNewsPO.clickNewsButton()
                .clickEventsButton()
                .clickEducationButton()
                .clickInitiativeButton();
        Assert.assertEquals(true, createNewsPO.isTagsWarningPresent());
    }
    @Test
    public void lessThan3TagsTest(){
        createNewsPO.clickNewsButton()
                .clickEventsButton();
        Assert.assertEquals(false, createNewsPO.isTagsWarningPresent());
    }
    @Test
    public void publishButtonEnableTest(){
        createNewsPO.setTitleField("title")
                .clickNewsButton()
                .setContentField("Valid: more than 20 symbols");
        Assert.assertEquals(true, createNewsPO.isPublishButtonEnable());
    }
    @Test
    public void publishButtonDisableTest(){
        Assert.assertEquals(false, createNewsPO.isPublishButtonEnable());
    }

}
