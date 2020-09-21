package com.ss.greencity;

import com.ss.greencity.pageobjects.SignUpPO;
import org.junit.Assert;
import org.junit.Test;



import java.util.concurrent.TimeUnit;

public class SignUPTest extends EcoNewsTestRunner{
    /**
     * Signing up user with invalid email
     */
    @Test
    public void signUpEmailTest() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SignUpPO signUpPO = new SignUpPO(driver);
        String actualResult = signUpPO
                .clickSignUpButton()
                .setEmail("rg3.gg5")
                .alertEmailMessage();

        Assert.assertEquals("Please check that your e-mail address is indicated correctly",actualResult);
    }
    /**
     * Signing up user with invalid Username
     */
    @Test
    public void signUpUsernameTest() {
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        SignUpPO signUpPO = new SignUpPO(driver);
        String actualResult = signUpPO
                .clickSignUpButton()
                .setEmail("user1@selenium.test")
                .setUserName("user1")
                .alertUserNameMessage();
        Assert.assertEquals("The name must contain 6-30 characters and can contain letters(a-z), numbers(0-9) and a dot(.)",actualResult);
    }
    /**
     * Signing up user with invalid password that contains space
     */
    @Test
    public void signUpPasswordWithSpaceTest() {
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        SignUpPO signUpPO = new SignUpPO(driver);
        String actualResult = signUpPO
                .clickSignUpButton()
                .setEmail("user1@selenium.test")
                .setUserName("User1029")
                .setPassword(" ")
                .alertPasswordMessage();
        Assert.assertEquals( "Password must be at least 8 characters long without spaces",actualResult);
    }
    /**
     * Signing up user with password that contains less then 8 characters
     */
    @Test
    public void signUpPasswordTest() {
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
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
     * Signing up user with invalid confirm password
     */
    @Test
    public void signUpConfirmPasswordTest() {
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        SignUpPO signUpPO = new SignUpPO(driver);
        String actualResult = signUpPO
                .clickSignUpButton()
                .setEmail("user1@selenium.test")
                .setUserName("User1029")
                .setPassword("Aa123456_")
                .setConfirmedPassword("Aa123456")
                .alertConfirmPasswordMessage();
        Assert.assertEquals("Passwords do not match", actualResult);
    }
    /**
     * Signing up user with valid data
     */
    @Test
    public void signUpValidDataTest() {
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        SignUpPO signUpPO = new SignUpPO(driver);
        String actualResult = signUpPO
                .clickSignUpButton()
                .setEmail("user"+Math.random()*100000+"@selenium.test")
                .setUserName("User1029")
                .setPassword("Aa123456_")
                .setConfirmedPassword("Aa123456_")
                .clickSignUpUserButton()
                .signedUpMessage();
        Assert.assertEquals("Welcome back!",actualResult);
    }

    /**
     * Sign up with empty email field
     */
    @Test
    public void signUpEmptyEmailTest() {
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        SignUpPO signUpPO = new SignUpPO(driver);
        String actualResult = signUpPO
                .clickSignUpButton()
                .setEmail("")
                .alertEmptyEmailMessage();
        Assert.assertEquals("Email is required",actualResult);
    }

    /**
     * Sign up with empty username field
     */
    @Test
    public void signUpEmptyUsernameTest() {
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        SignUpPO signUpPO = new SignUpPO(driver);
        String actualResult = signUpPO
                .clickSignUpButton()
                .setEmail("user"+Math.random()*100000+"@selenium.test")
                .setUserName("")
                .alertEmptyUsernameMessage();
        Assert.assertEquals("User name is required",actualResult);
    }

    /**
     * Sign up with empty password field
     */
    @Test
    public void signUpEmptyPasswordTest() {
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        SignUpPO signUpPO = new SignUpPO(driver);
        String actualResult = signUpPO
                .clickSignUpButton()
                .setEmail("user"+Math.random()*100000+"@selenium.test")
                .setUserName("User1029")
                .setPassword("")
                .alertEmptyPasswordMessage();
        Assert.assertEquals("Password is required",actualResult);
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
}
