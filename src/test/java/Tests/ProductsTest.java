package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductsTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        driver. manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        homePage = new HomePage();
        productsPage = new ProductsPage();
        signUpLogInPage = new SignUpLogInPage();
        signUpPage = new SignUpPage();


        homePage.clickOnProductsLink();

    }

    @Test (priority = 10)
    public void userVerifiesThatThereAreProductsOnPage(){
        removeGoogleAds();
        Assert.assertEquals(driver.getCurrentUrl(), productsPageURL);
        Assert.assertTrue(productsPage.getProductCount()>0);
    }

    @Test(priority = 20)
    public void userOpensRandomProduct(){
        productsPage.clickOnRandomProduct();
        Assert.assertEquals(driver.getCurrentUrl(), productsPage.getProductID());

    }

    @Test(priority = 30)
    public void userAddsRandomProductToCart(){
        productsPage.addRandomProductToCart();
        productsPage.clickOnContinueShoppingButton();
        productsPage.clickOnCartLink();

    }






}
