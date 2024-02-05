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
    @FindBy(id = "search_product")
    public WebElement searchProductField;

    @FindBy(id = "submit_search")
    public WebElement searchButton;

    @FindBy(className = "single-products")
    public List<WebElement> allProductsOverlay;
    @FindBy(xpath = "//a[contains(@href, '/category_products/')]")
    public List<WebElement> allProductsCategories;
    @FindBy(xpath = "//a[contains(@href, '/brand_products/')]")
    public List<WebElement> allBrandList;


    //-----------------------------------------------------------



    public String productID;
    public String addToCartProductID;
    public String categoryURL;
    public String brandURL;
    public String brandTitle;
    public String addedProductID = "/product_details/" + addToCartProductID;



    public String productTitle;
    public String categoryTitle;
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

    public void inputSearchProduct(String product){
        searchProductField.clear();
        searchProductField.sendKeys(product);
    }

    public String randomProductTitle(){
        if (allProductsOverlay.size() > 0) {
            Random random = new Random();
            int randomIndex = random.nextInt(allProductsOverlay.size());
            WebElement randomElement = allProductsOverlay.get(randomIndex);

            // Get the text inside the <p> tag of the chosen element
            WebElement pElement = randomElement.findElement(By.tagName("p"));
            String textInsideP = pElement.getText();
            System.out.println("Randomly chosen text inside <p> tag: " + textInsideP);
            return textInsideP;
        } else {
            System.out.println("No products found on the page.");
            return ""; // or handle it according to your requirements
        }
    }

    public boolean searchedProductsAreVisible(String searchedProductName){
        boolean isDisplayed = true;
        for(WebElement product: allProductsOverlay){
            if(!product.findElement(By.tagName("p")).getText().equals(searchedProductName)){
                isDisplayed = false;
                break;
            }
        }
        return isDisplayed;
    }

    public void selectRandomCategoryProduct() {
        Random random = new Random();

        // Check if there are any category products
        if (allProductsCategories.isEmpty()) {
            System.out.println("No category products found.");
        }

        // Select a random category brand link
        int randomIndex = random.nextInt(allProductsCategories.size());
        WebElement randomCategoryProduct = allProductsCategories.get(randomIndex);
        categoryURL = randomCategoryProduct.getAttribute("href");


        // Get the text of the selected brand product link
         categoryTitle = randomCategoryProduct.getText();

        // Click on the selected category product link
        clickON(randomCategoryProduct);

    }

    public void selectRandomBrandProducts() {
        Random random = new Random();

        // Check if there are any category products
        if (allBrandList.isEmpty()) {
            System.out.println("No brand products found.");
        }

        // Select a random category product link
        int randomIndex = random.nextInt(allBrandList.size());
        WebElement randomBrandProduct = allBrandList.get(randomIndex);
        brandURL = randomBrandProduct.getAttribute("href");


        // Get the text of the selected category product link
        brandTitle = randomBrandProduct.getText();

        // Click on the selected brand product link
        clickON(randomBrandProduct);

    }

    public void clickOnSearchButton(){
        searchButton.click();
    }






}
