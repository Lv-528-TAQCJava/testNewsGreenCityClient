package com.ss.greencity.pageobjects;

import com.ss.greencity.locators.FooterLocators;
import com.ss.greencity.pageelements.Link;
import org.openqa.selenium.WebDriver;

public class SignedOutFooterPO extends FooterPO {
    public Link getProfile() {
        return profile;
    }

    protected Link profile;

    public SignedOutFooterPO(WebDriver driver) {
        super(driver);
        init();
    }

    protected  void  init() {
        super.init();
        profile = new Link(driver.findElement(FooterLocators.PROFILE.getPath()));
    }

}
