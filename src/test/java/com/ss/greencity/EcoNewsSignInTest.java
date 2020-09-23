package com.ss.greencity;

import com.ss.greencity.pageobjects.ForgetPasswordPO;
import com.ss.greencity.pageobjects.ProfilePO;
import com.ss.greencity.pageobjects.SignInPO;
import org.junit.Assert;
import org.junit.Test;



import java.util.concurrent.TimeUnit;

public class EcoNewsSignInTest extends EcoNewsTestRunner {
    /**
     * Signing in user with invalid email
     */
    @Test
    public void signInEmailTest() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SignInPO signInPO = new SignInPO(driver);
        String actualResult = signInPO
                .clickSignInButton()
                .setEmail("em5.com")
                .alertEmailMessage();

        Assert.assertEquals("Please check that your e-mail address is indicated correctly", actualResult);
    }

    /**
     * Signing in user with password that contains less then 8 characters
     */
    @Test
    public void signInPasswordTest() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SignInPO signInPO = new SignInPO(driver);
        String actualResult = signInPO
                .clickSignInButton()
                .setEmail("user1@selenium.test")
                .setPassword("11111")
                .alertPasswordMessage();
        Assert.assertEquals("Password must be at least 8 characters long", actualResult);
    }



    /**
     * Sign in with empty email field
     */
   @Test
    public void signInEmptyEmailTest() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SignInPO signInPO = new SignInPO(driver);
        String actualResult = signInPO
                .clickSignInButton()
                .setEmail("")
                .PasswordClick()
                .alertEmptyEmailMessage();
        Assert.assertEquals("Email is required", actualResult);
    }

    /**
     * Sign in with empty password field
     */
    @Test
    public void signInEmptyPasswordTest() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SignInPO signInPO = new SignInPO(driver);
        String actualResult = signInPO
                .clickSignInButton()
                .setEmail("user123@selenium.test")
                .setPassword("")
                .alertEmptyPasswordMessage();
        Assert.assertEquals("Password is required", actualResult);
    }

    /**
     * Sign in with incorrect email
     */
    @Test
    public  void  signInIncorrectEmailTest() {
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        SignInPO signInPO = new SignInPO(driver);
        String actualResult = signInPO
                .clickSignInButton()
                .setEmail("email@in.com")
                .setPassword("12345678")
                .clickSignInUserButton()
                .alertBadEmailOrPasswordMessage();
        Assert.assertEquals("Bad email or password", actualResult);
    }

    /**
     * Sign in with incorrect password
     */
    @Test
    public  void  signInIncorrectPasswordTest() {
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        SignInPO signInPO = new SignInPO(driver);
        String actualResult = signInPO
                .clickSignInButton()
                .setEmail("aliejua@gmail.com")
                .setPassword("12345678")
                .clickSignInUserButton()
                .alertBadEmailOrPasswordMessage();
        Assert.assertEquals("Bad email or password", actualResult);
    }

/**
 * Signing in user with valid data
 */
   @Test
    public void signInValidDataTest() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SignInPO signInPO = new SignInPO(driver);
       ProfilePO profilePO = new ProfilePO(driver);
                 signInPO
                .clickSignInButton()
                .setEmail("aliejua@gmail.com")
                .setPassword("Aa12345_")
                .clickSignInUserButton();
       String actualResult = profilePO.userNameField();


        Assert.assertEquals("User123", actualResult);
    }

    /**
     * Signing in user with valid data
     */
    @Test
    public void forgotPasswordLinkTest() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SignInPO signInPO = new SignInPO(driver);
        ForgetPasswordPO forgetPasswordPO = new ForgetPasswordPO(driver);
        signInPO
                .clickSignInButton()
                .clickForgotPassword();
        String actualResult = forgetPasswordPO.forgotPasswordText();


        Assert.assertEquals("Problems sign in?", actualResult);
    }



}


