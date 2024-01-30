package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpLogInPage extends BaseTest {
    public SignUpLogInPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = "[data-qa='signup-name']")
    public WebElement signupNameField;

    @FindBy (css = "[data-qa='signup-email']")
    public WebElement signupEmailField;

    @FindBy (css = "button[data-qa='signup-button']")
    public WebElement signupButton;

    @FindBy (css = "[data-qa='login-email']")
    public WebElement loginEmailField;

    @FindBy (css = "[data-qa='login-password']")
    public WebElement loginPasswordField;

    @FindBy (css = "button[data-qa='login-button']")
    public WebElement loginButton;



    //---------------------------------------------

    public void inputSignupName(String signUpName){
        signupNameField.clear();
        signupNameField.sendKeys(signUpName);
    }

    public void inputSignupEmail(String signUpEmail){
        signupEmailField.clear();
        signupEmailField.sendKeys(signUpEmail);
    }

    public void clickOnSignupButton(){
        signupButton.click();
    }

    public void inputLoginEmail(String loginEmail){
        loginEmailField.clear();
        loginEmailField.sendKeys(loginEmail);
    }

    public void inputLoginPassword(String loginPassword){
        loginPasswordField.clear();
        loginPasswordField.sendKeys(loginPassword);
    }
    public void clickOnLoginButton(){
        loginButton.click();
    }


}
