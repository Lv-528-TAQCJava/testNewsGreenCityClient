package com.ss.greencity;

import com.ss.greencity.pageobjects.*;
import org.junit.*;

public class CreateNewsTests extends EcoNewsTestRunner {

    CreateNewsPO createNewsPO;
    PreviewNewsPO previewNews = new PreviewNewsPO(driver);
    SignInPO signInPO;
    HeaderSignedInComponent headerSignedInComponent;

    @Before
    public void setUpTest(){
        signInPO = new SignInPO(driver);
        signInPO.signIn("denys.skurskyi@gmail.com", "AaBb_123")
                .getHeaderSignedIn(driver)
                .goToEcoNewsPage()
                .goToCreateNewsPage();
    }

    @After
    public void tearDownTest(){
        headerSignedInComponent = new HeaderSignedInComponent(driver);
        headerSignedInComponent.signOut();
    }

    @Test
    public void sourceFieldValidLinkTest(){
        createNewsPO = new CreateNewsPO(driver);
        createNewsPO.setSource("http://")
                .setContent("1");
        Assert.assertNull(createNewsPO.getSourceWarning());
    }
    @Test
    public void sourceFieldInvalidLinkTest(){
        createNewsPO = new CreateNewsPO(driver);
        createNewsPO.setSource("htlm")
                .setContent("1");
        Assert.assertNotNull(createNewsPO.getSourceWarning());
    }
    @Test
    public void contentFieldInvalidDataTest(){
        createNewsPO = new CreateNewsPO(driver);
        createNewsPO.setContent("Less then 20").clickNewsTagButton();
        Assert.assertNotNull(createNewsPO.getContentWarning());
    }
    @Test
    public void contentFieldValidDataTest(){
        createNewsPO = new CreateNewsPO(driver);
        createNewsPO.setContent("More then 20 symbolsssssssss").clickNewsTagButton();
        Assert.assertNull(createNewsPO.getContentWarning());
    }
    @Test
    public void moreThan3TagsTest(){
        createNewsPO = new CreateNewsPO(driver);
                createNewsPO.clickNewsTagButton()
                .clickEventTagButton()
                .clickEducationTagButton()
                .clickInitiativeTagButton();
        Assert.assertNotNull(createNewsPO.getTagsWarning());
    }
    @Test
    public void lessThan3TagsTest(){
        createNewsPO = new CreateNewsPO(driver);
        createNewsPO.clickNewsTagButton()
                .clickEventTagButton();
        Assert.assertNull(createNewsPO.getTagsWarning());
    }
    @Test
    public void publishButtonEnableTest(){
        createNewsPO = new CreateNewsPO(driver);
        createNewsPO.setTitle("Title")
                .clickNewsTagButton()
                .setContent("Valid: more than 20 symbols");
        Assert.assertTrue(createNewsPO.getPublishButton().isEnable());
    }
    @Test
    public void publishButtonDisableTest(){
        createNewsPO = new CreateNewsPO(driver);
        Assert.assertFalse(createNewsPO.getPublishButton().isEnable());
    }
    @Test
    public void ContinueButton(){
        createNewsPO = new CreateNewsPO(driver);
        String createNewsUrl = createNewsPO.getUrl();
        String urlAfterClickContinueEditingButton = createNewsPO.clickCancelButton()
                    .clickContinueEditing().getUrl();
        Assert.assertEquals(createNewsUrl,urlAfterClickContinueEditingButton );
    }
    @Test
    public void YesCancelButtonTest(){
        createNewsPO = new CreateNewsPO(driver);
        String urlAfterClickYesCancelButton = createNewsPO.clickCancelButton()
                    .clickYesCancelButton().getUrl();
        Assert.assertEquals("https://ita-social-projects.github.io/GreenCityClient/#/news",urlAfterClickYesCancelButton );
    }
    @Test
    public void previewTitleTest(){
        createNewsPO = new CreateNewsPO(driver);
        String titleText = createNewsPO.setTitle("Title").getTitleText();
        String previewTitleText = createNewsPO.goToPreviewNewsPage().getTitleLabel().getText();
        Assert.assertEquals(titleText,previewTitleText);
    }
    @Test
    public void previewContentTest(){
        createNewsPO = new CreateNewsPO(driver);
        String contentText = createNewsPO.setContent("Content field: more than 20 symbols").getContentText().trim();
        createNewsPO.goToPreviewNewsPage();
        String previewContentText = previewNews.getContentLabel().getText().trim();
        Assert.assertEquals(contentText, previewContentText);
    }
    @Test
    public void previewSourceTextTest(){
        createNewsPO = new CreateNewsPO(driver);
        String sourceText = createNewsPO.setSource("http://google.com").getSourceText();
        createNewsPO.goToPreviewNewsPage();
        String previewSourceText = previewNews.getSourceLabel().getText();
        Assert.assertEquals(sourceText,previewSourceText);
    }
    @Test
    public void previewBackToEditingLinkTest(){
        createNewsPO = new CreateNewsPO(driver);
        String createNewsUrl = driver.getCurrentUrl();
        createNewsPO.goToPreviewNewsPage()
                .clickBackToEditingLink();
        Assert.assertEquals(createNewsUrl, driver.getCurrentUrl());
    }
    @Test
    public void previewBackToEditingSaveChangesTest() {
        createNewsPO = new CreateNewsPO(driver);
        createNewsPO.setTitle("Title")
                .clickNewsTagButton().clickEducationTagButton().clickInitiativeTagButton()
                .setSource("http://google.com")
                .setContent("Valid: more than 20 symbols")
                .goToPreviewNewsPage()
                .clickBackToEditingLink().getTitleText();
        createNewsPO = new CreateNewsPO(driver);
        Assert.assertEquals("Title", createNewsPO.getTitleText());
        Assert.assertEquals("http://google.com", createNewsPO.getSourceText());
        Assert.assertEquals("Valid: more than 20 symbols", createNewsPO.getContentText());
    }
    @Test
    public void previewBackToEditingByBrowserBackButtonSaveChangesTest() {
        createNewsPO = new CreateNewsPO(driver);
        createNewsPO.setTitle("Title")
                .clickNewsTagButton().clickEducationTagButton().clickInitiativeTagButton()
                .setSource("http://google.com")
                .setContent("Valid: more than 20 symbols")
                .goToPreviewNewsPage();
        driver.navigate().back();
        createNewsPO = new CreateNewsPO(driver);
        Assert.assertEquals("Title", createNewsPO.getTitleText());
    }
    @Test
    public void isPreviewPublishBtnPresentWithValidDataTest() {
        createNewsPO = new CreateNewsPO(driver);
        createNewsPO.setTitle("Title")
                .clickNewsTagButton().clickEducationTagButton().clickInitiativeTagButton()
                .setSource("http://google.com")
                .setContent("Valid: more than 20 symbols")
                .goToPreviewNewsPage();
        Assert.assertNotNull(previewNews.getPublishButton()); //Bug
    }
    @Test
    public void isPreviewPublishBtnPresentWithInvalidDataTest() {
        createNewsPO = new CreateNewsPO(driver);
        createNewsPO.setTitle("Title")
                .clickNewsTagButton().clickEducationTagButton().clickInitiativeTagButton()
                .setSource("http://google.com")
                .setContent("Invalid")
                .goToPreviewNewsPage();
        Assert.assertNull(previewNews.getPublishButton());
    }
    @Test
    public void previewDateTest(){
        createNewsPO = new CreateNewsPO(driver);
        String createNewsDate = createNewsPO.getDateText();
        createNewsPO.goToPreviewNewsPage();
        String previewDate = previewNews.getDateLabel().getText();
        Assert.assertEquals(createNewsDate, previewDate); // Think it's a bug
    }
    @Test
    public void previewAuthorTest(){
        createNewsPO = new CreateNewsPO(driver);
        String createNewsAuthor = "by " + createNewsPO.getAuthorText();
        createNewsPO.goToPreviewNewsPage();
        String previewAuthor = previewNews.getAuthorLabel().getText();
        Assert.assertEquals(createNewsAuthor,previewAuthor);
    }
    @Test
    public void previewTagsPresentTest(){
        createNewsPO = new CreateNewsPO(driver);
        createNewsPO.clickEducationTagButton()
                .goToPreviewNewsPage();
        Assert.assertNotNull(previewNews.getEducationTag());
    }
    @Test
    public void pictureLinkPresentAfterPreviewTest(){
        createNewsPO = new CreateNewsPO(driver);
        createNewsPO.goToPreviewNewsPage().clickBackToEditingLink();
        Assert.assertNotNull(createNewsPO.getPictureUploadLink()); //Bug
    }

}
