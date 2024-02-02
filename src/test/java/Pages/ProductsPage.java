package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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


    //-----------------------------------------------------------



    public String productID;



    public String productTitle;
    public String getProductID() {
        return productID;
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

/*    public void addRandomProductToCart(){
        if(!addToCartProductsList.isEmpty()){
            Random random = new Random();
            int randomAddToCartIndex = random.nextInt(addToCartProductsList.size());

            WebElement randomProduct = addToCartProductsList.get(randomAddToCartIndex);
            productTitle = randomProduct.getText();
            WebElement addToCartButton = randomProduct.findElement(By.linkText("Add to cart"));
            clickON(addToCartButton);
        }

    }*/

    public void clickRandomButtonInsideSingleProduct(List<WebElement> singleProductElements) {
        if (!singleProductElements.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(singleProductElements.size());

            WebElement randomSingleProduct = singleProductElements.get(randomIndex);

            // Find the button with id "button" inside the selected single-product element
            WebElement buttonElement = randomSingleProduct.findElement(By.id("button"));

            // Click on the button
            buttonElement.click();
        } else {
            System.out.println("No single-products elements found");
        }
    }

    public void clickOnContinueShoppingButton(){
        continueShoppingButton.click();
    }




}
