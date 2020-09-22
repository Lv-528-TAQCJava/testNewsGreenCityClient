package com.ss.greencity;

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
}

    /**
     * Signing up user with password that contains less then 8 characters
     */
   /* @Test
    public void signInPasswordTest() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SignUpPO signUpPO = new SignUpPO(driver);
        String actualResult = signUpPO
                .clickSignUpButton()
                .setEmail("user1@selenium.test")
                .setUserName("User1029")
                .setPassword("11111")
                .alertPasswordMessage();
        Assert.assertEquals("Password must be at least 8 characters in length", actualResult);
    }

    /**
     * Signing in user with valid data
     */
 /*   @Test
    public void signUpValidDataTest() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SignUpPO signUpPO = new SignUpPO(driver);
        String actualResult = signUpPO
                .clickSignUpButton()
                .setEmail("user" + Math.random() * 100000 + "@selenium.test")
                .setUserName("User1029")
                .setPassword("Aa123456_")
                .setConfirmedPassword("Aa123456_")
                .clickSignUpUserButton()
                .signedUpMessage();
        Assert.assertEquals("Welcome back!", actualResult);
    }

    /**
     * Sign up with empty email field
     */
  /*  @Test
    public void signUpEmptyEmailTest() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SignUpPO signUpPO = new SignUpPO(driver);
        String actualResult = signUpPO
                .clickSignUpButton()
                .setEmail("")
                .alertEmptyEmailMessage();
        Assert.assertEquals("Email is required", actualResult);
    }

    /**
     * Sign up with empty password field
     */
  /*  @Test
    public void signUpEmptyPasswordTest() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SignUpPO signUpPO = new SignUpPO(driver);
        String actualResult = signUpPO
                .clickSignUpButton()
                .setEmail("user" + Math.random() * 100000 + "@selenium.test")
                .setUserName("User1029")
                .setPassword("")
                .alertEmptyPasswordMessage();
        Assert.assertEquals("Password is required", actualResult);
    }
}

/**
 * Sign up with empty confirm password field
 *
 * @Test
 * public void signUpEmptyConfirmPasswordTest() {
 * driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
 * SignUpPO signUpPO = new SignUpPO(driver);
 * String actualResult = signUpPO
 * .clickSignUpButton()
 * .setEmail("user"+Math.random()*100000+"@selenium.test")
 * .setUserName("User"+Math.random()*100000)
 * .setPassword("Aa123456_")
 * .setConfirmedPassword("")
 * .alertEmptyPasswordMessage();
 * Assert.assertEquals("Password is required",actualResult)
 * }
 */
