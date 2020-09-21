package com.ss.greencity;

import com.ss.greencity.pageobjects.SignUpPO;
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
    public EcoNewsTestRunner() {

    }

    @BeforeClass
    public static void setUpClass() {
        String webDriverPath = System.getenv("webDriverPath");
        System.setProperty("webdriver.chrome.driver", webDriverPath);
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

    /**
     * Closes sign up form if it appears on the page
     */
    protected void closeSignUpForm() {
        try { //Here usually the sign up form appears
            Thread.sleep(500);
        } catch (InterruptedException er) {
            System.out.println(er.toString());
        }
            SignUpPO signUpForm = new SignUpPO(driver);
            boolean formAppeared = signUpForm.closeForm();
            if (formAppeared) {
                System.out.println("Sign up form appeared...");
            }
            //Thread.sleep(500);

    }
}
