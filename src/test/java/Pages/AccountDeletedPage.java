package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDeletedPage extends BaseTest {

    public AccountDeletedPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[data-qa='continue-button']")
    public WebElement continueButton;

    @FindBy(css = "[data-qa='account-deleted']")
    public WebElement accountDeletedTitle;


}
