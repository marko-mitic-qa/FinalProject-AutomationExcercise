package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BaseTest {

    public PaymentPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "name_on_card")
    public WebElement nameOnCardField;

    @FindBy(name = "card_number")
    public WebElement cardNumberField;
    @FindBy(name = "cvc")
    public WebElement cvcField;
    @FindBy(name = "expiry_month")
    public WebElement cardExpiryMonthField;
    @FindBy(name = "expiry_year")
    public WebElement cardExpiryYear;
    @FindBy(id = "submit")
    public WebElement payAndConfirmButton;


    //-------------------------------------------------

    public void inputNameOnCard(String name){
        nameOnCardField.clear();
        nameOnCardField.sendKeys(name);
    }

    public void inputCardNumber(String cardNumber){
        cardNumberField.clear();
        cardNumberField.sendKeys(cardNumber);
    }
    public void inputCVCNumber(String cvcNumber){
        cvcField.clear();
        cvcField.sendKeys(cvcNumber);
    }
    public void inputCardExpiryMonth(String month){
        cardExpiryMonthField.clear();
        cardExpiryMonthField.sendKeys(month);
    }
    public void inputCardExpiryYear(String year){
        cardExpiryYear.clear();
        cardExpiryYear.sendKeys(year);
    }
    public void clickOnPayAndConfirmButton(){
        payAndConfirmButton.click();
    }

}
