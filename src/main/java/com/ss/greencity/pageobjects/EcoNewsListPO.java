package com.ss.greencity.pageobjects;

import com.ss.greencity.locators.EcoNewsLocators;
import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.Label;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

/**
 * The main part of news list page
 * https://ita-social-projects.github.io/GreenCityClient/#/news
 */
public class EcoNewsListPO extends BasePageObject implements IAnonymousPO, ILoggedInPO {
    private final String scrollingScript = "window.scrollBy(0,document.body.scrollHeight)";

    public Label getEcoNewsHeader() {
        return ecoNewsHeader;
    }

    public Label getFilterBy() {
        return filterBy;
    }

    private Label ecoNewsHeader;
    private Label filterBy;
    private Label itemsFound;
    private NewsCardComponent firstNewsCard;
    private List<Button> filters;

    private Button galleryViewButton;
    private Button listViewButton;
    private Button createNews;

    public EcoNewsListPO(WebDriver driver) {
        super(driver);
        init();
    }

    private void init() {
        ecoNewsHeader = new Label(driver.findElement(EcoNewsLocators.ECO_HEADER.getPath()));
        createNews = new Button(driver.findElement(EcoNewsLocators.CREATE_NEWS.getPath()));
        filterBy = new Label (driver.findElement(EcoNewsLocators.FILTER_BY.getPath()));
        List<WebElement> filterButtons = driver.findElements(EcoNewsLocators.FILTERS_LIST.getPath());
        filters = new ArrayList<Button>();
        for(WebElement element : filterButtons) {
            filters.add(new Button((element)));
        }
    }

    public Label getItemsFound() {
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .presenceOfElementLocated(EcoNewsLocators.NEWS_LIST.getPath()));
        //if first news card appears, then definitely 'items found' number will be correct
        itemsFound = new Label(driver, EcoNewsLocators.ITEMS_FOUND);
        return itemsFound;
    }

    public Button getGalleryViewButton() {
        galleryViewButton = new Button(driver, EcoNewsLocators.GALLERY_VIEW);
        return galleryViewButton;
    }

    public Button getListViewButton() {
        listViewButton = new Button(driver, EcoNewsLocators.LIST_VIEW);
        return listViewButton;
    }

    public NewsCardComponent getFirstNewsCard() {
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .presenceOfElementLocated(EcoNewsLocators.NEWS_LIST.getPath()));
        firstNewsCard = new NewsCardComponent(driver.findElements(EcoNewsLocators.NEWS_LIST.getPath()).get(0));
        return firstNewsCard;
    }

    public List<Button> getFilters() {
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .presenceOfAllElementsLocatedBy(EcoNewsLocators.FILTERS_LIST.getPath()));
        ArrayList<WebElement> filters0 = (ArrayList<WebElement>) driver.findElements(EcoNewsLocators.FILTERS_LIST.getPath());
        filters = new ArrayList<Button>();
        for (WebElement b: filters0) {
            filters.add(new Button(b));
        }
        return filters;
    }

    public List<NewsCardComponent> getAllNews() {
        int allNewsCount;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .presenceOfElementLocated(EcoNewsLocators.NEWS_LIST.getPath()));
        List<WebElement> loadedNews;
        do {
            allNewsCount = Integer.parseInt(getItemsFound().getText().replaceAll("[^0-9]", ""));
            js.executeScript(scrollingScript);
            loadedNews = driver.findElements(EcoNewsLocators.NEWS_LIST.getPath());
        } while (loadedNews.size() < allNewsCount);

        List<NewsCardComponent> allNews = new ArrayList<NewsCardComponent>();
        for(int i = 0; i < loadedNews.size(); i++) {
            allNews.add(new NewsCardComponent(loadedNews.get(i)));
        }

        return allNews;
    }

    public Button getFilterButton(String filter) {
        for(Button button : filters) {
            if(button.getText().equals(filter))
                return button;
        }
        return null;
    }
    public CreateNewsPO goToCreateNewsPage(){
        waitsSwitcher.setExplicitWait(ExpectedConditions
                .presenceOfElementLocated(EcoNewsLocators.CREATE_NEWS.getPath()));
        createNews = new Button(driver.findElement(EcoNewsLocators.CREATE_NEWS.getPath()));
        createNews.click();
        return new CreateNewsPO(driver);
    }
}
