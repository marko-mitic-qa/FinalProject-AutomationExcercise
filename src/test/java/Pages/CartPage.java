package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BaseTest {

    public CartPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "a[href='/products']")
    public WebElement clickHereToBuyProductsLink;

    @FindBy(css = ".btn.btn-default.check_out")
    public WebElement checkoutButton;

    @FindBy(className = "cart_quantity_delete")
    public List<WebElement> listDeleteItemButtons;
    @FindBy(linkText = "Register / Login")
    public WebElement checkoutLoginLink;

    @FindBy(partialLinkText = "/product_details/")
    public WebElement singleCartItem;

    @FindBy(className = "cart_total_price")
    public WebElement cartTotalPrice;
    @FindBy(css = "a[href='/login']")
    public WebElement signupLogInLink;

    @FindBy(css = "a[href='/products']")
    public WebElement productsLink;


    //------------------------------------------------

    public void clickOnProductsPage(){
        productsLink.click();
    }
/*    public void deleteAllItemsFromCart(){
        if(!clickHereToBuyProductsLink.isDisplayed()){
            for(WebElement button:listDeleteItemButtons){
                button.click();
            }
        }
    }*/

    public void deleteAllItemsFromCart() {
        if (deleteItemButtonsAreVisible()) {
            System.out.println("Click here to buy products link is not displayed. Proceeding with item deletion.");

            for (int i = 0; i < listDeleteItemButtons.size(); i++) {
                System.out.println("Deleting item " + (i + 1));
                clickON(listDeleteItemButtons.get(i));
                // Add additional logic if needed after clicking the delete button.
            }
        } else {
            System.out.println("Click here to buy products link is displayed. No items to delete.");
        }
    }

    public void clickOnCheckoutLoginLink(){
        checkoutLoginLink.click();
    }

    public boolean cartIsEmptyMessageIsVisible(){
        boolean isVisible = false;
        try{
            isVisible = clickHereToBuyProductsLink.isDisplayed();
        }catch(Exception e){
            System.out.println("CARTS IS EMPTY MESSAGE:::" + e);
        }
        return isVisible;

    }

    public boolean deleteItemButtonsAreVisible(){
        boolean isVisible = false;
        try{
            isVisible = listDeleteItemButtons.getFirst().isEnabled();
        }catch(Exception e){
            System.out.println("NO DELETE BUTTONS:::" + e);
        }
        return isVisible;

    }

    public void clickOnCheckoutButton(){
        checkoutButton.click();
    }

    public void clickOnSignUpLoginLink(){
        signupLogInLink.click();
    }

}
