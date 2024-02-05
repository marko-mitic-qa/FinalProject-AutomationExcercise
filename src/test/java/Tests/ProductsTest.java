package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductsTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(productsPageURL);
        driver. manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        homePage = new HomePage();
        productsPage = new ProductsPage();
        signUpLogInPage = new SignUpLogInPage();
        signUpPage = new SignUpPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
    }

    @Test (priority = 10)
    public void userVerifiesThatThereAreProductsOnPage(){
        removeGoogleAds();
        Assert.assertEquals(driver.getCurrentUrl(), productsPageURL);
        Assert.assertTrue(productsPage.getProductCount()>0);
    }

    @Test(priority = 20)
    public void userVerifiesThatClickingOnProductOpensThatSameProductInNewPage(){
        productsPage.clickOnRandomProduct();
        removeGoogleAds();
        productsPage.clickOnRandomProduct();
        Assert.assertEquals(driver.getCurrentUrl(), productsPage.getProductID());

    }
    @Test(priority = 30)
    public void userCanSearchForExistingItemFromSearchField() throws InterruptedException {
        String productTitle = productsPage.randomProductTitle();

        productsPage.inputSearchProduct(productTitle);
        productsPage.clickOnSearchButton();
        Assert.assertTrue(productsPage.searchedProductsAreVisible(productTitle));
    }

    @Test(priority = 40)
    public void userCanSelectCategoryOfProducts(){
        productsPage.selectRandomCategoryProduct();
        removeGoogleAds();

        if(driver.getCurrentUrl().equals("https://automationexercise.com/products#google_vignette")){
            productsPage.selectRandomCategoryProduct();
        }
        Assert.assertEquals(driver.getCurrentUrl(), productsPage.categoryURL);

    }

    @Test(priority = 50)
    public void userCanSelectProductsByBrand(){
        productsPage.selectRandomBrandProducts();
        removeGoogleAds();

        if(driver.getCurrentUrl().equals("https://automationexercise.com/products#google_vignette")){
            productsPage.selectRandomBrandProducts();
        }
        Assert.assertEquals(driver.getCurrentUrl(), productsPage.brandURL);

    }





    @AfterMethod
    public void tearDown(){
        if(homePage.deleteButtonIsVisible()){
            homePage.deleteAccountButton.click();
            accountDeletedPage.clickOnContinueButton();
        }

        driver.manage().deleteAllCookies();
        driver.quit();
    }










}
