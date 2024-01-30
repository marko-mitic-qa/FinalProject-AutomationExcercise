package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.SignUpLogInPage;
import Pages.SignUpPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignUpTest extends BaseTest {

    String homepageURL = "https://automationexercise.com/";
    String signUpLoginURL = "https://automationexercise.com/login";
    String signupURL = "https://automationexercise.com/signup";

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
    }

    @Test (priority = 10)
    public void newUserCanSignUp(){

        Assert.assertEquals(driver.getCurrentUrl(), homepageURL);
        homePage.clickOnSignUpLogInLink();
        Assert.assertEquals(driver.getCurrentUrl(), signUpLoginURL);
        Assert.assertTrue(signUpLogInPage.signupButton.isDisplayed());
        Assert.assertTrue(signUpLogInPage.signupNameField.isDisplayed());
        Assert.assertTrue(signUpLogInPage.signupEmailField.isDisplayed());
        //asertacija url, visible signup button and input fields
        signUpLogInPage.inputSignupName("Marko");
        signUpLogInPage.inputSignupEmail("marko@marko123");
        signUpLogInPage.clickOnSignupButton();
        //asertacija url, visible mandatory fields, create account button
        signUpPage.selectTitle(1);
        //asertacija da se proveri da name i email nisu prazni i da imaju iste vrednosti kao iz excel-a
        signUpPage.inputPassword("QwertY123!@#");
        signUpPage.inputFirstName("Marko");
        signUpPage.inputLastName("Marko");
        signUpPage.selectDayOfBirth(3);
        signUpPage.selectMonthOfBirth(3);
        signUpPage.selectYearOfBirth(1987);
        signUpPage.selectNewsletter(1);
        signUpPage.selectSpecialOffersInfo(1);
        signUpPage.inputCompanyName("firma");
        signUpPage.inputAddress1("adresa1");
        signUpPage.inputAddress2("adresa2");
        signUpPage.selectCountry("United States");
        signUpPage.inputState("California");
        signUpPage.inputCity("San Francisco");
        signUpPage.inputZipCode("121212");
        signUpPage.inputMobilePhone("13131313131313");


    }



}
