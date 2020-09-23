package com.ss.greencity.pageobjects;

import com.ss.greencity.locators.EcoNewsLocators;
import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * The main part of news list page
 * https://ita-social-projects.github.io/GreenCityClient/#/news
 */
public class EcoNewsListPO extends BasePageObject {
    private final String scrollingScript = "window.scrollBy(0,document.body.scrollHeight)";
    private Label itemsFound;
    private NewsCardPO firstNewsCard;
    private List<Button> filters; //I'm not sure it's simple to use List here.
    //Probably we need to have each filter Button separately

    private Button galleryViewButton;
    private Button listViewButton;

    public EcoNewsListPO(WebDriver driver) {
        super(driver);
        init();
    }

    private void init() {
        List<WebElement> filterButtons = driver.findElements(EcoNewsLocators.FILTERS_LIST.getPath());
        filters = new ArrayList<Button>();
        for(WebElement element : filterButtons) {
            filters.add(new Button((element)));
        }
    }

    public Label getItemsFound() {
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

    public NewsCardPO getFirstNewsCard() {
        firstNewsCard = new NewsCardPO(driver.findElements(EcoNewsLocators.NEWS_LIST.getPath()).get(0));
        return firstNewsCard;
    }

    public List<Button> getFilters() {
        ArrayList<WebElement> filters0 = (ArrayList<WebElement>) driver.findElements(EcoNewsLocators.FILTERS_LIST.getPath());
        filters = new ArrayList<Button>();
        for (WebElement b: filters0) {
            filters.add(new Button(b));
        }
        return filters;
    }

    public List<NewsCardPO> getAllNews() {
        int allNewsCount;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> loadedNews;
        do {
            allNewsCount = Integer.parseInt(getItemsFound().getText().replaceAll("[^0-9]", ""));
            js.executeScript(scrollingScript);
            loadedNews = driver.findElements(EcoNewsLocators.NEWS_LIST.getPath());
        } while (loadedNews.size() < allNewsCount);

        List<NewsCardPO> allNews = new ArrayList<NewsCardPO>();
        for(int i = 0; i < loadedNews.size(); i++) {
            allNews.add(new NewsCardPO(loadedNews.get(i)));
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
}
