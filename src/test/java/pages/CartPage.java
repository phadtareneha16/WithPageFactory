package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

public class CartPage {

    private WebDriver driver;
    private WaitUtils wait;

    @FindBy(css = "span.title")
    private WebElement title;

    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);

        wait.waitForUrlContains("cart.html");
        wait.waitVisible(title);
    }

    public String getTitle() {
        return wait.getTextWhenVisible(title);
    }

    public CheckoutInfoPage clickCheckout() {
        wait.safeClick(checkoutBtn);
        return new CheckoutInfoPage(driver);
    }
}
