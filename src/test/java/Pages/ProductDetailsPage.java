package Pages;

import Base.BaseTest;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends BaseTest {

    public ProductDetailsPage(){
        PageFactory.initElements(driver,this);
    }



}
