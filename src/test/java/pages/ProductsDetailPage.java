package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

public class ProductsDetailPage {

    private WebDriver driver;
    private WaitUtils wait;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartBtn;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeBtn;

    @FindBy(css = "a.shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(css = "span.shopping_cart_badge")
    private WebElement cartBadge;

    public ProductsDetailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public ProductsDetailPage addToCart() {
        wait.safeClick(addToCartBtn);
        wait.waitVisible(removeBtn);
        wait.waitVisible(cartBadge);
        return this;
    }

    public CartPage openCart() {
        wait.safeClick(cartIcon);
        wait.waitForUrlContains("cart.html");
        return new CartPage(driver);
    }
}
