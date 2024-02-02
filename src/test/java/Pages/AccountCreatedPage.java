package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage extends BaseTest {

    public AccountCreatedPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[data-qa='continue-button']")
    public WebElement continueButton;

    @FindBy(css = "[data-qa='account-created']")
    public WebElement accountCreatedTitle;

    //----------------------------------------------------

    public void clickOnContinueButton(){
        continueButton.click();
    }





}
