package com.ss.greencity.pageobjects;

import com.ss.greencity.locators.FooterLocators;
import com.ss.greencity.pageelements.Label;
import com.ss.greencity.pageelements.Link;
import org.openqa.selenium.WebDriver;

public class FooterPO extends BasePageObject {

    public Link getHome() {
        return home;
    }

    public Link getEconews() {
        return econews;
    }

    public Link getTips() {
        return tips;
    }

    public Link getPlaces() {
        return places;
    }

    public Link getAbout() {
        return about;
    }

    public Label getFollowUs() {
        return followUs;
    }

    public Link getProfile() {
        return profile;
    }

    protected Link home;
    protected Link econews;
    protected Link tips;
    protected Link places;
    protected Link about;
    protected Link profile;
    protected Label followUs;


    public FooterPO(WebDriver driver) {
        super(driver);
        init();
    }

    protected void init() {
        home = new Link(driver.findElement(FooterLocators.LOGO.getPath()));
        econews = new Link(driver.findElement(FooterLocators.ECO_NEWS.getPath()));
        tips = new Link(driver.findElement(FooterLocators.TIPS.getPath()));
        places = new Link(driver.findElement(FooterLocators.PLACES.getPath()));
        about = new Link(driver.findElement(FooterLocators.ABOUT.getPath()));
        profile = new Link(driver.findElement(FooterLocators.PROFILE.getPath()));
        followUs = new Label(driver.findElement(FooterLocators.FOLLOW_US.getPath()));
    }
}
