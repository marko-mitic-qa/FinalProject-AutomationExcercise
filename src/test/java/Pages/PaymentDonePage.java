package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentDonePage extends BaseTest {
    public PaymentDonePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Download Invoice")
    public WebElement downloadInvoiceButton;

    @FindBy(linkText = "Continue")
    public WebElement continueButton;

    //---------------------------------------------------

    public void clickOnContinueButton(){
        continueButton.click();
    }


}
