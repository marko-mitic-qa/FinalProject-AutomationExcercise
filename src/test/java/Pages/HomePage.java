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



    @FindBy(css = "a[href='/products']")
    public WebElement productsLink;

    @FindBy(css = "a[href='/delete_account']")
    public WebElement deleteAccountButton;

    @FindBy(css = "a[href='/logout']")
    public WebElement logoutButton;


    //--------------------------------------------------------------------

    public void clickOnSignUpLogInLink(){
        signUpLogInLink.click();
    }

    public void clickOnProductsLink(){
        productsLink.click();
    }

    public void clickOnDeleteAccountButton(){
        deleteAccountButton.click();
    }
}
