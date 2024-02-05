package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTest extends BaseTest {


    @BeforeMethod
    public void pageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        driver. manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String homeURL = "https://automationexercise.com/";




        homePage = new HomePage();
        signUpLogInPage = new SignUpLogInPage();
        productsPage = new ProductsPage();
        cartPage = new CartPage();

    }

    @Test(priority = 10)
    public void userCanOpenProductsPageFromHomepage(){
        homePage.clickOnProductsLink();
        removeGoogleAds();
        if(driver.getCurrentUrl().equals(homepageURL + "#google_vignette")){
            homePage.clickOnProductsLink();
        }
        Assert.assertEquals(driver.getCurrentUrl(), productsPageURL);
    }

    @Test(priority = 20)
    public void userCanOpenCartPageFromHomepage(){
        homePage.clickOnCartLink();
        Assert.assertEquals(driver.getCurrentUrl(), cartPageURL);
    }
    @Test(priority = 30)
    public void userCanOpenSignUpLoginPageFromHomepage(){
        homePage.clickOnSignUpLogInLink();
        Assert.assertEquals(driver.getCurrentUrl(), signUpLoginURL);
    }

    @AfterMethod
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
