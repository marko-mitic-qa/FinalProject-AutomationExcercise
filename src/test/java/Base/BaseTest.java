package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseTest {

    public static WebDriver driver;
    public ExcelReader excelReader;

    public HomePage homePage;
    public SignUpLogInPage signUpLogInPage;
    public SignUpPage signUpPage;
    public ProductsPage productsPage;
    public AccountCreatedPage accountCreatedPage;

    //------------------------------------
    public String homepageURL = "https://automationexercise.com/";
    public String signUpLoginURL = "https://automationexercise.com/login";
    public String signupURL = "https://automationexercise.com/signup";
    public String accountCreatedURL = "https://automationexercise.com/account_created";
    public String accountdeletedURL = "https://automationexercise.com/delete_account";

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        excelReader = new ExcelReader("FinalProject-AutomationExercise-Data.xlsx");

    }


    //---------------------------------------------------------------------
    public void clickON(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

}
