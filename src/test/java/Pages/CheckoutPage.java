package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage extends BaseTest {


    public CheckoutPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "a[href='/login']")
    public WebElement signUpLogInLink;


    @FindBy(id = "address_invoice")
    public WebElement addressInvoiceInfo;
    public List<WebElement> listUserInfo;

    @FindBy(linkText = "Place Order")
    public WebElement placeOrderButton;



    //-----------------------------------------------------------------

    public void clickOnSignupLoginLink(){
        signUpLogInLink.click();
    }



    //public String userInfoData = "";
    public  String invoiceUserInfo(){
        String result = "";
        listUserInfo = addressInvoiceInfo.findElements(By.tagName("li"));
        for(WebElement user:listUserInfo){
            String userText = user.getText();
            result += userText + " ";
        }
        return result;
    }

    public void clickOnPlaceOrderButton(){
        clickON(placeOrderButton);
    }

    public boolean doesBillingAddressContainsValidData(String billingInfo, String [] userData){
        boolean containsAll = true;

        for (String user : userData) {
            // Case-insensitive check after trimming whitespace
            if (!billingInfo.toLowerCase().contains(user.trim().toLowerCase())) {
                containsAll = false;
                break;
            }
        }

        return containsAll;
    }

}
