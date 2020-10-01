package com.ss.greencity;

import com.ss.greencity.pageobjects.*;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static com.ss.greencity.locators.CreateNewsLocators.PUBLISH_BUTTON;


public class CreateNewsTests extends EcoNewsTestRunner {

    CreateNewsPO createNewsPO = new CreateNewsPO(driver);
    PreviewNewsPO previewNews = new PreviewNewsPO(driver);
    EcoNewsArticlePO ecoNewsArticlePO = new EcoNewsArticlePO(driver);
    SignInPO signInPO = new SignInPO(driver);

    @Before
    public void setUpTest(){
        signInWithCorrectData();
        ecoNewsArticlePO.clickEcoNewsButton().clickCreateNewsButton();
    }
    @After
    public void tearDownTest(){
        logOut();
    }
    @Test
    public void sourceFieldValidLinkTest(){
        createNewsPO.setSource("http://")
                .setContent("1");
        Assert.assertFalse(isSourceWarningPresent());
    }
    @Test
    public void sourceFieldInvalidLinkTest(){
        createNewsPO.setSource("htlm")
                .setContent("1");
        Assert.assertTrue(isSourceWarningPresent());
    }
    @Test
    public void contentFieldInvalidDataTest(){
        createNewsPO.setContent("Less then 20").clickNewsTagButton();
        Assert.assertTrue(isContentWarningPresent());
    }
    @Test
    public void contentFieldValidDataTest(){
        createNewsPO.setContent("More then 20 symbolsssssssss").clickNewsTagButton();
        Assert.assertFalse(isContentWarningPresent());
    }
    @Test
    public void moreThan3TagsTest(){
                createNewsPO.clickNewsTagButton()
                .clickEventTagButton()
                .clickEducationTagButton()
                .clickInitiativeTagButton();
        Assert.assertTrue(isTagsWarningPresent());
    }
    @Test
    public void lessThan3TagsTest(){
        createNewsPO.clickNewsTagButton()
                .clickEventTagButton();
        Assert.assertFalse(isTagsWarningPresent());
    }
    @Test
    public void publishButtonEnableTest(){
        createNewsPO.setTitle("title")
                .clickNewsTagButton()
                .setContent("Valid: more than 20 symbols");
        Assert.assertTrue(isPublishButtonEnable());
    }
    @Test
    public void publishButtonDisableTest(){
        Assert.assertFalse(isPublishButtonEnable());
    }
    @Test
    public void ContinueButton(){
        String createNewsUrl = driver.getCurrentUrl();
        createNewsPO.clickCancelButton()
                    .clickContinueEditingButton();
        Assert.assertEquals(createNewsUrl,driver.getCurrentUrl() );
    }
    @Test
    public void YesCancelButton(){
        createNewsPO.clickCancelButton()
                    .clickYesCancelButton();
        Assert.assertEquals("https://ita-social-projects.github.io/GreenCityClient/#/news",driver.getCurrentUrl() );
    }
    @Test
    public void previewTitleTest(){
        String titleText = createNewsPO.setTitle("Title").getTitleText();
        createNewsPO.clickPreviewButton();
        Assert.assertEquals(titleText,previewNews.getTitleText());
    }
    @Test
    public void previewContentTest(){
        String contentText = createNewsPO.setContent("Content field: more than 20 symbols").getContentText().trim();
        createNewsPO.clickPreviewButton();
        String previewContentText = previewNews.getContentText().trim();
        Assert.assertEquals(contentText, previewContentText);
    }
    @Test
    public void previewSourceTextTest(){
        String sourceText = createNewsPO.setSource("http://google.com").getSourceText();
        createNewsPO.clickPreviewButton();
        String previewSourceText = previewNews.getSourceText();
        Assert.assertEquals(sourceText,previewSourceText);
    }
    @Test
    public void previewBackToEditingLinkTest(){
        String createNewsUrl = driver.getCurrentUrl();
        createNewsPO.clickPreviewButton();
        previewNews.clickBackToEditingLink();
        Assert.assertEquals(createNewsUrl, driver.getCurrentUrl());
    }
    @Test
    public void previewBackToEditingSaveChangesTest() {
        createNewsPO.setTitle("Title")
                .clickNewsTagButton().clickEducationTagButton().clickInitiativeTagButton()
                .setSource("http://google.com")
                .setContent("Valid: more than 20 symbols");
        createNewsPO.clickPreviewButton();
        previewNews.clickBackToEditingLink();
        //Assert.assertEquals("Title", createNewsPO.getTitleText());
        Assert.assertEquals("http://google.com", createNewsPO.getSourceText());
        Assert.assertEquals("Valid: more than 20 symbols", createNewsPO.getContentText());
    }
    @Test
    public void previewTagsTest(){
        createNewsPO.clickEducationTagButton();
        createNewsPO.clickPreviewButton();
        boolean isPresent = isEducationTagsPresent();
        Assert.assertTrue(isPresent);
    }
    @Test
    public void pictureLinkSaveAfterPreviewTest(){
        createNewsPO.clickPreviewButton();
        previewNews.clickBackToEditingLink();
        Assert.assertFalse(isPictureUploadLinkPresent()); //Bag
    }

    public void signInWithCorrectData(){
        signInPO.clickSignInButton();
        signInPO.setEmail("denys.skurskyi@gmail.com")
                .setPassword("AaBb_123")
                .clickSignInUserButton();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
    public void logOut(){
        WebElement userHeaderButton = driver.findElement(By.cssSelector("div#user-avatar-wrapper ul"));
        WebElement logOutButton = driver.findElement(By.xpath("//*[@id = 'user-avatar-wrapper']//a[contains(text(), ' Sign out ')]"));
        userHeaderButton.click();
        logOutButton.click();
    }

    public boolean isSourceWarningPresent() {
        try {
            createNewsPO.getSourceWarning();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isContentWarningPresent() {
        try {
            createNewsPO.getContentWarning();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isTagsWarningPresent() {
        try {
            createNewsPO.getTagsWarning();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isPictureUploadLinkPresent() {
        try {
            createNewsPO.getPictureUploadLink();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isEducationTagsPresent() {
        try {
            previewNews.getEducationTag();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isPublishButtonEnable(){
        boolean isEnable = driver.findElement(PUBLISH_BUTTON.getPath()).isEnabled();
        return isEnable;
    }
}
