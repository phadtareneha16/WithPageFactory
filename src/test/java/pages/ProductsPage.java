package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

public class ProductsPage {

    private WebDriver driver;
    private WaitUtils wait;

    @FindBy(css = "span.title")
    private WebElement pageTitle;

    @FindBy(css = "a#item_4_title_link")
    private WebElement backpackTitleLink;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackBtn;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeBackpackBtn;

    @FindBy(css = "a.shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(css = "span.shopping_cart_badge")
    private WebElement cartBadge;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);

        // confirm on products page
        wait.waitForUrlContains("inventory.html");
        wait.waitVisible(pageTitle);
    }

    public String getTitle() {
        return wait.getTextWhenVisible(pageTitle);
    }

    // Most stable: add directly from products page
    public ProductsPage addBackpackToCart() {
        wait.safeClick(addBackpackBtn);
        wait.waitVisible(removeBackpackBtn);
        wait.waitVisible(cartBadge);
        return this;
    }

    // Open Backpack details page (wait belongs here, NOT in constructor of next page)
    public ProductsDetailPage openBackPackDetails() {
        wait.safeClick(backpackTitleLink);
        wait.waitForUrlContains("inventory-item.html");
        return new ProductsDetailPage(driver);
    }

    public CartPage openCart() {
        wait.safeClick(cartIcon);
        wait.waitForUrlContains("cart.html");
        return new CartPage(driver);
    }
}
