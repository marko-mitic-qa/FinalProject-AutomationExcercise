package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

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
        accountDeletedPage = new AccountDeletedPage();
    }

    @Test (priority = 10)
    public void newUserCanSignUpFillingMandatoryFieldsWithValidData(){
        String name = excelReader.getStringData("SignUpDataValid",1,1);
        String validEmail = excelReader.getStringData("SignUpDataValid",1,2);
        String validPassword = excelReader.getStringData("SignUpDataValid",1,3);
        String validFirstName = excelReader.getStringData("SignUpDataValid",1,9);
        String validLastName = excelReader.getStringData("SignUpDataValid",1,10);
        String validAddress1 = excelReader.getStringData("SignUpDataValid",1,12);
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

        signUpLogInPage.inputSignupName(name);
        signUpLogInPage.inputSignupEmail(validEmail);
        signUpLogInPage.clickOnSignupButton();
        Assert.assertEquals(driver.getCurrentUrl(), signupURL);
        Assert.assertEquals(signUpPage.nameField.getAttribute("value"), name);
        Assert.assertEquals(signUpPage.emailField.getAttribute("value"), validEmail);


        signUpPage.inputPassword(validPassword);
        signUpPage.inputFirstName(validFirstName);
        signUpPage.inputLastName(validLastName);
        signUpPage.inputAddress1(validAddress1);
        signUpPage.selectCountry(validCountry);
        signUpPage.inputState(validState);
        signUpPage.inputCity(validCity);
        signUpPage.inputZipCode(validZipcode);
        signUpPage.inputMobilePhone(validMobileNumber);

        Assert.assertEquals(signUpPage.nameField.getAttribute("value"), name);
        Assert.assertEquals(signUpPage.passwordField.getAttribute("value"), validPassword);
        Assert.assertEquals(signUpPage.firstNameField.getAttribute("value"),validFirstName);
        Assert.assertEquals(signUpPage.lastNameField.getAttribute("value"), validLastName);
        Assert.assertEquals(signUpPage.address1Field.getAttribute("value"), validAddress1);
        Assert.assertEquals(signUpPage.countryField.getAttribute("value"), validCountry);
        Assert.assertEquals(signUpPage.stateField.getAttribute("value"), validState);
        Assert.assertEquals(signUpPage.cityField.getAttribute("value"), validCity);
        Assert.assertEquals(signUpPage.zipCodeField.getAttribute("value"), validZipcode);
        Assert.assertEquals(signUpPage.mobileNumberField.getAttribute("value"), validMobileNumber);

        signUpPage.clickOnCreateAccount();
        Assert.assertEquals(driver.getCurrentUrl(), accountCreatedURL);
        Assert.assertTrue(accountCreatedPage.accountCreatedTitle.isDisplayed());
        accountCreatedPage.clickOnContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(), homepageURL);
        Assert.assertTrue(homePage.loggedInAsUserButton.getText().contains(name));
        Assert.assertTrue(homePage.logoutButton.isDisplayed());

    }

    @Test (priority = 20)
    public void newUserCanSignUpFillingAllFieldsWithValidData(){
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

        signUpLogInPage.inputSignupName(name);
        signUpLogInPage.inputSignupEmail(validEmail);
        signUpLogInPage.clickOnSignupButton();
        Assert.assertEquals(driver.getCurrentUrl(), signupURL);
        Assert.assertEquals(signUpPage.nameField.getAttribute("value"), name);
        Assert.assertEquals(signUpPage.emailField.getAttribute("value"), validEmail);


        signUpPage.selectTitle(title);
        signUpPage.inputPassword(validPassword);

        signUpPage.selectDayOfBirth(validDayOfBirth);
        signUpPage.selectMonthOfBirth(validMonthOfBirth);
        signUpPage.selectYearOfBirth(validYearOfBirth);
        signUpPage.selectNewsletter(newsletterOption);
        signUpPage.selectSpecialOffersInfo(specialOffersOption);
        signUpPage.inputFirstName(validFirstName);
        signUpPage.inputLastName(validLastName);
        signUpPage.inputCompanyName(validCompany);
        signUpPage.inputAddress1(validAddress1);
        signUpPage.inputAddress2(validAddress2);
        signUpPage.selectCountry(validCountry);
        signUpPage.inputState(validState);
        signUpPage.inputCity(validCity);
        signUpPage.inputZipCode(validZipcode);
        signUpPage.inputMobilePhone(validMobileNumber);


        Assert.assertEquals(signUpPage.nameField.getAttribute("value"), name);
        Assert.assertEquals(signUpPage.passwordField.getAttribute("value"), validPassword);
        Assert.assertEquals(signUpPage.firstNameField.getAttribute("value"),validFirstName);
        Assert.assertEquals(signUpPage.lastNameField.getAttribute("value"), validLastName);
        Assert.assertEquals(signUpPage.address1Field.getAttribute("value"), validAddress1);
        Assert.assertEquals(signUpPage.countryField.getAttribute("value"), validCountry);
        Assert.assertEquals(signUpPage.stateField.getAttribute("value"), validState);
        Assert.assertEquals(signUpPage.cityField.getAttribute("value"), validCity);
        Assert.assertEquals(signUpPage.zipCodeField.getAttribute("value"), validZipcode);
        Assert.assertEquals(signUpPage.mobileNumberField.getAttribute("value"), validMobileNumber);

        signUpPage.clickOnCreateAccount();
        Assert.assertEquals(driver.getCurrentUrl(), accountCreatedURL);
        Assert.assertTrue(accountCreatedPage.accountCreatedTitle.isDisplayed());
        accountCreatedPage.clickOnContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(), homepageURL);
        Assert.assertTrue(homePage.loggedInAsUserButton.getText().contains(name));
        Assert.assertTrue(homePage.logoutButton.isDisplayed());

    }

    @Test (priority = 30)
    public void userCanNotStartSignUpProcessByClickingOnSignupWithEmptyFields(){
        String name = excelReader.getStringData("InvalidData",1,1);
        String invalidEmail = excelReader.getStringData("InvalidData",1,2);

        Assert.assertEquals(driver.getCurrentUrl(), homepageURL);
        homePage.clickOnSignUpLogInLink();
        Assert.assertEquals(driver.getCurrentUrl(), signUpLoginURL);
        Assert.assertTrue(signUpLogInPage.signupButton.isDisplayed());
        Assert.assertTrue(signUpLogInPage.signupNameField.isDisplayed());
        Assert.assertTrue(signUpLogInPage.signupEmailField.isDisplayed());

        signUpLogInPage.clickOnSignupButton();

        Assert.assertEquals(driver.getCurrentUrl(), signUpLoginURL);
        Assert.assertTrue(signUpLogInPage.signupButton.isDisplayed());

    }



    @Test (priority = 40)
    public void userCanNotStartSignUpProcessWhenEntersInvalidEmail(){
        String name = excelReader.getStringData("InvalidData",1,1);
        String invalidEmail = excelReader.getStringData("InvalidData",1,2);

        Assert.assertEquals(driver.getCurrentUrl(), homepageURL);
        homePage.clickOnSignUpLogInLink();
        Assert.assertEquals(driver.getCurrentUrl(), signUpLoginURL);
        Assert.assertTrue(signUpLogInPage.signupButton.isDisplayed());
        Assert.assertTrue(signUpLogInPage.signupNameField.isDisplayed());
        Assert.assertTrue(signUpLogInPage.signupEmailField.isDisplayed());

        signUpLogInPage.inputSignupName(name);
        signUpLogInPage.inputSignupEmail(invalidEmail);
        signUpLogInPage.clickOnSignupButton();

        Assert.assertEquals(driver.getCurrentUrl(), signUpLoginURL);
        Assert.assertTrue(signUpLogInPage.signupButton.isDisplayed());
        //Kako uvatiti onaj mali popup kada se ukuca pogresan mejl

    }

    @Test (priority = 50)
    public void newUserCantSignUpDoesntFillAllMandatoryFieldsWithValidData() throws InterruptedException {
        String name = excelReader.getStringData("SignUpDataValid",1,1);
        String validEmail = excelReader.getStringData("SignUpDataValid",1,2);
        String validPassword = excelReader.getStringData("SignUpDataValid",1,3);
        String validFirstName = excelReader.getStringData("SignUpDataValid",1,9);
        String validLastName = excelReader.getStringData("SignUpDataValid",1,10);
        String validAddress1 = excelReader.getStringData("SignUpDataValid",1,12);
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




        signUpLogInPage.inputSignupName(name);
        signUpLogInPage.inputSignupEmail(validEmail);
        signUpLogInPage.clickOnSignupButton();
        Assert.assertEquals(driver.getCurrentUrl(), signupURL);
        Assert.assertEquals(signUpPage.nameField.getAttribute("value"), name);
        Assert.assertEquals(signUpPage.emailField.getAttribute("value"), validEmail);

        List<Consumer<String>> mandatoryFields = Arrays.asList(
                signUpPage::inputPassword,
                signUpPage::inputFirstName,
                signUpPage::inputLastName,
                signUpPage::inputAddress1,
                //signUpPage::selectCountry,
                signUpPage::inputState,
                signUpPage::inputCity,
                signUpPage::inputZipCode,
                signUpPage::inputMobilePhone
        );

        List<String> validFieldValues = Arrays.asList(
                validPassword,
                validFirstName,
                validLastName,
                validAddress1,
                //validCountry,
                validState,
                validCity,
                validZipcode,
                validMobileNumber
        );

        // Loop through each mandatory field
        for (int i = 0; i < mandatoryFields.size(); i++) {


            for (int j = 0; j < mandatoryFields.size(); j++) {
                if (i != j) {
                    mandatoryFields.get(j).accept(validFieldValues.get(j));
                }
            }

            // Click on the create account button
            signUpPage.clickOnCreateAccount();

            Assert.assertEquals(driver.getCurrentUrl(), signupURL);
            Assert.assertNotEquals(driver.getCurrentUrl(), accountCreatedURL);

            driver.navigate().refresh();
        }

    }




/*    @AfterMethod
    public void tearDown(){
        if(homePage.deleteButtonIsVisible()){
            homePage.deleteAccountButton.click();
            accountDeletedPage.clickOnContinueButton();
        }

        driver.manage().deleteAllCookies();
        driver.quit();
    }*/



}
