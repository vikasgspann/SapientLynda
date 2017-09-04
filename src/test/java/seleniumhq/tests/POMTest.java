package seleniumhq.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import seleniumhq.pages.DocumentationPage;
import seleniumhq.pages.HomePage;
import seleniumhq.pages.TestDesignConsiderationPage;

public class POMTest {

    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","D:\\Selenium_Setup\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://www.seleniumhq.org/");
    }

    @Test
    public void testRun(){

        HomePage hp = new HomePage(driver);
        DocumentationPage dp = hp.documentationLinkClick();
        TestDesignConsiderationPage tdcp = dp.testDesignConsiderationClick();
        String expected = tdcp.pageObjectDesignPatternHeadlineString();
        String actual = "Page Object Design Pattern";

        Assert.assertEquals(expected,actual);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
