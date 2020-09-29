package com.ss.greencity;

import com.ss.greencity.data.LocaleRepository;
import com.ss.greencity.data.LocaleTexts;
import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageobjects.EcoNewsListPO;
import com.ss.greencity.pageobjects.FooterPO;
import com.ss.greencity.pageobjects.HeaderAnonymousPO;
import com.ss.greencity.util.Languages;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.assertj.core.api.SoftAssertions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

import static org.junit.Assert.*;

public class LanguageChangeTest extends EcoNewsTestRunner {

    private SoftAssertions softAssertions;

    private void setAssertions(HeaderAnonymousPO header, EcoNewsListPO news, FooterPO footer,
                               HashMap<LocaleTexts, String> locale) {
        List<Button> filters = news.getFilters();
        softAssertions.assertThat(header.getNews().getText()).isEqualTo(locale.get(LocaleTexts.ECO_NEWS));
        softAssertions.assertThat(header.getTips().getText()).isEqualTo(locale.get(LocaleTexts.ECO_ADVICE));
        softAssertions.assertThat(header.getPlaces().getText()).isEqualTo(locale.get(LocaleTexts.ECO_MAP));
        softAssertions.assertThat(header.getAbout().getText()).isEqualTo(locale.get(LocaleTexts.ABOUT_US));
        softAssertions.assertThat(header.getHabits().getText()).isEqualTo(locale.get(LocaleTexts.MY_PROFILE));
        softAssertions.assertThat(header.getSignIn().getText()).isEqualTo(locale.get(LocaleTexts.SIGN_IN));
        softAssertions.assertThat(header.getSignUp().getText()).isEqualTo(locale.get(LocaleTexts.SIGN_UP));

        softAssertions.assertThat(news.getEcoNewsHeader().getText()).isEqualTo(locale.get(LocaleTexts.MAIN_HEADER));
        softAssertions.assertThat(news.getFilterBy().getText()).isEqualTo(locale.get(LocaleTexts.FILTER_BY));
        softAssertions.assertThat(filters.get(0).getText()).isEqualTo(locale.get(LocaleTexts.ADS));
        softAssertions.assertThat(filters.get(1).getText()).isEqualTo(locale.get(LocaleTexts.EVENTS));
        softAssertions.assertThat(filters.get(2).getText()).isEqualTo(locale.get(LocaleTexts.NEWS));
        softAssertions.assertThat(filters.get(3).getText()).isEqualTo(locale.get(LocaleTexts.EDUCATION));
        softAssertions.assertThat(filters.get(4).getText()).isEqualTo(locale.get(LocaleTexts.INITIATIVES));
        softAssertions.assertThat(filters.get(5).getText()).isEqualTo(locale.get(LocaleTexts.LIFEHACKS));

        softAssertions.assertThat(footer.getEconews().getText()).isEqualTo(locale.get(LocaleTexts.ECO_NEWS));
        softAssertions.assertThat(footer.getTips().getText()).isEqualTo(locale.get(LocaleTexts.ECO_ADVICE));
        softAssertions.assertThat(footer.getPlaces().getText()).isEqualTo(locale.get(LocaleTexts.ECO_MAP));
        softAssertions.assertThat(footer.getAbout().getText()).isEqualTo(locale.get(LocaleTexts.ABOUT_US));
        softAssertions.assertThat(footer.getProfile().getText()).isEqualTo(locale.get(LocaleTexts.MY_PROFILE));
        softAssertions.assertThat(footer.getFollowUs().getText()).isEqualTo(locale.get(LocaleTexts.FOLLOW_US));

    }

    @Before
    public void setUp() {
        super.setUp();
        softAssertions = new SoftAssertions();
    }

    @Test
    public void switchToUkranianTest() {
        HeaderAnonymousPO header = new HeaderAnonymousPO(driver);
        header.selectLanguage(Languages.UKRAINIAN);
        HeaderAnonymousPO translatedHeader = new HeaderAnonymousPO(driver);
        EcoNewsListPO news = new EcoNewsListPO(driver);
        FooterPO footer = new FooterPO(driver);
        HashMap<LocaleTexts, String> locale = LocaleRepository.getUaLabels();
        setAssertions(translatedHeader, news, footer, locale);
    }

    @Test
    public void switchToRussianTest() {
        HeaderAnonymousPO header = new HeaderAnonymousPO(driver);
        header.selectLanguage(Languages.RUSSIAN);

        HeaderAnonymousPO translatedHeader = new HeaderAnonymousPO(driver);
        EcoNewsListPO news = new EcoNewsListPO(driver);
        FooterPO footer = new FooterPO(driver);
        HashMap<LocaleTexts, String> locale = LocaleRepository.getRuLabels();
        setAssertions(translatedHeader, news, footer, locale);

    }

    @Test
    public void switchToEnglishTest() {
        HeaderAnonymousPO header = new HeaderAnonymousPO(driver);
        header.selectLanguage(Languages.ENGLISH);
        HeaderAnonymousPO translatedHeader = new HeaderAnonymousPO(driver);
        EcoNewsListPO news = new EcoNewsListPO(driver);
        FooterPO footer = new FooterPO(driver);
        HashMap<LocaleTexts, String> locale = LocaleRepository.getEngLables();
        setAssertions(translatedHeader, news, footer, locale);
    }

    @After
    public void tearDown() {
        softAssertions.assertAll();
    }

}