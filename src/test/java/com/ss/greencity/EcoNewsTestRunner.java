package com.ss.greencity;

import com.ss.greencity.pageobjects.EcoNewsListPO;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.NodeList;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;
import static org.junit.Assert.assertTrue;

/**
 * Default class for testing https://ita-social-projects.github.io/GreenCityClient/#/news
 * Other classes for testing this page should extend this class
 */
public class EcoNewsTestRunner {
    protected static WebDriver driver;
    protected By allNewsCards = By.cssSelector("img.list-image-content");
    public EcoNewsTestRunner() {

    }

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "src/test/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(65, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDownClass() {
        driver.close();
        driver.quit();
    }

    @Before
    public void setUp() {
        driver.navigate().to("https://ita-social-projects.github.io/GreenCityClient/#/news");
    }

    @After
    public void tearDown() {
        //logout and so on
    }

    @Ignore //Renewed and moved to EcoNewsOpenNewsTest
    @Test
    public void numberOfItemsFoundTest() {
        EcoNewsListPO newsList = new EcoNewsListPO(driver);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String numberOfItems = newsList.getItemsFound().getText();
        assertTrue(numberOfItems.equals("189 items found"));
    }


}
