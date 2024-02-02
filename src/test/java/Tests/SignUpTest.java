package Tests;

import Base.BaseTest;
import Pages.AccountCreatedPage;
import Pages.HomePage;
import Pages.SignUpLogInPage;
import Pages.SignUpPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignUpTest extends BaseTest {



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
    }



    @Test (priority = 10)
    public void newUserCanSignUp(){
        String title = excelReader.getStringData("SignUpDataValid",1,0);
        String name = excelReader.getStringData("SignUpDataValid",1,1);
        String validEmail = excelReader.getStringData("SignUpDataValid",1,2);
        String validPassword = excelReader.getStringData("SignUpDataValid",1,3);
        String validDayOfBirth = String.valueOf(excelReader.getIntegerData("SignUpDataValid",1,4));
        String validMonthOfBirth = String.valueOf(excelReader.getIntegerData("SignUpDataValid",1,5));
        String validYearOfBirth = String.valueOf(excelReader.getIntegerData("SignUpDataValid",1,6));
        String newsletterOption = excelReader.getStringData("SignUpDataValid",1,7);
        String specialOffersOption = excelReader.getStringData("SignUpDataValid",1,8);
        String validFirstName = excelReader.getStringData("SignUpDataValid",1,9);
        String validLastName = excelReader.getStringData("SignUpDataValid",1,10);
        String validCompany = excelReader.getStringData("SignUpDataValid",1,11);
        String validAddress1 = excelReader.getStringData("SignUpDataValid",1,12);
        String validAddress2 = excelReader.getStringData("SignUpDataValid",1,13);
        String validCountry = excelReader.getStringData("SignUpDataValid",1,14);
        String validState = excelReader.getStringData("SignUpDataValid",1,15);
        String validCity = excelReader.getStringData("SignUpDataValid",1,16);
        String validZipcode = String.valueOf(excelReader.getIntegerData("SignUpDataValid",1,17));
        String validMobileNumber = String.valueOf(excelReader.getIntegerData("SignUpDataValid",1,18));





        Assert.assertEquals(driver.getCurrentUrl(), homepageURL);
        homePage.clickOnSignUpLogInLink();
        Assert.assertEquals(driver.getCurrentUrl(), signUpLoginURL);
        Assert.assertTrue(signUpLogInPage.signupButton.isDisplayed());
        Assert.assertTrue(signUpLogInPage.signupNameField.isDisplayed());
        Assert.assertTrue(signUpLogInPage.signupEmailField.isDisplayed());
        //asertacija url, visible signup button and input fields
        signUpLogInPage.inputSignupName(name);
        signUpLogInPage.inputSignupEmail(validEmail);
        signUpLogInPage.clickOnSignupButton();
        //asertacija url, visible mandatory fields, create account button
        signUpPage.selectTitle(title);
        //asertacija da se proveri da name i email nisu prazni i da imaju iste vrednosti kao iz excel-a
        signUpPage.inputPassword(validPassword);
        signUpPage.inputFirstName(validFirstName);
        signUpPage.inputLastName(validLastName);
        signUpPage.selectDayOfBirth((validDayOfBirth));
        signUpPage.selectMonthOfBirth((validMonthOfBirth));
        signUpPage.selectYearOfBirth((validYearOfBirth));
        signUpPage.selectNewsletter(newsletterOption);
        signUpPage.selectSpecialOffersInfo(specialOffersOption);
        signUpPage.inputCompanyName(validCompany);
        signUpPage.inputAddress1(validAddress1);
        signUpPage.inputAddress2(validAddress2);
        signUpPage.selectCountry(validCountry);
        signUpPage.inputState(validState);
        signUpPage.inputCity(validCity);
        signUpPage.inputZipCode(validZipcode);
        signUpPage.inputMobilePhone(validMobileNumber);
        signUpPage.clickOnCreateAccount();
        accountCreatedPage.clickOnContinueButton();

    }



}
