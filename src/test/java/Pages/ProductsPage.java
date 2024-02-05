package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ProductsPage extends BaseTest {
    public ProductsPage(){
        PageFactory.initElements(driver, this);
    }


    @FindBy(linkText = "View Product")
    public List<WebElement> productsList;

    @FindBy(className = "single-products")
    public List<WebElement> addToCartProductsList;

    @FindBy(css = "btn.btn-success.close-modal.btn-block")
    public WebElement continueShoppingButton;

    @FindBy(css = "a[href='/view_cart']")
    public WebElement cartLink;

    @FindBy(css = ".title.text-center")
    public WebElement centralProductsTitle;

    @FindBy(xpath = "//u[normalize-space()='View Cart']")
    public WebElement viewCartPopup;

    @FindBy(css = "a[href='/login']")
    public WebElement signUpLoginLink;


    //-----------------------------------------------------------



    public String productID;
    public String addToCartProductID;
    public String addedProductID = "/product_details/" + addToCartProductID;



    public String productTitle;
    public String getProductID() {
        return productID;
    }
    public void clickOnSignupLoginLink(){
        signUpLoginLink.click();
    }
    public String getProductTitle() {
        return productTitle;
    }
    public int getProductCount(){
        return productsList.size();
    }

    public void clickOnCartLink(){
        cartLink.click();
    }

    public void clickOnRandomProduct(){
        if(productsList != null && !productsList.isEmpty()){
            Random random = new Random();
            int randomItemIndex = random.nextInt(productsList.size());

            WebElement randomProduct = productsList.get(randomItemIndex);
            productID = randomProduct.getAttribute("href");
            clickON(randomProduct);
        }else{
            System.out.println("No products on page");
        }
    }

    public void addRandomProductToCart(){
        if(!addToCartProductsList.isEmpty()){
            Random random = new Random();
            int randomAddToCartIndex = random.nextInt(addToCartProductsList.size());

            WebElement randomProduct = addToCartProductsList.get(randomAddToCartIndex);
            addToCartProductID = randomProduct.getAttribute("data-product-id");
            WebElement addToCartButton = randomProduct.findElement(By.linkText("Add to cart"));
            clickON(addToCartButton);
        }

    }

    public void clickRandomButtonInsideSingleProduct(List<WebElement> singleProductElements) {
        if (!singleProductElements.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(singleProductElements.size());

            WebElement randomSingleProduct = singleProductElements.get(randomIndex);
            WebElement buttonElement = randomSingleProduct.findElement(By.id("button"));

            buttonElement.click();
        } else {
            System.out.println("No single-products elements found");
        }
    }

/*    public void clickOnContinueShoppingButton(){
        continueShoppingButton.click();
    }*/

/*    public void clickOnContinueShoppingButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.switchTo().frame(0);
        WebElement continueButton = driver.findElement(By.cssSelector("btn.btn-success.close-modal.btn-block"));
        continueButton.click();
    }*/

    public void clickOnContinueShoppingButton(){
        //driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        By continueButtonLocator = By.xpath("/html[1]/body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/button[1]");
        WebElement continueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(continueButtonLocator));
        clickON(continueButton);
    }

    public void clickOnViewCartPopup(){
        viewCartPopup.click();
    }




}
