package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {
    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href='/login']")
    public WebElement signUpLogInLink;


    //--------------------------------------------------------------------

    public void clickOnSignUpLogInLink(){
        signUpLogInLink.click();
    }
}
