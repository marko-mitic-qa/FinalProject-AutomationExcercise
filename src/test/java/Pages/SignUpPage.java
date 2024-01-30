package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BaseTest {

    public SignUpPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "id_gender1")
    public WebElement maleTitleButton;

    @FindBy(id = "id_gender2")
    public WebElement femaleTitleButton;

    @FindBy(id = "name")
    public WebElement nameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "days")
    public WebElement dayOfBirthField;

    @FindBy(id = "months")
    public WebElement monthOfBirthField;

    @FindBy(id = "years")
    public WebElement yearOfBirthField;

    @FindBy(id = "newsletter")
    public WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    public WebElement specialOffersInfoCheckbox;

    @FindBy(id = "first_name")
    public WebElement firstNameField;

    @FindBy(id = "last_name")
    public WebElement lastNameField;

    @FindBy(id = "company")
    public WebElement companyField;

    @FindBy(id = "address1")
    public WebElement address1Field;

    @FindBy(id = "address2")
    public WebElement address2Field;

    @FindBy(id = "country")
    public WebElement countryField;

    @FindBy(id = "state")
    public WebElement stateField;

    @FindBy(id = "city")
    public WebElement cityField;

    @FindBy(id = "zipcode")
    public WebElement zipCodeField;

    @FindBy(id = "mobile_number")
    public WebElement mobileNumberField;

    @FindBy (css = "[data-qa='create-account']")
    public WebElement createAccountButton;

    //-----------------------------------------------------------------

    public void selectTitle(int titleID){
        if (titleID == 1){
            clickON(maleTitleButton);
        }else if(titleID == 2){
            clickON(femaleTitleButton);
        }
    }

    public void inputPassword(String userPassword){
        passwordField.clear();
        passwordField.sendKeys(userPassword);
    }

    public void selectNewsletter(int newsletterID){
        if(newsletterCheckbox.isSelected()){
            clickON(newsletterCheckbox);
        }
        if(newsletterID == 1){
            clickON(newsletterCheckbox);
        }
    }

    public void selectSpecialOffersInfo(int specialOffersID){
        if(specialOffersInfoCheckbox.isSelected()){
            clickON(specialOffersInfoCheckbox);
        }
        if(specialOffersID == 1){
            clickON(specialOffersInfoCheckbox);
        }
    }


    public void inputFirstName(String userFirstName){
        firstNameField.clear();
        firstNameField.sendKeys(userFirstName);
    }

    public void inputLastName(String userLastname){
        lastNameField.clear();
        lastNameField.sendKeys(userLastname);
    }

    public void inputCompanyName(String userCompanyName){
        companyField.clear();
        companyField.sendKeys(userCompanyName);
    }

    public void inputAddress1(String userAddress1){
        address1Field.clear();
        address1Field.sendKeys(userAddress1);
    }

    public void inputAddress2(String userAddress2){
        address2Field.clear();
        address2Field.sendKeys(userAddress2);
    }

    public void selectDayOfBirth(int userDayOfBirth){
        Select dayOfBirth = new Select(dayOfBirthField);
        dayOfBirth.selectByValue(String.valueOf(userDayOfBirth));
    }

    public void selectMonthOfBirth(int userMonthOfBirth){
        Select monthOfBirth = new Select(monthOfBirthField);
        monthOfBirth.selectByValue(String.valueOf(userMonthOfBirth));
    }

    public void selectYearOfBirth(int userYearOfBirth){
        Select yearOfBirth = new Select(yearOfBirthField);
        yearOfBirth.selectByValue(String.valueOf(userYearOfBirth));
    }

    public void selectCountry(String userCountry){
        Select country = new Select(countryField);
        country.selectByValue(userCountry);
    }

    public void inputState(String userState){
        stateField.clear();
        stateField.sendKeys(userState);
    }

    public void inputCity(String userCity){
        cityField.clear();
        cityField.sendKeys(userCity);
    }

    public void inputZipCode(String userZipCode){
        zipCodeField.clear();
        zipCodeField.sendKeys(userZipCode);
    }

    public void inputMobilePhone(String userMobile){
        mobileNumberField.clear();
        mobileNumberField.sendKeys(userMobile);
    }


}
