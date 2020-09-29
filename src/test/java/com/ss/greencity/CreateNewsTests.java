package com.ss.greencity;

import com.ss.greencity.pageobjects.*;
import org.junit.*;
import org.openqa.selenium.NoSuchElementException;

public class CreateNewsTests extends EcoNewsTestRunner {

    CreateNewsPO createNewsPO = new CreateNewsPO(driver);
    PreviewNews previewNews = new PreviewNews(driver);
    EcoNewsPO ecoNewsPO = new EcoNewsPO(driver);
    SignInPO signInPO = new SignInPO(driver);

    @Before
    public void setUpTest(){
        signIn();
        ecoNewsPO.clickEcoNewsButton().clickCreateNewsButton();
    }

    @After
    public void tearDownTest(){
        createNewsPO.getHeaderSignedIn(driver).signOut();
    }

    @Test
    public void sourceFieldValidLinkTest(){
        createNewsPO.setSource("http://")
                .setContent("1");
        boolean isDisplayedSourceWarning;
        try {
            createNewsPO.getSourceWarning();
            isDisplayedSourceWarning = true;
        } catch (NoSuchElementException e) {
            isDisplayedSourceWarning = false;
        }
        Assert.assertFalse(isDisplayedSourceWarning);
    }
    @Test
    public void sourceFieldInvalidLinkTest(){
        createNewsPO.setSource("htlm")
                .setContent("1");
        boolean isDisplayedSourceWarning;
        try {
            createNewsPO.getSourceWarning();
            isDisplayedSourceWarning = true;
        } catch (NoSuchElementException e) {
            isDisplayedSourceWarning = false;
        }
        Assert.assertTrue(isDisplayedSourceWarning);
    }
    @Test
    public void contentFieldInvalidDataTest(){
        createNewsPO.setContent("Less then 20")
                .clickNewsTagButton();
        boolean isDisplayedContentsWarning;
        try {
            createNewsPO.getContentWarning();
            isDisplayedContentsWarning = true;
        } catch (NoSuchElementException e) {
            isDisplayedContentsWarning = false;
        }
        Assert.assertTrue(isDisplayedContentsWarning);
    }
    @Test
    public void contentFieldValidDataTest(){
        createNewsPO.setContent("More then 20 symbolsssssssss")
                .clickNewsTagButton();
        boolean isDisplayedContentsWarning;
        try {
            createNewsPO.getContentWarning();
            isDisplayedContentsWarning = true;
        } catch (NoSuchElementException e) {
            isDisplayedContentsWarning = false;
        }
        Assert.assertFalse(isDisplayedContentsWarning);
    }
    @Test
    public void moreThan3TagsTest(){
                createNewsPO.clickNewsTagButton()
                .clickEventTagButton()
                .clickEducationTagButton()
                .clickInitiativeTagButton();
        boolean isDisplayedTagsWarning;
        try {
            createNewsPO.getTagsWarning();
            isDisplayedTagsWarning = true;
        } catch (NoSuchElementException e) {
            isDisplayedTagsWarning = false;
        }
        Assert.assertTrue(isDisplayedTagsWarning);
    }
    @Test
    public void lessThan3TagsTest(){
        createNewsPO.clickNewsTagButton()
                .clickEventTagButton();
        boolean isDisplayedTagsWarning;
        try {
            createNewsPO.getTagsWarning();
            isDisplayedTagsWarning = true;
        } catch (NoSuchElementException e) {
            isDisplayedTagsWarning = false;
        }
        Assert.assertFalse(isDisplayedTagsWarning);
    }
    @Test
    public void publishButtonEnableTest(){
        createNewsPO.setTitle("Title")
                .clickNewsTagButton()
                .setContent("Valid: more than 20 symbols");
        Assert.assertTrue(createNewsPO.isEnablePublishButton());
    }
    @Test
    public void publishButtonDisableTest(){
        Assert.assertFalse(createNewsPO.isEnablePublishButton());
    }
    @Test
    public void ContinueButtonTest(){
        String createNewsUrl = driver.getCurrentUrl();
        createNewsPO.clickCancelButton()
                .clickContinueEditing();
        Assert.assertEquals(createNewsUrl,driver.getCurrentUrl());
    }

    @Test
    public void YesCancelButtonTest(){
        createNewsPO.clickCancelButton()
                    .clickYesCancelButton();
        Assert.assertEquals("https://ita-social-projects.github.io/GreenCityClient/#/news",driver.getCurrentUrl() );
    }
    @Test
    public void previewTitleTest(){
       // String titleText = createNewsPO.setTitle("Title").getTitleText();
       // String previewTitleText = createNewsPO.goToPreviewNewsPage().getTitleLabel().getText();
       // Assert.assertEquals(titleText,previewTitleText);
        Assert.assertEquals(createNewsPO.setTitle("Title").getTitleText(), createNewsPO.goToPreviewNewsPage().getTitleLabel().getText());
    }
    @Test
    public void previewContentTest(){
        String contentText = createNewsPO.setContent("Content field: more than 20 symbols").getContentText().trim();
        String previewContentText = createNewsPO.goToPreviewNewsPage().getContentLabel().getText().trim();
        Assert.assertEquals(contentText, previewContentText);
    }
    @Test
    public void previewSourceTextTest(){
        String sourceText = createNewsPO.setSource("http://google.com").getSourceText();
        createNewsPO.goToPreviewNewsPage();
        String previewSourceText = previewNews.getSourceLabel().getText();
        Assert.assertEquals(sourceText,previewSourceText);
    }
    @Test
    public void previewBackToEditingLinkTest(){
        String createNewsUrl = driver.getCurrentUrl();
        createNewsPO.goToPreviewNewsPage()
                .clickBackToEditingLink();
        Assert.assertEquals(createNewsUrl, driver.getCurrentUrl());
    }
    @Test
    public void previewBackToEditingSaveChangesTest() {
        createNewsPO.setTitle("Title")
                .clickNewsTagButton().clickEducationTagButton().clickInitiativeTagButton()
                .setSource("http://google.com")
                .setContent("Valid: more than 20 symbols")
                .goToPreviewNewsPage()
                .clickBackToEditingLink();
        Assert.assertEquals("Title", createNewsPO.getTitleText());
        Assert.assertEquals("http://google.com", createNewsPO.getSourceText());
        Assert.assertEquals("Valid: more than 20 symbols", createNewsPO.getContentText());
    }
    @Test
    public void previewBackToEditingByBrowserBackButtonSaveChangesTest() {
        createNewsPO.setTitle("Title")
                .clickNewsTagButton().clickEducationTagButton().clickInitiativeTagButton()
                .setSource("http://google.com")
                .setContent("Valid: more than 20 symbols")
                .goToPreviewNewsPage();
        driver.navigate().back();
        Assert.assertEquals("Title", createNewsPO.getTitleText());
        Assert.assertEquals("http://google.com", createNewsPO.getSourceText());
        Assert.assertEquals("Valid: more than 20 symbols", createNewsPO.getContentText());
    }
    @Test
    public void isPreviewPublishBtnPresentWithValidDataTest() {
        createNewsPO.setTitle("Title")
                .clickNewsTagButton().clickEducationTagButton().clickInitiativeTagButton()
                .setSource("http://google.com")
                .setContent("Valid: more than 20 symbols")
                .goToPreviewNewsPage();
        boolean isPublishButtonPresent;
        try {
            previewNews.getPublishButton();
            isPublishButtonPresent = true;
        } catch (NoSuchElementException e) {
            isPublishButtonPresent = false;
        }
        Assert.assertTrue(isPublishButtonPresent);
    }
    @Test
    public void isPreviewPublishBtnPresentWithInValidDataTest() {
        createNewsPO.setTitle("Title")
                .clickNewsTagButton().clickEducationTagButton().clickInitiativeTagButton()
                .setSource("http://google.com")
                .setContent("Invalid")
                .goToPreviewNewsPage();
        boolean isPublishButtonPresent;
        try {
            previewNews.getPublishButton();
            isPublishButtonPresent = true;
        } catch (NoSuchElementException e) {
            isPublishButtonPresent = false;
        }
        Assert.assertFalse(isPublishButtonPresent);
    }
    @Test
    public void previewDateTest(){
        String createNewsDate = createNewsPO.getDateText();
        createNewsPO.goToPreviewNewsPage();
        String previewDate = previewNews.getDateLabel().getText();
        Assert.assertEquals(createNewsDate, previewDate);
    }
    @Test
    public void previewAuthorTest(){
        String createNewsAuthor = "by " + createNewsPO.getAuthorText();
        createNewsPO.goToPreviewNewsPage();
        String previewAuthor = previewNews.getAuthorLabel().getText();
        Assert.assertEquals(createNewsAuthor,previewAuthor);
    }
    @Test
    public void previewTagsPresentTest(){
        createNewsPO.clickEducationTagButton()
                .goToPreviewNewsPage();
        boolean isDisplayedEducationTag;
        try {
            previewNews.getEducationTag();
            isDisplayedEducationTag = true;
        } catch (NoSuchElementException e) {
            isDisplayedEducationTag = false;
        }
        Assert.assertTrue(isDisplayedEducationTag);
    }
    @Test
    public void pictureLinkPresentAfterPreviewTest(){
        createNewsPO.goToPreviewNewsPage().clickBackToEditingLink();
        boolean isDisplayedPictureUploadLink;
        try {
            createNewsPO.getPictureUploadLink();
            isDisplayedPictureUploadLink = true;
        } catch (NoSuchElementException e) {
            isDisplayedPictureUploadLink = false;
        }
        Assert.assertTrue(isDisplayedPictureUploadLink); //Bug
    }

    public void signIn(){
        signInPO.clickSignInButton();
        signInPO.setEmail("denys.skurskyi@gmail.com")
                .setPassword("AaBb_123")
                .clickSignInUserButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }

}
