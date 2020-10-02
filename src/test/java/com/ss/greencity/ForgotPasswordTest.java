package com.ss.greencity;

import com.ss.greencity.pageobjects.ForgetPasswordPO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class ForgotPasswordTest extends EcoNewsTestRunner {

    ForgetPasswordPO forgetPasswordPO = new ForgetPasswordPO(driver);

    @Before
    public void setUpTest(){
        forgetPasswordPO.getSignInPO().clickSignInButton().clickForgotPassword();
    }

    /**
     * Submit invalid email
     */
    @Test
    public void invalidEmailTest() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String actualResult = forgetPasswordPO
                .setEmail("em5.com")
                .getEmailAlertMessage();

        Assert.assertEquals("Please check that your e-mail address is indicated correctly", actualResult);
    }
    /**
     * Submit empty email field
     */
    @Test
    public void EmptyEmailTest() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String actualResult = forgetPasswordPO
                .setEmail("")
                .clickImagePanel()
                .getEmailAlertMessage();

        Assert.assertEquals("Email is required", actualResult);
    }

    /**
     * Submit with not existing email
     */
    @Test
    public void emailDoesNotExistTest() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String actualResult = forgetPasswordPO
                .setEmail("incTest@test.com")
                .clickSubmitLoginBTN()
                .getEmailAlertMessage();

        Assert.assertEquals("The user does not exist by this email: incTest@test.com", actualResult);
    }

    /**
     * Click on "Back to SignIn" link
     */
    @Test
    public void backToSignInTest() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String actualResult = forgetPasswordPO
                .clickBackToSignInLink()
                .getSignInPO()
                .getSignInTitle();

        Assert.assertEquals("Welcome back!", actualResult);
    }

}
