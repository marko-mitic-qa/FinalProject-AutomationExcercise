package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {
    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href='/login']")
    public WebElement signUpLogInLink;

    @FindBy(partialLinkText = "Cart")
    public WebElement cartLink;



    @FindBy(css = "a[href='/products']")
    public WebElement productsLink;

    @FindBy(css = "a[href='/delete_account']")
    public WebElement deleteAccountButton;

    @FindBy(css = "a[href='/logout']")
    public WebElement logoutButton;

    @FindBy(partialLinkText = "Logged in")
    public WebElement loggedInAsUserButton;


    //--------------------------------------------------------------------

    public void clickOnSignUpLogInLink(){
        signUpLogInLink.click();
    }

    public void clickOnProductsLink(){
        productsLink.click();
    }
    public void clickOnCartLink(){
        cartLink.click();
    }

    public void clickOnDeleteAccountButton(){
        deleteAccountButton.click();
    }

    public boolean deleteButtonIsVisible(){
        boolean isDisplayed = false;
        try{
            isDisplayed = deleteAccountButton.isDisplayed();
        }catch(Exception e){
            System.out.println("DELETE BUTTON ERROR: " + e);
        }
        return isDisplayed;
    }



}
