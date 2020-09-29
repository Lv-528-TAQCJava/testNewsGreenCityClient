package com.ss.greencity;

import com.ss.greencity.util.WaitsSwitcher;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

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
        waitsSwitcher = new WaitsSwitcher(driver, 1, 5);
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

}
