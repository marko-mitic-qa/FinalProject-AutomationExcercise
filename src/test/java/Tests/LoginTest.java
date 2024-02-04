package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        driver. manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String homeURL = "https://automationexercise.com/";




        homePage = new HomePage();
        signUpLogInPage = new SignUpLogInPage();
        signUpPage = new SignUpPage();
        accountCreatedPage = new AccountCreatedPage();
        accountDeletedPage = new AccountDeletedPage();
    }

    @Test(priority = 10)
    public void registeredUserCanLoginWithValidData(){
        String name = excelReader.getStringData("ExistingUser",1,1);
        String validEmail = excelReader.getStringData("ExistingUser",1,2);
        String validPassword = excelReader.getStringData("ExistingUser",1,3);
        homePage.clickOnSignUpLogInLink();
        signUpLogInPage.inputLoginEmail(validEmail);
        signUpLogInPage.inputLoginPassword(validPassword);
        signUpLogInPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), homepageURL);
        Assert.assertTrue(homePage.logoutButton.isDisplayed());
        Assert.assertTrue(homePage.loggedInAsUserButton.getText().contains(name));
    }

    @Test(priority = 20)
    public void userCannotLoginWithEmptyEmailAndPasswordFields(){
        homePage.clickOnSignUpLogInLink();
        signUpLogInPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), signUpLoginURL);
        Assert.assertTrue(signUpLogInPage.loginButton.isDisplayed());
        Assert.assertTrue(signUpLogInPage.loginEmailField.isDisplayed());
        Assert.assertTrue(signUpLogInPage.loginPasswordField.isDisplayed());
    }

    @Test(priority = 30)
    public void userCannotLoginWithInvalidEmailAndPassword(){
        String invalidEmail = excelReader.getStringData("InvalidData",1,2);
        String invalidPassword = excelReader.getStringData("InvalidData",1,3);
        homePage.clickOnSignUpLogInLink();
        signUpLogInPage.inputLoginEmail(invalidEmail);
        signUpLogInPage.inputLoginPassword(invalidPassword);
        signUpLogInPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), signUpLoginURL);
        Assert.assertTrue(signUpLogInPage.loginButton.isDisplayed());
        Assert.assertTrue(signUpLogInPage.loginEmailField.isDisplayed());
        Assert.assertTrue(signUpLogInPage.loginPasswordField.isDisplayed());
    }

    @AfterMethod
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }




}
