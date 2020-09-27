package com.ss.greencity;

import com.ss.greencity.pageobjects.ForgetPasswordPO;
import com.ss.greencity.pageobjects.ProfilePO;
import com.ss.greencity.pageobjects.SignInPO;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Set;
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
     * Clicking Forgot Password
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
    /**
     * Signing in user with google id
     */
    @Test
    public void signInGoogleIdTest()  {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SignInPO signInPO = new SignInPO(driver);
        ProfilePO profilePO = new ProfilePO(driver);
        signInPO.clickSignInButton();
        String originalWindow = driver.getWindowHandle();
        final Set<String> oldWindowsSet = driver.getWindowHandles();
        signInPO.clickGoogleSignInButton();
        String newWindow = (new WebDriverWait(driver, 10))
                .until(new ExpectedCondition<String>() {
                           public String apply(WebDriver driver) {
                               Set<String> newWindowsSet = driver.getWindowHandles();
                               newWindowsSet.removeAll(oldWindowsSet);
                               return newWindowsSet.size() > 0 ?
                                       newWindowsSet.iterator().next() : null;
                           }
                       }
                );

        driver.switchTo().window(newWindow);
        WebElement email_phone = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
        email_phone.sendKeys("LelekaTestAcc@gmail.com");
        driver.findElement(By.id("identifierNext")).click();
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("Test1234_");
        driver.findElement(By.id("passwordNext")).click();

        driver.switchTo().window(originalWindow);
        String actualResult = profilePO.userNameField();

        Assert.assertEquals("Prosto Leleka", actualResult);
    }



}


