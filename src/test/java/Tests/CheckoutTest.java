package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckoutTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(signUpLoginURL);
        driver. manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        homePage = new HomePage();
        productsPage = new ProductsPage();
        signUpLogInPage = new SignUpLogInPage();
        signUpPage = new SignUpPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        paymentPage = new PaymentPage();
        paymentDonePage = new PaymentDonePage();
    }

    @Test(priority = 10)
    public void registeredUserCanBuyRandomProduct(){
        String name = excelReader.getStringData("ExistingUser",1,1);
        String validEmail = excelReader.getStringData("ExistingUser",1,2);
        String validPassword = excelReader.getStringData("ExistingUser",1,3);
        String validFirstName = excelReader.getStringData("ExistingUser",1,9);
        String validLastName = excelReader.getStringData("ExistingUser",1,10);
        String validAddress1 = excelReader.getStringData("ExistingUser",1,12);
        String validCountry = excelReader.getStringData("ExistingUser",1,14);
        String validState = excelReader.getStringData("ExistingUser",1,15);
        String validCity = excelReader.getStringData("ExistingUser",1,16);
        String validZipcode = String.valueOf(excelReader.getIntegerData("ExistingUser",1,17));
        String validMobileNumber = String.valueOf(excelReader.getIntegerData("ExistingUser",1,18));
        String validCardNumber = String.valueOf(excelReader.getStringData("ExistingUser",1,19));
        String validCVCNumber = String.valueOf(excelReader.getIntegerData("ExistingUser",1,20));
        String validExpirationMonth = String.valueOf(excelReader.getIntegerData("ExistingUser",1,21));
        String validExpirationYear = String.valueOf(excelReader.getIntegerData("ExistingUser",1,22));
        String[] userMandatoryData = {validFirstName, validLastName,validAddress1,validCountry, validState,validCity,validZipcode,validMobileNumber};

        signUpLogInPage.inputLoginEmail(validEmail);
        signUpLogInPage.inputLoginPassword(validPassword);
        signUpLogInPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), homepageURL);
        Assert.assertTrue(homePage.logoutButton.isDisplayed());
        Assert.assertTrue(homePage.loggedInAsUserButton.getText().contains(name));
        homePage.clickOnCartLink();
        cartPage.deleteAllItemsFromCart();
        Assert.assertTrue(cartPage.clickHereToBuyProductsLink.isDisplayed());
        cartPage.clickOnProductsPage();
        removeGoogleAds();

        if(driver.getCurrentUrl().equals("https://automationexercise.com/view_cart#google_vignette")){
            cartPage.clickOnProductsPage();
        }
        productsPage.addRandomProductToCart();
        productsPage.clickOnViewCartPopup();
        Assert.assertEquals(driver.getCurrentUrl(), cartPageURL);
        Assert.assertTrue(cartPage.deleteItemButtonsAreVisible());
        Assert.assertTrue(cartPage.checkoutButton.isDisplayed());
        cartPage.clickOnCheckoutButton();
        Assert.assertTrue(checkoutPage.doesBillingAddressContainsValidData(checkoutPage.invoiceUserInfo(), userMandatoryData));
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPageURL);
        checkoutPage.clickOnPlaceOrderButton();
        if(driver.getCurrentUrl().equals("https://automationexercise.com/checkout#google_vignette")){
            checkoutPage.clickOnPlaceOrderButton();
        }
        Assert.assertEquals(driver.getCurrentUrl(), paymentPageURL);
        paymentPage.inputNameOnCard(validFirstName + " " + validLastName);
        paymentPage.inputCardNumber(validCardNumber);
        paymentPage.inputCVCNumber(validCVCNumber);
        paymentPage.inputCardExpiryMonth(validExpirationMonth);
        paymentPage.inputCardExpiryYear(validExpirationYear);
        paymentPage.clickOnPayAndConfirmButton();
        Assert.assertTrue(driver.getCurrentUrl().contains(paymentDonePageURL));
        Assert.assertTrue(paymentDonePage.downloadInvoiceButton.isDisplayed());
        paymentDonePage.clickOnContinueButton();
        removeGoogleAds();
        if(driver.getCurrentUrl().equals("https://automationexercise.com/payment_done/400#google_vignette")){
            paymentDonePage.clickOnContinueButton();
        }
        Assert.assertEquals(driver.getCurrentUrl(), homepageURL);

    }

    @AfterMethod
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
