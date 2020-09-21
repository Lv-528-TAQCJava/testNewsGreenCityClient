package com.ss.greencity;

import com.ss.greencity.pageobjects.SignUpPO;
import org.junit.Assert;
import org.junit.Test;

public class SignUPTest extends EcoNewsTestRunner{
    /**
     * Signing up user with invalid email
     */
    @Test
    public void signUpEmailTest() {
        SignUpPO signUpPO = new SignUpPO(driver);
        String actualResult = signUpPO
                .clickSignUpButton()
                .setEmail("rg3.gg5")
                /*** .setUserName("vrtrtbr")
                * .setPassword("Aa123456_")
                * .setConfirmedPassword("Aa123456_")
                */
                .alertEmailMessage();

        Assert.assertEquals("Please check that your e-mail address is indicated correctly",actualResult);
    }
    /**
     * Signing up user with invalid Username
     */
    @Test
    public void signUpUsernameTest() {
        SignUpPO signUpPO = new SignUpPO(driver);
        String actualResult = signUpPO
                .clickSignUpButton()
                .setEmail("user1@selenium.test")
                .setUserName("user1")
                /**
                 * .setPassword("Aa123456_")
                 * .setConfirmedPassword("Aa123456_")
                 */
                .alertUserNameMessage();
        Assert.assertEquals("The name must contain 6-30 characters and can contain letters(a-z), numbers(0-9) and a dot(.)",actualResult);
    }
    /**
     * Signing up user with invalid password that contains space
     */
    @Test
    public void signUpPasswordWithSpaceTest() {
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
     *
    @Test
    public void signUpValidDataTest() {
        SignUpPO signUpPO = new SignUpPO(driver);
        String actualResult = signUpPO
                .clickSignUpButton()
                .setEmail("user1@selenium.test")
                .setUserName("User1029")
                .setPassword("Aa123456_")
                .setConfirmedPassword("Aa123456_")
                .clickSignUpUserButton()
                .signedUpMessage();
        Assert.assertEquals("Welcome",actualResult);


    }
    */

}
