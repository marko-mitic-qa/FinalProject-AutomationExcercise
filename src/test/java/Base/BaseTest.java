package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class BaseTest {

    public static WebDriver driver;
    public ExcelReader excelReader;

    public HomePage homePage;
    public SignUpLogInPage signUpLogInPage;
    public SignUpPage signUpPage;
    public ProductsPage productsPage;
    public AccountCreatedPage accountCreatedPage;
    public AccountDeletedPage accountDeletedPage;

    //------------------------------------
    public String homepageURL = "https://automationexercise.com/";
    public String signUpLoginURL = "https://automationexercise.com/login";
    public String signupURL = "https://automationexercise.com/signup";
    public String accountCreatedURL = "https://automationexercise.com/account_created";
    public String accountDeletedURL = "https://automationexercise.com/delete_account";
    public String productsPageURL = "https://automationexercise.com/products";

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

    //testiraj da li radi ako se doda u svaku metodu
/*    public void removeGoogleAds() {
        String currentURL = driver.getCurrentUrl();

        // Check if the URL contains #google_vignette
        if (currentURL.contains("#google_vignette")) {
            clickOnHeader();
        }
    }

    private void clickOnHeader() {

        WebElement header = driver.findElement(By.id("dismiss-button"));
        header.click();
    }*/

/*    public void closeGoogleAdsIfPresent() {
        String homeUrl = "https://automationexercise.com/";
        String currentUrl = driver.getCurrentUrl();

        // Check if the current URL is the home URL with Google ads
        if (currentUrl.startsWith(homeUrl) && currentUrl.contains("#google_vignette")) {
            // Perform actions to close the ads (e.g., click on a close button)
            // You need to inspect the page source to find the correct element to interact with
            // For example, assume there is a close button with id "closeButton"
            WebElement closeButton = driver.findElement(By.id("closeButton"));
            if (closeButton.isDisplayed()) {
                closeButton.click();
            }

            // Optionally, wait for the ads to close before proceeding
            // You can use WebDriverWait for this purpose
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dismiss-button")));

            // After closing the ads, the URL should be without #google_vignette
            // Perform additional actions on the page as needed
        }
    }*/


    public static void removeGoogleAds() {
        // Get the current URL before removing ads
        //String currentUrl = driver.getCurrentUrl();

        // Check if Google Ads are present on the page
        if (areGoogleAdsPresent()) {
            // Execute JavaScript to close the ads
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
        }

        // Introduce a small delay to allow for any asynchronous operations
        try {
            Thread.sleep(3000); // Adjust the sleep duration as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Navigate back to the current URL to avoid appending #google_vignette
        //driver.navigate().to(currentUrl);
    }

    private static boolean areGoogleAdsPresent() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.endsWith("#google_vignette");
    }

}
