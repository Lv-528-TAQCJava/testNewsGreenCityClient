package com.ss.greencity;

import com.ss.greencity.pageobjects.*;
import com.ss.greencity.util.GoogleWindowSwitch;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.Set;
import java.util.concurrent.TimeUnit;

public class EcoNewsSignInTest extends EcoNewsTestRunner {

    SignInPO signInPO = new SignInPO(driver);
    ProfilePO profilePO = new ProfilePO(driver);
    ForgetPasswordPO forgetPasswordPO = new ForgetPasswordPO(driver);
    GoogleSignInPO googleSignInPO = new GoogleSignInPO(driver);




    public void logOut(){
        WebElement userHeaderButton = driver.findElement(By.cssSelector("div#user-avatar-wrapper ul"));
        WebElement logOutButton = driver.findElement(By.xpath("//*[@id = 'user-avatar-wrapper']//a[contains(text(), ' Sign out ')]"));
        userHeaderButton.click();
        logOutButton.click();
    }

    /**
     * Signing in user with invalid email
     */
    @Test
    public void signInEmailTest() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
        String actualResult = signInPO
                .clickSignInButton()
                .setEmail("")
                .clickImagePanel()
                .alertEmptyEmailMessage();
        Assert.assertEquals("Email is required", actualResult);
    }

    /**
     * Sign in with empty password field
     */
    @Test
    public void signInEmptyPasswordTest() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String actualResult = signInPO
                .clickSignInButton()
                .setEmail("user123@selenium.test")
                .setPassword("")
                .clickImagePanel()
                .alertEmptyPasswordMessage();
        Assert.assertEquals("Password is required", actualResult);
    }

    /**
     * Sign in with incorrect email
     */
    @Test
    public  void  signInIncorrectEmailTest() {
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
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
                 signInPO
                .clickSignInButton()
                .setEmail("aliejua@gmail.com")
                .setPassword("Aa12345_")
                .clickSignInUserButton();
       String actualResult = profilePO.userNameField();
       logOut();
      // HeaderSignedInComponent.signOut();


       Assert.assertEquals("User123", actualResult);
    }

    /**
     * Clicking Forgot Password
     */
    @Test
    public void forgotPasswordLinkTest() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        signInPO
                .clickSignInButton()
                .clickForgotPassword();
        String actualResult = forgetPasswordPO.getforgotPasswordTitle();


        Assert.assertEquals("Problems sign in?", actualResult);
    }
    /**
     * Signing in user with google id
     */
    @Test
    public void signInGoogleIdTest()  {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        signInPO.clickSignInButton();
        String originalWindow = driver.getWindowHandle();
        final Set<String> oldWindowsSet = driver.getWindowHandles();
        signInPO.clickGoogleSignInButton();
        String newWindow = GoogleWindowSwitch.WindowsHandling(oldWindowsSet, driver);
        driver.switchTo().window(newWindow);
        googleSignInPO
                .setEmail_Phone("LelekaTestAcc@gmail.com")
                .clickEmailNextBTN()
                .setPassword("Test1234_")
                .clickPasswordNextBTN();
        driver.switchTo().window(originalWindow);
        String actualResult = profilePO.userNameField();
        Assert.assertEquals("Prosto Leleka", actualResult);
        logOut();
    }
}


