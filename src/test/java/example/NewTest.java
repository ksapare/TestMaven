package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NewTest {
    private WebDriver driver;
    HomePage objHomePage;
    MavenPage objMavenPage;

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.gecko.driver", "/tmp/Selenium/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/V4/");
    }

    /*@Test
    public void testEasy() {
        driver.get("http://www.guru99.com/selenium-tutorial.html");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Free Selenium Tutorials"));
    }*/


    @Test(priority = 0)
    public void test_Home_Page_Appear_Correct() {

        //Create Login Page object
        objMavenPage = new MavenPage(driver);
        //Verify login page title
        String loginPageTitle = objMavenPage.getLoginTitle();
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
        //login to application
        objMavenPage.loginToGuru99("mgr123", "mgr!23");
        // go the next page
        objHomePage = new HomePage(driver);
        //Verify home page
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));

    }
    @AfterTest
    public void afterTest () {
        driver.quit();
    }
}
