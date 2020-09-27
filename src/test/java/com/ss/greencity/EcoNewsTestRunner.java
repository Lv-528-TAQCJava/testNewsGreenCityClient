package com.ss.greencity;

import com.ss.greencity.pageobjects.SignUpPO;
import com.ss.greencity.pageelements.BaseElement;
import com.ss.greencity.pageelements.Button;
import com.ss.greencity.pageelements.Label;
import com.ss.greencity.pageobjects.BasePageObject;
import com.ss.greencity.pageobjects.EcoNewsListPO;
import com.ss.greencity.pageobjects.NewsCardPO;
import com.ss.greencity.pageobjects.SignUpPO;
import com.ss.greencity.util.WaitsSwitcher;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.NodeList;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Default class for testing https://ita-social-projects.github.io/GreenCityClient/#/news
 * Other classes for testing this page should extend this class
 */
public class EcoNewsTestRunner {
    protected static WebDriver driver;
    protected static WaitsSwitcher waitsSwitcher;
    public EcoNewsTestRunner() {

    }

    @BeforeClass
    public static void setUpClass() {
        String webDriverPath = System.getenv("webDriverPath");
        System.setProperty("webdriver.chrome.driver", webDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(65, TimeUnit.SECONDS);

        waitsSwitcher = new WaitsSwitcher(driver);
        waitsSwitcher.setImplicitWait(1);
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

}
